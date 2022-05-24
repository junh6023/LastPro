package com.slacademy.last_project.Gcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;
import com.slacademy.last_project.GDTO.GJoinDto;

import mountain.mania.com_command.MCommand;

public class AppBigGroup_joinListCommand implements MCommand {

	@Override
	public void execute(Model model) {
		System.out.println("BigGroup_joinListCommand 들어옴");
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		GDao gdao=new GDao();
		
		HttpSession session = request.getSession();
	    String u_id= (String) session.getAttribute("u_id");
		
		ArrayList<GJoinDto> gdto=gdao.bg_joinlist(u_id);

		model.addAttribute("join_list", gdto);
		System.out.println(model);

	}

}
