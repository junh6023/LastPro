package com.slacademy.last_project.Gcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;

import mountain.mania.com_DTO.CDto;
import mountain.mania.com_DTO.MDto;
import mountain.mania.com_command.MCommand;


public class bg_Schedule_write1_Command implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		System.out.println("산코스 가져올 커맨드");
	
		int m_id=Integer.parseInt(request.getParameter("mountain"));
		System.out.println(m_id);
		
		String year =request.getParameter("year");
		String month =request.getParameter("month");
		String day =request.getParameter("day");	
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);

		
		GDao gdao= new GDao();
		ArrayList<CDto> cdto = gdao.mountaincourse(m_id);
		ArrayList<MDto> cdto2 = gdao.mountain_name(m_id);
		ArrayList<MDto> gdto3=gdao.MountainList();
		
		model.addAttribute("course", cdto);
		model.addAttribute("m_name", cdto2);
		model.addAttribute("list", gdto3);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);


		
	}

}
