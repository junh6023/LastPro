package com.slacademy.last_project.Gcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;
import com.slacademy.last_project.GDTO.GMDto;

import mountain.mania.com_command.MCommand;

public class Appbg_member_listCommand implements MCommand {

	@Override
	public void execute(Model model) {
		System.out.println("bg_member_list 커맨드 들어옴");
		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		GDao gdao= new GDao();
		
		HttpSession session = request.getSession();
	      String u_id= (String) session.getAttribute("u_id");

		
		ArrayList<GMDto> gmdto = gdao.bg_member_list(u_id);
		
		model.addAttribute("bg_member", gmdto);
	}

}
