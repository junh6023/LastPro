package com.slacademy.last_project.SGcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;


import com.slacademy.last_project.SGDAO.SGDao;

import mountain.mania.com_command.MCommand;

public class delete_sg_groupCommand implements MCommand {

	@Override
	public void execute(Model model) {
System.out.println("delete_bg_group 커맨드 들어옴");
		
		SGDao sgdao = new SGDao();
		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String u_id	= request.getParameter("u_id");
		int sg_id= Integer.parseInt( request.getParameter("sg_id"));
		
		System.out.println(u_id);
		System.out.println(sg_id);
		
		sgdao.delete_sg_group(u_id,sg_id);

	}

}
