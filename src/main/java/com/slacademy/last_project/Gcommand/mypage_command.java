package com.slacademy.last_project.Gcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;


import mountain.mania.com_command.MCommand;

public class mypage_command implements MCommand {

	@Override
	public void execute(Model model) {
		GDao gdao = new GDao();

		System.out.println("mypage_command 들어왔다");
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String u_id=request.getParameter("u_id");
		System.out.println(u_id);
		
		boolean check=gdao.nav_check(u_id);//동호회 장일 경우에만 보이는 메뉴 리스트 페이지에서 뽑아내려고
		System.out.println(check);
		
		boolean s_check=gdao.small_nav_check(u_id);//동호회 장일 경우에만 보이는 메뉴 리스트 페이지에서 뽑아내려고
		System.out.println(check);
		
		
		model.addAttribute("check", check);
		model.addAttribute("s_check", s_check);
		
		System.out.println(model);

	}

}
