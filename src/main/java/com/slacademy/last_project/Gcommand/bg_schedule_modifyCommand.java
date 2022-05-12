package com.slacademy.last_project.Gcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;
import com.slacademy.last_project.GDTO.GSDto;

import mountain.mania.com_command.MCommand;

public class bg_schedule_modifyCommand implements MCommand {

	@Override
	public void execute(Model model) {
		GDao gdao=new GDao();
		System.out.println("bg_schedule_modifyCommand 들어옴");
		
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
	
		int bgs_id= Integer.parseInt(request.getParameter("bgs_id"));
		System.out.println(bgs_id);
		String title= request.getParameter("title");
		System.out.println(title);
		
		String[] str= request.getParameter("bgs_date").split("-");
		String year = str[0];
		String month = str[1];
		String day = str[2];
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		
		
		ArrayList<GSDto> gsdto=gdao.bg_Schedule_check(bgs_id,title);
	
		model.addAttribute("list", gsdto);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
	
	
	}

}
