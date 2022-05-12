package com.slacademy.last_project.SGcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;



import com.slacademy.last_project.SGDAO.SGDao;
import com.slacademy.last_project.SGDTO.SGSDto;

import mountain.mania.com_command.MCommand;

public class sg_schedule_modifyCommand implements MCommand {

	@Override
	public void execute(Model model) {
		SGDao sgdao=new SGDao();
		System.out.println("sg_schedule_modifyCommand 들어옴");
		
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
	
		int sgs_id= Integer.parseInt(request.getParameter("sgs_id"));
		System.out.println(sgs_id);
		String title= request.getParameter("title");
		System.out.println(title);
		
		String[] str= request.getParameter("sgs_date").split("-");
		String year = str[0];
		String month = str[1];
		String day = str[2];
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		
		
		ArrayList<SGSDto> gsdto=sgdao.sg_Schedule_check(sgs_id,title);
	
		model.addAttribute("list", gsdto);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);

	}

}
