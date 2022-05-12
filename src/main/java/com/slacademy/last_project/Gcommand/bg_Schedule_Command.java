package com.slacademy.last_project.Gcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;
import com.slacademy.last_project.GDTO.GSDto;

import mountain.mania.com_command.MCommand;

public class bg_Schedule_Command implements MCommand {

	@Override
	public void execute(Model model) {
		GDao gdao=new GDao();
		System.out.println("bg_Schedule_Command 들어옴");
		
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String u_id =request.getParameter("u_id");
		System.out.println(u_id);
		
		boolean check=gdao.nav_check(u_id);
		
		System.out.println("ehehehehehe  :  "+check);
	
		ArrayList<GSDto> gsdto =gdao.bg_Schedule_select(u_id);
		
		model.addAttribute("schedule", gsdto);
		model.addAttribute("check", check);
		System.out.println(model);
		
	}

}
