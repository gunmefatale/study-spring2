package spring.board.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.board.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	// [검색X] 게시글 전체 갯수 가져오기 메서드 
	@Override
	public int getArticleCount() throws SQLException {
		// 게시판 전체글 개수 가져오기 (임시로 기존에 있는 board table 사용하기) 
		int result = sqlSession.selectOne("board.countAll");
		
		return result;
	}

	// [검색X] 한 페이지 게시글 목록 가져오기 
	@Override
	public List<BoardDTO> getArticles(int start, int end) throws SQLException {
		
		HashMap map = new HashMap();
		// HashMap에 매개면수 start 담아주기 
		map.put("start", start);
		// HashMap에 매개면수 end 담아주기 
		map.put("end", end);
		
		List<BoardDTO> boardList = sqlSession.selectList("board.getArticles", map);
		
		return boardList;
	}

	// [검색O] 게시글 총 수 가져오기 
	@Override
	public int getSearchArticleCount(String sel, String search) throws SQLException {
		
		HashMap map = new HashMap();
		
		map.put("sel", sel);
		map.put("search", search);
		
		int result = sqlSession.selectOne("board.countSearch", map);
		
		return result;
	}

	// [검색O] 검색된 게시글 목록 가져오기  
	@Override
	public List<BoardDTO> getSearchArticles(int start, int end, String sel, String search) throws SQLException {
		
		HashMap map = new HashMap();
		
		map.put("start", start);
		map.put("end", end);
		map.put("sel", sel);
		map.put("search", search);
		
		List<BoardDTO> boardList = sqlSession.selectList("board.getSearchArticles", map);
		
		return boardList;
	}
	
}
