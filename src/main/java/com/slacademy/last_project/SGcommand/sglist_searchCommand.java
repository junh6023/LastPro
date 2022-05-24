package com.slacademy.last_project.SGcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;


import com.slacademy.last_project.SGDAO.SGDao;
import com.slacademy.last_project.SGDTO.SGDto;

import mountain.mania.com_command.MCommand;

public class sglist_searchCommand implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String search=request.getParameter("search");
		System.out.println(search);
		
		SGDao gdao = new SGDao();
		
		ArrayList<SGDto> list=gdao.search(search);//랭크서치랑 다오 공유점
		System.out.println(list);
		
		model.addAttribute("list", list);

	}

}
