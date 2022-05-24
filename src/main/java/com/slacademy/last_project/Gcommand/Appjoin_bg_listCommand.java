package com.slacademy.last_project.Gcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;
import com.slacademy.last_project.GDTO.GDto;

import mountain.mania.com_command.MCommand;

public class Appjoin_bg_listCommand implements MCommand {

	@Override
	public void execute(Model model) {
		GDao gdao = new GDao();
		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		//String u_id =request.getParameter("u_id");
		HttpSession session = request.getSession();
	    String u_id= (String) session.getAttribute("u_id");
		
		ArrayList<GDto> gdto = gdao.join_bg_list(u_id);
		
		model.addAttribute("join_bg_list", gdto); 
		
	}

}
