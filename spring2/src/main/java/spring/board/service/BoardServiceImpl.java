package spring.board.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.board.dao.BoardDAOImpl;
import spring.board.dto.BoardDTO;

@Service	// component-scan 이요해 자동으로 bean으로 등록(즉, 객체생성) 
public class BoardServiceImpl implements BoardService {

	// 자동으로 DAO 객체생성하기.
	@Autowired
	private BoardDAOImpl boardDAO = null;
	
	
	// 게시글 목록 가져오기 (list 검색X)
	@Override
	public Map<String, Object> getArticleList(String pageNum) throws SQLException {
		
		// ** 게시글 페이지 관련 정보 세팅 ** 
		// 한페이지에 보여줄 게시글의 수 
		int pageSize = 10; 
		// 현재 페이지 번호  
		if(pageNum == null){ // list.do 라고만 요청했을때, 즉 pageNum 파라미터 안넘어왔을때.
			pageNum = "1";
		}
		
		// 현재 페이지에 보여줄 게시글 시작과 끝 등등 정보 세팅 
		int currentPage = Integer.parseInt(pageNum); // 계산을 위해 현재페이지 숫자로 변환하여 저장 
		int startRow = (currentPage - 1) * pageSize + 1; // 페이지 시작글 번호 
		int endRow = currentPage * pageSize; // 페이지 마지막 글번호
		
		// 밖에서 사용가능하게 if문 시작 전에 미리 선언
		List<BoardDTO> articleList = null;  	// 전체(검색X) 게시글들 담아줄 변수
		int count = 0; 							// 전체(검색X) 글의 개수 
		int number = 0; 						// 브라우저 화면에 뿌려줄 가상 글 번호  
		
		count = boardDAO.getArticleCount();   	// DB에 저장되어있는 전체 글의 개수를 가져와 담기
		System.out.println("전체 게시글 count : " + count);
		// 글이 하나라도 있으면 글들을 다시 가져오기 
		if(count > 0){
			articleList = boardDAO.getArticles(startRow, endRow); 
		}
		
		number = count - (currentPage - 1) * pageSize; 	// 게시판 목록에 뿌려줄 가상의 글 번호  
		
		// Controller에게 전달해야되는 데이터가 많으니 HashMap<key, value> 로 저장해서 한번에 Controller에 전달하기.
		Map<String, Object> result = new HashMap<String, Object>();
		
		// Map result 변수에 페이징 처리 및 연산처리한 변수 값들 모두 넣어보내주기. 
		result.put("pageSize", pageSize);
		result.put("pageNum", pageNum);
		result.put("currentPage", currentPage);
		result.put("startRow", startRow);
		result.put("endRow", endRow);
		result.put("articleList", articleList);
		result.put("count", count);
		result.put("number", number);
		
		return result;
	}

	
	// 검색O 게시글 목록 list 가져오기 
	@Override
	public Map<String, Object> getArticleSearch(String pageNum, String sel, String search) throws SQLException {
		// ** 게시글 페이지 관련 정보 세팅 ** 
		// 한페이지에 보여줄 게시글의 수 
		int pageSize = 10; 
		// 현재 페이지 번호  
		if(pageNum == null){ // list.do 라고만 요청했을때, 즉 pageNum 파라미터 안넘어왔을때.
			pageNum = "1";
		}
		
		// 현재 페이지에 보여줄 게시글 시작과 끝 등등 정보 세팅 
		int currentPage = Integer.parseInt(pageNum); // 계산을 위해 현재페이지 숫자로 변환하여 저장 
		int startRow = (currentPage - 1) * pageSize + 1; // 페이지 시작글 번호 
		int endRow = currentPage * pageSize; // 페이지 마지막 글번호

		// 밖에서 사용가능하게 if문 시작 전에 미리 선언
		List<BoardDTO> articleList = null;  	// 전체(검색O) 게시글들 담아줄 변수
		int count = 0; 							// 전체(검색O) 글의 개수 
		int number = 0; 						// 브라우저 화면에 뿌려줄 가상 글 번호  
		
		count = boardDAO.getSearchArticleCount(sel, search);   // 검색된 DB에 저장되어있는 전체 글의 개수를 가져와 담기
		System.out.println("검색된 게시글 count : " + count);
		// 글이 하나라도 있으면 글들을 다시 가져오기 
		if(count > 0){
			articleList = boardDAO.getSearchArticles(startRow, endRow, sel, search); 
		}
		
		number = count - (currentPage-1) * pageSize; 	// 게시판 목록에 뿌려줄 가상의 글 번호  
		
		// Controller에게 전달해야되는 데이터가 많으니 HashMap<key, value> 로 저장해서 한번에 Conroller에 전달하기.
		Map<String, Object> result = new HashMap<String, Object>();
		
		// Map result 변수에 페이징 처리 및 연산처리한 변수 값들 모두 넣어보내주기. 
		result.put("pageSize", pageSize);
		result.put("pageNum", pageNum);
		result.put("currentPage", currentPage);
		result.put("startRow", startRow);
		result.put("endRow", endRow);
		result.put("articleList", articleList);
		result.put("count", count);
		result.put("number", number);
		
		return result;
	}

	
	
}
