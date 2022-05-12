package com.slacademy.last_project.SGcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDTO.CDto;


import com.slacademy.last_project.SGDAO.SGDao;

import mountain.mania.com_DTO.MDto;
import mountain.mania.com_command.MCommand;

public class sg_Schedule_write1_Command implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		System.out.println("s산코스 가져올 커맨드");
	
		int m_id=Integer.parseInt(request.getParameter("mountain"));
		System.out.println(m_id);
		
		String year =request.getParameter("year");
		String month =request.getParameter("month");
		String day =request.getParameter("day");	
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);

		
		SGDao sgdao= new SGDao();
		ArrayList<CDto> cdto = sgdao.mountaincourse(m_id);
		ArrayList<MDto> cdto2 = sgdao.mountain_name(m_id);
		ArrayList<MDto> gdto3= sgdao.MountainList();
		
		model.addAttribute("course", cdto);
		model.addAttribute("m_name", cdto2);
		model.addAttribute("list", gdto3);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
	}

}
