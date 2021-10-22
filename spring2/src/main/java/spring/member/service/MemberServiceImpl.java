package spring.member.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import spring.member.dao.MemberDAOImpl;
import spring.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {	// 팀장 

	@Autowired
	private MemberDAOImpl memberDAO = null;
	
	
	// 회원 가입
	@Override
	public void addMember(MemberDTO dto) throws SQLException { 
		// 데이터 줄게요, 회원가입 시켜주세요~ : 데이터 담당자에게 
		memberDAO.insertMember(dto);
	}
	
	// 로그인시 id,pw 체크 
	@Override
	public int idPwCheck(MemberDTO dto) throws SQLException {
		// DB에 id,pw 일치하는지 확인
		int result = memberDAO.idPwCheck(dto);
		// 결과 받아서 일치하면 session속성 sid 추가 
		if (result == 1) {
			// session에 sid로 속성추가 
			RequestContextHolder.getRequestAttributes().setAttribute("sid", dto.getId(), RequestAttributes.SCOPE_SESSION);
		}
		
		
		// 사장님(Controller)한테 체크 결과도 보고 
		return result;
	}

	// 세션 삭제 
	@Override
	public void removeSessionAttr(String sessionName) {
		
		RequestContextHolder.getRequestAttributes().removeAttribute(sessionName, RequestAttributes.SCOPE_SESSION);
	}

	// vers.1 id주고 회원정보 1개 가져오기 
	@Override
	public MemberDTO selectMember(String id) throws SQLException {
		// DB에 넘겨받은 id 주면서 정보 가져와라 ~ 
		MemberDTO member = memberDAO.selectMember(id);
		
		return member;
	}

	// vers.2 id 안주고 회원정보 1개 가져오기 
	@Override
	public MemberDTO getMember() throws SQLException {
		// String id = (String)session.getAttribute("sid"); 한거와 같음.
		String id = (String)RequestContextHolder.getRequestAttributes().getAttribute("sid", RequestAttributes.SCOPE_SESSION);
		MemberDTO member = memberDAO.selectMember(id);
		return member;
	}

	// 회원정보 수정 
	@Override
	public int modifyMember(MemberDTO dto) throws SQLException {
	
		// id, pw 검사해서, 맞으면 수정 
		int result = memberDAO.idPwCheck(dto);		// 일치 = 1, 불일치 = 0
		
		if (result == 1) {
			memberDAO.modifyMember(dto);
		}
		
		return result;
	}

	// 회원 탈퇴
	@Override
	public int deleteMember(MemberDTO dto) throws SQLException {
		// id, pw 체크하고 맞으면 삭제. 틀리면 삭제X 
		// 체크 결과는 Controller에 return.
		int result = memberDAO.idPwCheck(dto);		// 일치 = 1, 불일치 = 0
		
		if (result == 1) {
			memberDAO.deleteMember(dto);
			// session 삭제 
			
			// 세션 삭제 메서드 만들지 않았으면 아래 처럼
//			RequestContextHolder.getRequestAttributes().removeAttribute("sid", RequestAttributes.SCOPE_SESSION);
			
			// 위 세션 삭제한거 불러서 삭제하기.
			removeSessionAttr("sid");
		}
		
		
		return result;
	}

	// id 중복확인 check 메서드
	@Override
	public int idCheck(MemberDTO dto) throws SQLException {
		
		int result = memberDAO.idPwCheck(dto);		// 일치 = 1, 불일치 = 0
		
		
		return result;
	}
	
	

}
