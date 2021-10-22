package spring.member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j;
import spring.member.dto.MemberDTO;
import spring.member.service.MemberServiceImpl;

@Controller
@RequestMapping("/member/*")
@Log4j
public class MemberController {
	
	@Autowired
	private MemberServiceImpl memberService = null;

	// 회원가입 form 요청 메서드 
	@GetMapping("signupForm.do")						// GET 방식의 요청만 해당 어노테이션으로 들어옴.
	public String signupForm() {
		
		System.out.println("signupForm 요청!!!");
		log.info("=====================signup log ====================");
		
		return "member/signupForm";
	}
	
	// 회원가입 pro 처리 요청 메서드 
	@PostMapping("signupPro.do")
	public String signupPro(MemberDTO dto) throws SQLException {
		System.out.println("signupPro 요청!!!");
		// signupForm에서 입력받은 값 확인해보기 
//		System.out.println(dto.getId());
//		System.out.println(dto.getPw());
//		System.out.println(dto.getName());
//		System.out.println(dto.getAge());
//		System.out.println(dto.getEmail());
		
		// 비지니스 로직 처리 : 업무처리담당자 불러다가 일시킴 : 데이터 DB에 저장 
		memberService.addMember(dto);
		
		return "redirect:/member/signupPro";	// main 하고 경로 수정 
	}
	
	// 로그인 form 페이지 요청 메서드 
	@GetMapping("loginForm.do")
	public String loginForm() {
		
		System.out.println("loginForm 요청!!!");
		
		return "member/loginForm";
	}
	
	// 로그인 처리 요청 
	@PostMapping("loginPro.do")
	public String loginPro(MemberDTO dto, Model model, HttpSession session) throws SQLException {
		System.out.println("loginPro요청!!!");
		
		// 팀장아 id, pw 들어있는 dto 줄테니 DB(창고)에 전달해. 두개 일치하는지 결과 가져와봐~
		// 두개가 일치하면 session 속성추가해주고 결과도 좀 보고해봐.
		int result = memberService.idPwCheck(dto);
		System.out.println("result : " + result);
		
		// view한태 결과 돌려주고, view에서는 맞으면 main이동, 틀리면 history.go(-1) 뒤로가기 
		model.addAttribute("result", result);
		
		System.out.println("session sid : " + session.getAttribute("sid"));
		
		return "member/loginPro";
	}
	
	// 로그아웃 
	@GetMapping("logout.do")
	public String logout(HttpSession session) {
		
//		session.invalidate(); 	// 세션삭제 
		
		memberService.removeSessionAttr("sid");
		System.out.println(session.getAttribute("sid"));
		
		return "redirect:/member/main.do";		// main 페이지 컨트롤러로 다시 요청함 == <c:redirect url="/member/main.do" /> 와 같음
	}
	
	// main 요청메서드 
	@GetMapping("main.do")
	public String main() {
		
		return "member/main";
	}
	
	// mypage 요청 메서드 
	@GetMapping("mypage.do")
	public String mypage() {
		
		return "member/mypage";
	}
	
	// 회원정보 form 페이지 요청 
	@GetMapping("modifyForm.do")
	public String modifyForm(HttpSession session, Model model) throws SQLException {
		// DB에서 회원 정보 가져와 view에게 전달 
		// service에 id를 주고 해당 회원정보를 하나 가져오는 메서드가 필요
		
		// vers.1 id 주고 회원정보 가져오기 
//		String id = (String)session.getAttribute("sid");
//		MemberDTO member = memberService.selectMember(id);
		
		// vers.2 id 안주고 회원정보 가져오기 
		MemberDTO member = memberService.getMember();
		
		model.addAttribute("member", member);
		
		return "member/modifyForm";
	}
	
	// 회원정보 수정처리 요청 
	@PostMapping("modifyPro.do")
	public String modifyFrp(MemberDTO dto, HttpSession session, Model model) throws SQLException {
		
		String id = (String)session.getAttribute("sid");
		dto.setId(id);
		int result = memberService.modifyMember(dto);
		
		model.addAttribute("result", result);
		
		return "member/modifyPro";
	}
	
	// 회원 탈퇴 form 페이지 요청 
	@GetMapping("deleteForm")
	public String deleteForm() {
		
		return "member/deleteForm";
	}
	
	// 회원 탈퇴 Pro 처리 요청 
	@PostMapping("deletePro.do")
	public String deletePro(MemberDTO dto, HttpSession session, Model model) throws SQLException {
		
		// 넘어오는 파라미터는 pw밖에 없기 때문에, id/pw 체크와 레코드 삭제시 id 반드시 필요하여 session에서 꺼내서 체워주기 
		String id = (String)session.getAttribute("sid");
		dto.setId(id);										// dto에 넘어온 id 파라미터 담아주기.
		int result = memberService.deleteMember(dto);		// 삭제처리 - id,pw 맞는지 결과 받아오기 
		
		model.addAttribute("result", result);
		
		return "member/deletePro";
	}
	
	// [일반 팝업] id 중복 요청 처리 
	@GetMapping("confirmId.do")
	public String confirmId(MemberDTO dto, Model model) throws SQLException {
		// DB에 id 있는지 확인해서 view한테 넘겨주기 
		int result = memberService.idPwCheck(dto);
		
		model.addAttribute("result", result);
		model.addAttribute("trialId", dto.getId());		// confirmId 요청시 보낸 id값을 view까지 전달
		
		return "member/confirmId";
	}
	
	
	// [Ajax] id 중복확인 요청 메서드 
//	@RequestMapping("ajaxIdAvail.do")
//	@ResponseBody		// 요청한 jsp파일의 <body>태그의 안에 다시 return 해줌. 응답을 요청한곳의 <body>태그의 안으로 보내겠다.
//	public String ajaxIdAvail(MemberDTO dto) throws SQLException {
//		System.out.println("id : " + dto.getId());
//		// db에 id주고 중복되는지 결과 얻어와야함.
//		int result = memberService.idPwCheck(dto);	// DB에 id가 있으면 1, 없으면 0
//		String data = "";							// 결과를 문자열로 돌려줄때 담아놓을 변수 미리 선언 
//		if (result == 1) {							// DB에 중복된 아이디가 있으면 
//			data = "이미 사용중인 ID 입니다.";			// 해당 문자열 저장해서 return해주고 -> 한글 깨짐...
//		} else {									// DB에 중복된 아이디가 없으면 
//			data = "사용 가능한 ID 입니다.";				// 해당 문자열 저장해서 return해주고 -> 한글 깨짐...
//		}
//		
//		return data;
//	}
	
	@RequestMapping("ajaxIdAvail.do")
	public ResponseEntity<String> ajaxIdAvail(MemberDTO dto) throws SQLException {
		System.out.println("controller id : " + dto.getId());
		// db에 id주고 중복되는지 결과 얻어와야함.
		int result = memberService.idPwCheck(dto);	// DB에 id가 있으면 1, 없으면 0
		String data = "";							// 결과를 문자열로 돌려줄때 담아놓을 변수 미리 선언 
		if (result == 1) {							// DB에 중복된 아이디가 있으면 
			data = "이미 사용중인 ID 입니다.";			// 해당 문자열 저장해서 return해주고 
		} else {									// DB에 중복된 아이디가 없으면 
			data = "사용 가능한 ID 입니다.";				// 해당 문자열 저장해서 return해주고 
		}
		HttpHeaders respHeaders = new HttpHeaders();	// 헤더 객체 만들어주기 이유: 한글깨짐 방지 추가해주기위해.
		respHeaders.add("Content-type", "text/html;charset=UTF-8");	// 헤더 정보 추가(charset=UTF-8로 한글깨짐 바지하여 결과물 응답해주기)
		
		// return data; 	// 한글깨짐 
		return new ResponseEntity<String>(data, respHeaders, HttpStatus.OK);
	}
	
	
	
}
