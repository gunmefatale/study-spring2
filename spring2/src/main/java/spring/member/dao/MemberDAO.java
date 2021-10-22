package spring.member.dao;

import java.sql.SQLException;

import spring.member.dto.MemberDTO;

public interface MemberDAO {
	
	// 회원가입 (추상메서드)
	public void insertMember(MemberDTO dto) throws SQLException;
	// 로그인 체크 (id, pw 확인)
	public int idPwCheck(MemberDTO dto) throws SQLException;
	// 전체 회원 데이터 조회 
	// 회원 한 명의 데이터 조회 
	public MemberDTO selectMember(String id) throws SQLException;
	// 회원 데이터 수정 
	public void modifyMember(MemberDTO dto) throws SQLException;
	// 회원 탈퇴 (데이터 삭제)
	public void deleteMember(MemberDTO dto) throws SQLException;
	// 아이디 사용가능 여부 체크 
}
