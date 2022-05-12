package com.slacademy.last_project.Gcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;

import com.slacademy.last_project.GDTO.GDto;

import mountain.mania.com_command.MCommand;


public class BigGroupaddCommand implements MCommand {

	@Override
	public void execute(Model model) {
	GDao gdao = new GDao();
	

		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String u_id = request.getParameter("u_id");
		String g_name = request.getParameter("g_name");
		String g_intro = request.getParameter("g_intro");
		
		System.out.println(u_id);
		System.out.println(g_name);
		System.out.println(g_intro);
		
		gdao.Group_add(u_id,g_name,g_intro);
		

	}

}
