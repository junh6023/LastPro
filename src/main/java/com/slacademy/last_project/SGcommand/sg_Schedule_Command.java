package com.slacademy.last_project.SGcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;


import com.slacademy.last_project.SGDAO.SGDao;
import com.slacademy.last_project.SGDTO.SGSDto;

import mountain.mania.com_command.MCommand;

public class sg_Schedule_Command implements MCommand {

	@Override
	public void execute(Model model) {
		SGDao sgdao=new SGDao();
		System.out.println("sg_Schedule_Command 들어옴");
		
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HttpSession session = request.getSession();
	    String u_id= (String) session.getAttribute("u_id");
		
		//String u_id =request.getParameter("u_id");
		System.out.println(u_id);
	
		boolean check=sgdao.nav_check(u_id);
		ArrayList<SGSDto> gsdto =sgdao.bg_Schedule_select(u_id);
		
		model.addAttribute("schedule", gsdto);
		model.addAttribute("check", check);
		
		System.out.println(model);

	}

}
