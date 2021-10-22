package spring.board.dao;

import java.sql.SQLException;
import java.util.List;

import spring.board.dto.BoardDTO;

public interface BoardDAO {

	// CRUD Create, Read, Update, Delete
	
	// 전체 게시글 글 수 가져오기 
	public int getArticleCount() throws SQLException;
	
	// [검색X] 전체 게시글 중 startRow, endRow 설정하여 설정한 만큼 게시글 목록 가져오기 
	public List<BoardDTO> getArticles(int start, int end) throws SQLException;
	
	// [검색O] 검색 게시글 수 가져오기 
	public int getSearchArticleCount(String sel, String search) throws SQLException;
	
	// [검색O] 검색된 게시글의 목록 가져오기 
	public List<BoardDTO> getSearchArticles(int start, int end, String sel, String search) throws SQLException;
	
	//
}
