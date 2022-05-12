package com.slacademy.last_project.Gcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;

import mountain.mania.com_DTO.MDto;
import mountain.mania.com_command.MCommand;


public class bg_Schedule_write_view1 implements MCommand {

	@Override
	public void execute(Model model) {
		System.out.println("스케줄 등록할때 산 이름 가져올 커맨드");
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String year =request.getParameter("year");
		String month =request.getParameter("month");
		String day =request.getParameter("day");	
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		
		GDao gdao= new GDao();
		
		ArrayList<MDto> gdto=gdao.MountainList();
		
		model.addAttribute("list", gdto);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		
		System.out.println(model);

	}

}
