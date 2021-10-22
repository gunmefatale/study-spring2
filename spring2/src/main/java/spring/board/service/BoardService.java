package spring.board.service;

import java.sql.SQLException;
import java.util.Map;


public interface BoardService {

	// CRUD Create, Read, Update, Delete
	
	// 게시판 list 페이지 목록 가져오기 (list 검색X)
	public Map<String, Object> getArticleList(String pageNum) throws SQLException;
	// 게시글 검색한 list 페이지 목록 가져오기 (list 검색O)
	public Map<String, Object> getArticleSearch(String pageNum, String sel, String search) throws SQLException;
	// 게시글 글 1개 가져오기 (content)
	// 게시글 등록 처리 (writeForm)
	// 게시글 수정 처리 (modifyForm)
	// 게시글 삭제 처리 (deleteForm)
	
}
