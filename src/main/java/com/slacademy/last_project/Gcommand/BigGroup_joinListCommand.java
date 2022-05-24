package com.slacademy.last_project.Gcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;

import com.slacademy.last_project.GDTO.GJoinDto;

import mountain.mania.com_command.MCommand;

public class BigGroup_joinListCommand implements MCommand {

	@Override
	public void execute(Model model) {
		System.out.println("BigGroup_joinListCommand 들어옴");
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		GDao gdao=new GDao();
		
		//String u_id = request.getParameter("u_id");
		
		HttpSession session = request.getSession();
	    String u_id= (String) session.getAttribute("u_id");
		
		ArrayList<GJoinDto> gdto=gdao.bg_joinlist(u_id);
		
		boolean check=gdao.nav_check(u_id);//동호회 장일 경우에만 보이는 메뉴 리스트 페이지에서 뽑아내려고
		System.out.println(check);
		
		boolean s_check=gdao.small_nav_check(u_id);//동호회 장일 경우에만 보이는 메뉴 리스트 페이지에서 뽑아내려고
		System.out.println(check);
		
		
		model.addAttribute("check", check);
		model.addAttribute("s_check", s_check);

		model.addAttribute("join_list", gdto);
		System.out.println(model);
	}

}
