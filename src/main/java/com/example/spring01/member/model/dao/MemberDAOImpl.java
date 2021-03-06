package com.example.spring01.member.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.xml.stream.events.Namespace;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;



import com.example.spring01.member.model.dto.MemberVO;


// 현재 클래스를 DAO bean으로 등록시킴
@Repository
public class MemberDAOImpl implements MemberDAO {
	
	// SqlSession 객체를 스프링에서 생성하여 주입시켜준다.
	// 의존관계 주입(Dependency Injection, DI)
	// 느스한 결함
	// IoC(Inversion of Control, 제어의 역전)
	@Inject
	// Inject애노테이션이 없으면 sqlSession은 null상태이지만
	// Inject애노테이션이 있으면 외부에서 객체를 주입시켜주게 된다. 
	// try catch문, finally문, 객체를 close할 필요가 없어졌다.
	SqlSession sqlSession;
	
	// 01. 전체 회원 목록 조회
	@Override
	public List<MemberVO> memberList() {
		return sqlSession.selectList("member.memberList");
	}
	// 02. 회원 등록
	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert("member.insertMember", vo);
	}
	// 03. 회원 정보 상세 조회
	@Override
	public MemberVO viewMember(String userId) {
		return sqlSession.selectOne("member.viewMember", userId);
	}
	// 04. 회원 정보 수정 처리
	@Override
	public void deleteMember(String userId) {
		sqlSession.delete("member.deleteMember",userId);
	}
	// 05. 회원 정보 삭제 처리
	@Override
	public void updateMember(MemberVO vo) {
		sqlSession.update("member.updateMember", vo);

	}
	// 06. 회원 정보 수정 및 삭제를 위한 비밀번호 체크
	@Override
	public boolean checkPw(String userId, String userPw) {
		boolean result = false;
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("userPw", userPw);
		int count = sqlSession.selectOne("member.checkPw", map);
		if(count == 1) result= true;
		return result;
	}
	//07회원 가입 체크 

	@Override
	public MemberVO memberlogin(MemberVO vo) {
		System.out.println("로그인 다오 impl");
		
		MemberVO res = null;
		try {
			System.out.println("하핫");
			res = sqlSession.selectOne("member.memberlogin", vo);
			System.out.println("로그인 아이디값"+res.getU_id());
			System.out.println("로그인 pw 값"+res.getU_pw());
			System.out.println("다오 iml res"+res);
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return res;
	}
//	//마이바티스 mapper 에 접근 하도록 만들어야함 
//	@Override
//	public int follow(FollowVO fVo) {
//		
//		int rsult = sqlSession.insert("member.follow", fVo);
//		
//		return rsult;
//	}
//	@Override
//	public int unfollow(FollowVO fVo) {
//		int result = sqlSession.delete("member.unfollow", fVo);
//		
//		
//		
//		return result;
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public List<FollowVO> followlist() {
//		return sqlSession.selectList("member.followlist");
//		
//	}
//	@Override
//	public String kakaoLogin1(String authorizedCode) {
//	sqlSession.insert("member.kakaoLogin",authorizedCode);
//	return  sqlSession.insert("member.kakaoLogin",authorizedCode);
//	
//	}
	
	
	
	
	



	
	//정보 확인
	public MemberVO findkakao(HashMap<String, Object> userInfo) {
		System.out.println("rn:"+ userInfo.get("nickname"));
		System.out.println("rn:"+ userInfo.get("email"));

		return sqlSession.selectOne("member.findkakao",userInfo); 
	}
	//정보 저장
	public void kakaoinsert(HashMap<String, Object> userInfo) {
	sqlSession.insert("member.kakaoinsert",userInfo);
		
	}
	@Override
	public String kakaoLogin(String authorizedCode) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MemberVO getUserInfo(String access_Token) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//정보 찾기
	public MemberVO findnaverid(MemberVO vo) {
		System.out.println("nv:"+ vo.getU_name());
		System.out.println("ne:"+ vo.getU_id());
		MemberVO nresult =sqlSession.selectOne("member.findnaverid",vo); 
		return nresult;
	}
	
	//정보 저장
	@Override
	public void naverinser(MemberVO vo) {
		System.out.println("네이버 가입 db다오");
		sqlSession.insert("member.naverinsert",vo);
		
	}
	@Override
	public List<MemberVO> rankList() {
		System.out.println("ranklist");
		return sqlSession.selectList("member.rankList");
	}
	public int nameCheck(String u_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.nameCheck",u_id);
	}
	
}
