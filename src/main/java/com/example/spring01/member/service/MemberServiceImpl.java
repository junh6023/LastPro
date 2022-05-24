package com.example.spring01.member.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring01.member.model.dao.MemberDAOImpl;


import com.example.spring01.member.model.dto.MemberVO;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ch.qos.logback.classic.Logger;

// 현재 클래스를 스프링에서 관리하는 service bean으로 등록
@Service
public class MemberServiceImpl implements MemberService {
	
	// MemberDAOImpl 객체를 스프링에서 생성하여 주입시킴
	@Autowired
	MemberDAOImpl memberDao;
	
	// 01. 전체 회원 목록 조회
	@Override
	public List<MemberVO> memberList() {
		return memberDao.memberList();
	}
	
	// 02. 회원 등록
	@Override
	public void insertMember(MemberVO vo) {
		memberDao.insertMember(vo);
	}
	
	// 03. 회원 정보 상세 조회 
	@Override
	public MemberVO viewMember(String userId) {
		return memberDao.viewMember(userId);
	}
	// 04. 회원 정보 수정 처리
	@Override
	public void deleteMember(String userId) {
		memberDao.deleteMember(userId);
	}
	// 05. 회원 정보 삭제 처리
	@Override
	public void updateMember(MemberVO vo) {
		memberDao.updateMember(vo);
	}
	// 06. 회원 정보 수정 및 삭제를 위한 비밀번호 체크
	@Override
	public boolean checkPw(String userId, String userPw) {
		return memberDao.checkPw(userId, userPw);
	}
	// 로그인 체크
	@Override
	public MemberVO memberlogin(MemberVO vo) {
		// TODO Auto-generated method stub
		System.out.println("여기오나 ?");
		
		return memberDao.memberlogin(vo);
	}
//	//팔로우 체크 
//	@Override
//	public int follow(FollowVO fVo) {
//		System.out.println("follow 서비스로직");
//		return memberDao.follow(fVo);
//		
//	}
//	//언팔로우 체크 
//	@Override
//	public int unfollow(FollowVO fVo) {
//	System.out.println("unfollow 서비스로직");
//		return memberDao.unfollow(fVo);
//		
//	}
//
//	@Override
//	public List<FollowVO> followlist() {
//		System.out.println("mylist 서비스 로직");
//		return memberDao.followlist();
//	}

	@Override
	public String kakaoLogin(String authorizedCode) {
		
		return memberDao.kakaoLogin(authorizedCode);
	}

	@Override
	public MemberVO getUserInfo(String access_Token) {
		HashMap<String, Object> userInfo = new HashMap<String, Object>();
		String reqURL = "https://kapi.kakao.com/v2/user/me";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Authorization", "Bearer " + access_Token);
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";
			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
			JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
			String nickname = properties.getAsJsonObject().get("nickname").getAsString();
			String email = kakao_account.getAsJsonObject().get("email").getAsString();
			userInfo.put("nickname", nickname);
			userInfo.put("email", email);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// catch 아래 코드 추가.
		System.out.println(memberDao.findkakao(userInfo));
		MemberVO result = memberDao.findkakao(userInfo);
		// 위 코드는 먼저 정보가 저장되있는지 확인하는 코드.
		System.out.println("여기가 맞나 ?야발탱 ");
		System.out.println("S:" + result);
		
		
		if(result==null) {
		// result가 null이면 정보가 저장이 안되있는거므로 정보를 저장.
			memberDao.kakaoinsert(userInfo);
			// 위 코드가 정보를 저장하기 위해 Repository로 보내는 코드임.
			return memberDao.findkakao(userInfo);
			// 위 코드는 정보 저장 후 컨트롤러에 정보를 보내는 코드임.
			//  result를 리턴으로 보내면 null이 리턴되므로 위 코드를 사용.
		} else {
			return result;
			// 정보가 이미 있기 때문에 result를 리턴함.
		}
	}
	//토큰
	@Override
	public String getAccessToken(String authorize_code) {
		String access_Token = "";
		String refresh_Token = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";

		try {
			URL url = new URL(reqURL);
            
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// POST 요청을 위해 기본값이 false인 setDoOutput을 true로
            
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
            
			sb.append("&client_id=caf99741ffa626e59841122a4ac6c909"); //본인이 발급받은 key
			sb.append("&redirect_uri=http://54.87.120.41:8080/com/member/kakao"); // 본인이 설정한 주소
            
			sb.append("&code=" + authorize_code);
			bw.write(sb.toString());
			bw.flush();
            
			// 결과 코드가 200이라면 성공
			int responseCode = conn.getResponseCode();
			
			System.out.println("responseCode1 : " + responseCode);
            
			// 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";
            
			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);
            
			// Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
            
			access_Token = element.getAsJsonObject().get("access_token").getAsString();
			refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
            
			System.out.println("access_token : " + access_Token);
			System.out.println("refresh_token : " + refresh_Token);
            
			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return access_Token;
	}

	@Override
	public MemberVO findnaverid(MemberVO vo) {
		
		System.out.println("findnaver서비스 로직");
		return memberDao.findnaverid(vo);
	}

	@Override
	public void naverinser(MemberVO vo) {
		System.out.println("naverinsert서비스로직");
		memberDao.naverinser(vo);
		
	}

	@Override
	public List<MemberVO> rankList() {
		System.out.println("ranklist서비스 로직");
		return memberDao.rankList();
	}

	@Override
	public int nameCheck(String u_id) {
		System.out.println("namecheck()");
		return memberDao.nameCheck(u_id);
	}
	}




