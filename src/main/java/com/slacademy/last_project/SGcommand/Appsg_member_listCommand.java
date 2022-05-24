package com.slacademy.last_project.SGcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.SGDAO.SGDao;
import com.slacademy.last_project.SGDTO.SGMDto;

import mountain.mania.com_command.MCommand;

public class Appsg_member_listCommand implements MCommand {

	@Override
	public void execute(Model model) {
		System.out.println("bg_member_list 커맨드 들어옴");
		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		SGDao sgdao= new SGDao();
		
		HttpSession session = request.getSession();
	    String u_id= (String) session.getAttribute("u_id");
		
		//String u_id = request.getParameter("u_id");
		
		ArrayList<SGMDto> sgmdto = sgdao.sg_member_list(u_id);
		
		model.addAttribute("sg_member", sgmdto);


	}

}
