package spring.board.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.board.service.BoardServiceImpl;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardServiceImpl boardService = null;
	
	@RequestMapping("list.do")	// list.do?pageNum=2 list.do ->
//	public String list(HttpServletRequest requsest) {
	public String list(String pageNum, String sel, String search, Model model) throws SQLException {
		
		// 해당 페이지에 맞는 화면에 뿌려줄 게시글 가져와서 view 전달
		Map<String, Object> result = null;
		
		// 전체 게시글 sel, search == null
		if (sel == null || search == null) {								// 검색X 
			result = boardService.getArticleList(pageNum);	
			
		// 검색 게시글 sel, search != null
		} else {
			result = boardService.getArticleSearch(pageNum, sel, search);	// 검색O 
		}
		
		// view에 전달할 데이터 보내기
		model.addAttribute("pageSize", result.get("pageSize"));
		model.addAttribute("pageNum", result.get("pageNum"));
		model.addAttribute("currentPage", result.get("currentPage"));
		model.addAttribute("startRow", result.get("startRow"));
		model.addAttribute("endRow", result.get("endRow"));
		model.addAttribute("articleList", result.get("articleList"));
		model.addAttribute("count", result.get("count"));
		model.addAttribute("number", result.get("number"));
		model.addAttribute("sel", result.get("sel"));
		model.addAttribute("search", result.get("search"));
		
		return "board/list";
	}
	
}
