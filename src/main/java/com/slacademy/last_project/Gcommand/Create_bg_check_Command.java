package com.slacademy.last_project.Gcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;

import mountain.mania.com_command.MCommand;

public class Create_bg_check_Command implements MCommand {

	@Override
	public void execute(Model model) {
		GDao gdao=new GDao();
		System.out.println("Create_bg_check_Command 들어옴");
		
		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String u_id=request.getParameter("u_id");
		System.out.println(u_id);
		
		boolean check= gdao.Create_bg_check(u_id);
		System.out.println(check);
		
		
		model.addAttribute("check", check);
		model.addAttribute("u_id", u_id);

	}

}
