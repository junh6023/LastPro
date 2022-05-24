package com.slacademy.last_project.SGcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.SGDAO.SGDao;
import com.slacademy.last_project.SGDTO.SGDto;

import mountain.mania.com_command.MCommand;

public class Appjoin_sg_listCommand implements MCommand {

	@Override
	public void execute(Model model) {
		SGDao sgdao = new SGDao();
		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HttpSession session = request.getSession();
	    String u_id= (String) session.getAttribute("u_id");
		
		//String u_id =request.getParameter("u_id");
		
		ArrayList<SGDto> sgdto = sgdao.join_bg_list(u_id);
		
		model.addAttribute("join_sg_list", sgdto); 

	}

}
