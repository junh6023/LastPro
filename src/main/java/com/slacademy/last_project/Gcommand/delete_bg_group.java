package com.slacademy.last_project.Gcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;

import mountain.mania.com_command.MCommand;

public class delete_bg_group implements MCommand {

	@Override
	public void execute(Model model) {
		System.out.println("delete_bg_group 커맨드 들어옴");
		
		GDao gdao = new GDao();
		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String u_id	= request.getParameter("u_id");
		int bg_id= Integer.parseInt( request.getParameter("bg_id"));
		
		System.out.println(u_id);
		System.out.println(bg_id);
		
		gdao.delete_bg_group(u_id,bg_id);
	}

}
