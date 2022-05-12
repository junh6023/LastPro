package com.slacademy.last_project.Gcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;

import mountain.mania.com_command.MCommand;

public class search_Command implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String search=request.getParameter("search");
		System.out.println(search);
		
		GDao gdao = new GDao();
		
		ArrayList search_list=gdao.search(search);
		System.out.println(search_list);
		
		model.addAttribute("list", search_list);
	}

}
