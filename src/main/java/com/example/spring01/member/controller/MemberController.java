package com.example.spring01.member.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.spring01.member.model.dto.MemberVO;
import com.example.spring01.member.service.MemberService;

@Controller // 현재의 클래스를 controller bean에 등록시킴
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	// MemberService 객체를 스프링에서 생성하여 주입시킴

	@Autowired
	MemberService memberService;
	
	
	
	
	

	// 이메일 인증
	@RequestMapping(value = "/mailCheck", method = RequestMethod.GET)
	@ResponseBody
	public String mailCheck(@RequestParam("sm_email") String sm_email) throws Exception {
		int serti = (int) ((Math.random() * (99999 - 10000 + 1)) + 10000);
		String from = "abcd@company.com";
		// 보내는 이 메일주소
		String to = sm_email;
		String title = "회원가입시 필요한 인증번호 입니다.";
		String content = "[인증번호] " + serti + " 입니다. <br/> 인증번호 확인란에 기입해주십시오.";
		String num = "";
		
		

	
		try {
			
//			MimeMessage mail = mailSender.createMimeMessage();
//			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
//			mailHelper.setFrom(from);
//			mailHelper.setTo(to);
//			mailHelper.setSubject(title);
//			mailHelper.setText(content, true);
//			mailSender.send(mail);
//			num = Integer.toString(serti);
//			
		} catch (Exception e) {
			num = "error";
		}
		return num;
	}

	

	// 개인랭크

	@RequestMapping("member/rank")
	public String ranklist(Model model) {
		List<MemberVO> rlist = memberService.rankList();
		model.addAttribute("rlist", rlist);

		return "member/memberrank";

	}

	// 아이디 체크
	@RequestMapping(value = "/nameCheck", method = RequestMethod.POST)
	@ResponseBody
	public int nameCheck(@RequestParam("u_id") String u_id) {
		return memberService.nameCheck(u_id);
	}

	// 01 회원 목록
	// url pattern mapping
	@RequestMapping("admin/member/list.do")
	public String memberList(Model model) {
		// controller => service => dao 요청
		List<MemberVO> list = memberService.memberList();
		model.addAttribute("list", list);
		return "member/member_list";
	}

	// 02_01 회원 등록 페이지로 이동
	@RequestMapping("member/write.do")
	public String memberWrite() {

		return "member/member_write";
	}

	@RequestMapping("member/naverlo")
	public String sssss() {

		return "member/naverlo";
	}

	@RequestMapping("member/naverlogin")
	public String naverloinforom() {
		System.out.println("naverloginfomr()");
		return "/member/naverlogin";
	}

//	@RequestMapping("member/naverlogin")
//	public String naverloinforom() {
//		System.out.println("naverloginfomr()");
//		return "member/loginform";
//	}
//	
	@RequestMapping(value = "member/naverSave", method = RequestMethod.POST)
	public @ResponseBody String naverSave(@RequestParam("n_email") String n_email, @RequestParam("n_id") String n_id,
			@RequestParam("n_name") String n_name, HttpSession session, MemberVO vo) {
		System.out.println("#############################################");
		System.out.println(n_email);

		System.out.println(n_id);
		System.out.println(n_name);

		System.out.println("#############################################");

		vo.setU_id(n_email);
		System.out.println("셋 값" + vo.getU_id());

		vo.setU_name(n_name);

		// ajax에서 성공 결과에서 ok인지 no인지에 따라 다른 페이지에 갈 수 있게끔 result의 기본값을 "no"로 선언
		String result = "no";

		if (vo != null) {
			// naver가 비어있지 않는다는건 데이터를 잘 받아왔다는 뜻이므로 result를 "ok"로 설정
			result = "ok";
			session.setAttribute("n_email", vo.getU_id());
			System.out.println("n_email : " + session.getValue(n_email));
			System.out.println("m_name : " + vo.getU_name());
		}
		MemberVO nre = memberService.findnaverid(vo);

		if (nre == null) {
			memberService.naverinser(vo);

			memberService.findnaverid(vo);

		}

		return result;
	}

	@RequestMapping(value = "/member/kakao", method = RequestMethod.GET)
	public String kakaoLogin(@RequestParam(value = "code", required = false) String code, HttpSession session)
			throws Exception {
		System.out.println("#########" + code);
		// 접속 토큰
		System.out.println("접속 토큰 가져와지냐 ?");
		String access_Token = memberService.getAccessToken(code);
		System.out.println("어디까지오냐");

		// userInfo의 타입을 Kakaovo로 변경 및 import.
		MemberVO userInfo = memberService.getUserInfo(access_Token);

		System.out.println("###access_Token#### : " + access_Token);

		System.out.println("###nickname#### : " + userInfo.get("nickname")); //
		System.out.println("###email#### : " + userInfo.get("email")); //

//		session.invalidate();
		// 위 코드는 session객체에 담긴 정보를 초기화 하는 코드.

		session.setAttribute("kakaoN", userInfo.getU_name());
		session.setAttribute("kakaoE", userInfo.getU_id());
		// 위 2개의 코드는 닉네임과 이메일을 session객체에 담는 코드
		// jsp에서 ${sessionScope.kakaoN} 이런 형식으로 사용할 수 있다.

		return "test";
	}

	// 02_02 회원 등록 처리 후 ==> 회원목록으로 리다이렉트
	// @ModelAttribute에 폼에서 입력한 데이터가 저장된다.

	@RequestMapping("member/insert.do")
	// * 폼에서 입력한 데이터를 받아오는 법 3가지
	// public String memberInsert(HttpServlet request){
	// public String memberInsert(String userId, String userPw, String userName,
	// String userEmail){
	public String memberInsert(HttpServletRequest request, MemberVO vo) {
		// 테이블에 레코드 입력
		System.out.println("dddd");
		String[] str = request.getParameterValues("m_1");
		String adr = request.getParameter("ad1");
		String adr2 = request.getParameter("ad2");
		String adr3 = request.getParameter("ad3");
		String[] alladr = { adr, adr2, adr3 };
		System.out.println(alladr);
		if (alladr.length > 0) {
			String adre = String.join(" ", alladr);
			System.out.println(adre);
			vo.setU_address(adre);

		}

		if (str.length > 0) {
			String all_m = String.join(" ", str);
			System.out.println(all_m);
			vo.setU_check(all_m);
		}

		vo.setU_date(vo.getU_date());
		vo.setClimb(1);
		vo.setU_level(1);
		vo.setFollow(0);
		memberService.insertMember(vo);
		// * (/)의 유무에 차이
		// /member/list.do : 루트 디렉토리를 기준
		// member/list.do : 현재 디렉토리를 기준
		// member_list.jsp로 리다이렉트
		return "redirect:/test";
	}

	// 03 회원 상세정보 조회
	@RequestMapping("member/view.do")
	public String memberView(@RequestParam String userId, Model model) {
		// 회원 정보를 model에 저장

		model.addAttribute("dto", memberService.viewMember(userId));
		// System.out.println("클릭한 아이디 확인 : "+userId);
		logger.info("클릭한 아이디 : " + userId);
		// member_view.jsp로 포워드
		return "member/admin_view";
	}

	// 04. 회원 정보 수정 처리
	@RequestMapping("member/update.do")
	public String memberUpdate(@ModelAttribute MemberVO vo, Model model) {
		// 비밀번호 체크
		boolean result = memberService.checkPw(vo.getU_id(), vo.getU_pw());
		if (result) { // 비밀번호가 일치하면 수정 처리후, 전체 회원 목록으로 리다이렉트
			memberService.updateMember(vo);
			return "redirect:/member/list.do";
		} else { // 비밀번호가 일치하지 않는다면, div에 불일치 문구 출력, viwe.jsp로 포워드
			// 가입일자, 수정일자 저장
			MemberVO vo2 = memberService.viewMember(vo.getU_id());

			model.addAttribute("dto", vo);
			model.addAttribute("message", "비밀번호 불일치");
			return "member/member_view";
		}

	}

	@RequestMapping("id_check")
	public String idchekc() {
		System.out.println("idchekc()");
		return "";

	}

	// 05. 회원정보 삭제 처리
	// @RequestMapping : url mapping
	// @RequestParam : get or post방식으로 전달된 변수값
	@RequestMapping("member/delete.do")
	public String memberDelete(@RequestParam String userId, @RequestParam String userPw, Model model) {
		// 비밀번호 체크
		boolean result = memberService.checkPw(userId, userPw);
		if (result) { // 비밀번호가 맞다면 삭제 처리후, 전체 회원 목록으로 리다이렉트
			memberService.deleteMember(userId);
			return "redirect:/member/list.do";
		} else { // 비밀번호가 일치하지 않는다면, div에 불일치 문구 출력, viwe.jsp로 포워드
			model.addAttribute("message", "비밀번호 불일치");
			model.addAttribute("dto", memberService.viewMember(userId));
			return "member/member_view";
		}
	}

	@RequestMapping("member/loginform.do")
	public String loginform() {
		System.out.println("loginform");

		return "member/loginform";
	}

	// 로그인 세션
	@RequestMapping("/member/loginpro")
	public String loginchec(MemberVO vo, HttpServletRequest request, Model model) {
		System.out.println("loginpro");
		// 세션 생성
//		String u_id = request.getParameter("u_id");
//		String u_pw = request.getParameter("u_pw");
//		
//		System.out.println("u_id값"+u_id);
//		System.out.println("u_pw값"+u_pw);
		// vo.setU_id(u_id);
		// vo.setU_pw(u_pw);

		System.out.println(vo.getU_id());
		System.out.println(vo.getU_pw());
	

		// 세션 생성 하기
		HttpSession session = request.getSession();
		
		MemberVO res = memberService.memberlogin(vo);
		String test = vo.getU_id();
		System.out.println("test u_id :" + test);
		
		System.out.println("session id:" + session.getId());
		// 세션 유효 시간 설정
//		session.setMaxInactiveInterval(3600);
//		System.out.println("세션 유효시간" + session.getMaxInactiveInterval());

		System.out.println("res" + res);

		if (res != null) {
			System.out.println("이걸 타나 ?");
			// 세션저장
			session.setAttribute("res", res);
			session.setAttribute("u_id",test);
			System.out.println("-----");
			logger.info(vo.getU_id());

			return "redirect:/test";
		}

		return "redirect:/member/loginform.do";

	}

	@RequestMapping("/member/userinfo")
	public String userinfo(HttpServletRequest request) {

		HttpSession session = request.getSession();
		System.out.println(session);
		return "member/userinfo";

	}

//	@RequestMapping("/member/unfollow")
//	public String unfollow(HttpServletRequest request, HttpSession session, FollowVO fvo) {
//
//		System.out.println(fvo.getU_id());
//
//		String f_id = fvo.getU_id();
//
//		fvo.setMy_follow(f_id);
//
//		session = request.getSession();
//
//		MemberVO res = (MemberVO) session.getAttribute("res");
//
//		String s_id = res.getU_id();
//
//		fvo.setU_id(s_id);
//
//		System.out.println("세션id 가져오나 ?" + s_id);
//
//		System.out.println(fvo.getMy_follow());
//		System.out.println(fvo.getU_id());
//		int rsult = memberService.unfollow(fvo);
//
//		if (rsult != 0) {
//			System.out.println("팔로우 성공");
//
//		} else {
//			System.out.println("팔로우 실패 야발탱");
//		}
//		return "member/myfollow";
//
//	}
//
//	@RequestMapping("/member/follow.bo")
//	public String follow(HttpServletRequest request, HttpSession session, FollowVO fvo) {
//
//		System.out.println(fvo.getU_id());
//
//		String f_id = fvo.getU_id();
//
//		fvo.setMy_follow(f_id);
//
//		session = request.getSession();
//
//		MemberVO res = (MemberVO) session.getAttribute("res");
//
//		String s_id = res.getU_id();
//
//		fvo.setU_id(s_id);
//
//		System.out.println("세션id 가져오나 ?" + s_id);
//
//		System.out.println(fvo.getMy_follow());
//		System.out.println(fvo.getU_id());
//		int rsult = memberService.follow(fvo);
//
//		if (rsult != 0) {
//			System.out.println("팔로우 성공");
//
//		} else {
//			System.out.println("팔로우 실패 야발탱");
//		}
//
//		// u_id 팔로우 할사람
//		// f_id 로그인한 본인
//
////		return "redirect:/admin/member/list.do";
//		return "/member/myfollow";
//
//	}
//
//	@RequestMapping("/member/myfollow")
//	public String myfollow(Model model) {
//		// controller => service => dao 요청
//		List<FollowVO> alist = memberService.followlist();
//		model.addAttribute("alist", alist);
//
//		return "member/myfollow";
//
//	}

	@RequestMapping(value = "/member/crawling", method = RequestMethod.GET)
	public String startCrawl(Model model) throws IOException {
		System.out.println("???");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
		Date currentTime = new Date();

		String dTime = formatter.format(currentTime);
		String e_date = dTime;

		currentTime.setDate(currentTime.getDate() - 1);
		String s_date = formatter.format(currentTime);

		String query = "등산";
		String s_from = s_date.replace(".", "");
		String e_to = e_date.replace(".", "");
		int page = 1;
		ArrayList<String> al1 = new ArrayList<>();
		ArrayList<String> al2 = new ArrayList<>();

		while (page < 20) {
			String address = "https://search.naver.com/search.naver?where=news&query=" + query + "&sort=1&ds=" + s_date
					+ "&de=" + e_date + "&nso=so%3Ar%2Cp%3Afrom" + s_from + "to" + e_to + "%2Ca%3A&start="
					+ Integer.toString(page);
			Document rawData = Jsoup.connect(address).timeout(5000).get();
			System.out.println("address: " + address);
			Elements blogOption = rawData.select(".list_news a");
			System.out.println("blogOption : " + blogOption);
			System.out.println("test");
			String realURL = "";
			String realTITLE = "";

			for (Element option : blogOption) {

				System.out.println("test2");
				realURL = option.select("a").attr("href");
				realTITLE = option.select("a").attr("title");
				System.out.println("여기들어오냐?");
				System.out.println("realTitle: " + realTITLE);
				System.out.println("realurl" + realURL);
				al1.add(realURL);
				al2.add(realTITLE);
			}
			page += 10;
		}
		model.addAttribute("urls", al1);
		model.addAttribute("titles", al2);
		model.addAttribute("titles", al2);
		return "member/news";
	}

//	@RequestMapping("loginpro")
//	public String loginpor(HttpServletRequest request, @ModelAttribute MemberVO vo, Model model) {
//		System.out.println("loginpor()");
//		
//		HttpSession session = request.getSession();
//		logger.info(vo.getU_id());
//		 System.out.println(vo.getU_id());
//		// 비밀번호 체크
//		boolean result = memberService.checkPw(vo.getU_id(), vo.getU_pw());
//		if (result) { // 비밀번호가 일치하면 수정 처리후, 전체 회원 목록으로 리다이렉트
//			memberService.updateMember(vo);
//			if(vo.getU_id().equals("admin")) {
//				session.setAttribute("dd",vo.getU_id());
//				
//				return "/admin/member/list.do";
//			}
//		} else { // 비밀번호가 일치하지 않는다면, div에 불일치 문구 출력, viwe.jsp로 포워드
//			// 가입일자, 수정일자 저장
//			MemberVO vo2 = memberService.viewMember(vo.getU_id());
//			
//			model.addAttribute("dto", vo);
//			
//			session.setAttribute("dd",vo.getU_id());
//			
//			
//
//			model.addAttribute("dto", memberService.viewMember(vo.getU_id()));
//
//			return "/admin/member/list.do";
//			
//			//return "member/member_view";
//		}
//		 return "redirect:/member/loginform";
//	}
}
