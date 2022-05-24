package com.slacademy.last_project.Gcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;

import com.slacademy.last_project.GDTO.GDto;

import mountain.mania.com_command.MCommand;


public class BigGroupaddCommand implements MCommand {

	@Override
	public void execute(Model model) {
	GDao gdao = new GDao();
	

		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HttpSession session = request.getSession();
	    String u_id= (String) session.getAttribute("u_id");
	    
		//String u_id = request.getParameter("u_id");
		String bg_name = request.getParameter("g_name");
		String bg_intro = request.getParameter("g_intro");
		
		System.out.println(u_id);
		System.out.println(bg_name);
		System.out.println(bg_intro);
		
		boolean bg_nameCheck= gdao.bg_nameCheck(bg_name);
		System.out.println(bg_nameCheck);
		
		if(bg_nameCheck==true) {
			gdao.Group_add(u_id,bg_name,bg_intro);
		}
		
		model.addAttribute("bg_nameCheck", bg_nameCheck);
		

	}

}
