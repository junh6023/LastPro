package com.slacademy.last_project.SGcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;


import com.slacademy.last_project.SGDAO.SGDao;
import com.slacademy.last_project.SGDTO.SGDto;

import mountain.mania.com_command.MCommand;

public class join_sgroup_listcommand implements MCommand {

	@Override
	public void execute(Model model) {
		SGDao sgdao = new SGDao();
		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String u_id =request.getParameter("u_id");
		
		ArrayList<SGDto> sgdto = sgdao.join_bg_list(u_id);
		
		model.addAttribute("join_sg_list", sgdto); 
		
	}

}
