package spring.member.service;

import java.sql.SQLException;

import spring.member.dto.MemberDTO;

public interface MemberService {
	
	// DB연결되는 것은 모두 'throws SQLException' 해줘야 한다.
	
	// 회원 가입 
	public void addMember(MemberDTO dto) throws SQLException;
	
	// id,pw 체크(로그인) 
	public int idPwCheck(MemberDTO dto) throws SQLException;
	
	// 세션삭제 
	public void removeSessionAttr(String sessionName);
	
	// vers.1 id 주고 회원정보 1개 가져오기 
	public MemberDTO selectMember(String id) throws SQLException;	
	// vers.2 id 안주고 회원정보 1개 가져오기 
	public MemberDTO getMember() throws SQLException;
	
	// 회원정보 수정 
	public int modifyMember(MemberDTO dto) throws SQLException;
	
	// 회원탈퇴 
	public int deleteMember(MemberDTO dto) throws SQLException;
	
	// id 중복여부 check 메서드 
	public int idCheck(MemberDTO dto) throws SQLException;
}
