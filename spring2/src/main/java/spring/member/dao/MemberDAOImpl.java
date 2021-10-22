package spring.member.dao;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.member.dto.MemberDTO;

@Repository	// DB 관련 작업(persistence 영역)을 하는 부품이라고 알려주는 어노테이션  
public class MemberDAOImpl implements MemberDAO {		// 데이터 담당자 

	@Autowired	// vers.2 자동 주입 
	private SqlSessionTemplate sqlSession = null;
	
	
	// vers.1 set 메서드로 주입 방법 : 주입받는곳에 변수, set메서드 필요 
//	private SqlSessionTemplate sqlSession = null;
//	
//	public void setSqlSession(SqlSessionTemplate sqlSession) {
//		this.sqlSession = sqlSession;
//	}
	
	
	@Override
	public void insertMember(MemberDTO dto) throws SQLException {
		// sqlSession.insert(); sqlSession.selectOne();
		
		// 팀장이 데이터 주면서 DB에 저장하라고 했어요 -> 창고 관리자한테 데이터 주며 DB에 잘 저장해라~~~
		sqlSession.insert("member.insertMember", dto);
	
	
	}

	// DB에서 id,pw check 
	@Override
	public int idPwCheck(MemberDTO dto) throws SQLException {
		// 팀장이 dto 주면서 DB에 두개 같은애가 있는지 체크해라~ 결과는 int로 돌려달래 
		int result = sqlSession.selectOne("member.idPwCheck", dto);
		
		// 일치 : 1 / 불일치 : 0
		return result; // 결과 팀장에게 돌려주기 
	}

	// 회원 1명 정보 가져오기 
	@Override
	public MemberDTO selectMember(String id) throws SQLException {
		// 쿼리문 실행하고 resultType에 맞게 데이터 넣어서 해당 타입으로 return 해줌 
		MemberDTO member = sqlSession.selectOne("member.selectMember", id);	
		
		return member;
	}

	// 회원정보 수정하기. 
	@Override
	public void modifyMember(MemberDTO dto) throws SQLException {
		
		sqlSession.update("member.updateMember", dto);
		
	}

	
	// 회원 삭제 
	@Override
	public void deleteMember(MemberDTO dto) throws SQLException {
		
		sqlSession.delete("member.deleteMember", dto);
		
	}

}
