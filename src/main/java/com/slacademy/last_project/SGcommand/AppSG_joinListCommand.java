package com.slacademy.last_project.SGcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.SGDAO.SGDao;
import com.slacademy.last_project.SGDTO.SGJoinDto;

import mountain.mania.com_command.MCommand;

public class AppSG_joinListCommand implements MCommand {

	@Override
	public void execute(Model model) {
		System.out.println("BigGroup_joinListCommand 들어옴");
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		SGDao sgdao=new SGDao();
		
		HttpSession session = request.getSession();
	    String u_id= (String) session.getAttribute("u_id");
		
		//String u_id = request.getParameter("u_id");
		
		ArrayList<SGJoinDto> sgjdto=sgdao.sg_joinlist(u_id);

		model.addAttribute("join_list", sgjdto);
		System.out.println(model);
	}

}
