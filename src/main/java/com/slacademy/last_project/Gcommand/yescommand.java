package com.slacademy.last_project.Gcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;

import mountain.mania.com_command.MCommand;

public class yescommand implements MCommand {

	@Override
	public void execute(Model model) {
		GDao gdao = new GDao();
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HttpSession session = request.getSession();
	    String u_id= (String) session.getAttribute("u_id");
		
		//String u_id=request.getParameter("u_id");
		int bg_id = Integer.parseInt(request.getParameter("bg_id"));
		int bgj_id =  Integer.parseInt(request.getParameter("bgj_id"));

		System.out.println(u_id);
		System.out.println(bg_id);
		System.out.println(bgj_id);
		
		gdao.Group_member_add(bg_id, u_id,bgj_id);
	}

}
