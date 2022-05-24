package com.example.spring01.member.service;

import java.util.HashMap;
import java.util.List;



import com.example.spring01.member.model.dto.MemberVO;


public interface MemberService {
	
	// 회원 목록 
	public List<MemberVO> memberList();
	// 회원 입력
	public void insertMember(MemberVO vo);
	// 회원 정보 상세보기
	public MemberVO viewMember(String userId);
	// 회원삭제
	public void deleteMember(String userId);
	// 회원정보 수정
	public void updateMember(MemberVO vo);
	// 비밀번호 체크
	public boolean checkPw(String u_id, String u_pw);
	//로그인 체크
	public MemberVO memberlogin(MemberVO vo);

	/*
	 * //팔로우 하기 public int follow(FollowVO fVo); //언팔로우하기 public int
	 * unfollow(FollowVO fVo); // 마이 팔로우 리스트 public List<FollowVO> followlist();
	 */
	//카카오 로그인
	public String kakaoLogin(String authorizedCode);
	//
	public MemberVO getUserInfo(String access_Token);
	
	public String getAccessToken(String code);
	//네이버 체크
	public MemberVO findnaverid(MemberVO vo);
	//네이버 db
	public void naverinser(MemberVO vo);
	//랭 리스트
	public List<MemberVO> rankList();
	//아이디 체크
	public int nameCheck(String u_id);
	

	
	
	
	
}
