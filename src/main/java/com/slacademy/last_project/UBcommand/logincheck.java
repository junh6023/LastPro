package com.slacademy.last_project.UBcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import mountain.mania.com_DAO.MDao;
import mountain.mania.com_command.MCommand;

public class logincheck implements MCommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("u_id") != null) {			
		
			model.addAttribute("idnull","idon");
		
		
		} else {			
			model.addAttribute("idnull","idnull");
		}
		
	}

}
