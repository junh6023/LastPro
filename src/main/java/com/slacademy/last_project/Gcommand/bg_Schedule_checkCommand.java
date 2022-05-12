package com.slacademy.last_project.Gcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;
import com.slacademy.last_project.GDTO.GSDto;

import mountain.mania.com_command.MCommand;

public class bg_Schedule_checkCommand implements MCommand {

	@Override
	public void execute(Model model) {
		GDao gdao=new GDao();
		System.out.println("bg_Schedule_Command 들어옴");		
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int bgs_id=Integer.parseInt(request.getParameter("bgs_id"));
		String title = request.getParameter("title");
		String bg_name= request.getParameter("bg_name");
		String u_id= request.getParameter("u_id");
		
		System.out.println(bgs_id);
		System.out.println(title);
		System.out.println(bg_name);
		System.out.println(u_id);
		
		
		ArrayList<GSDto> gsdto=gdao.bg_Schedule_check(bgs_id,title);
		boolean check=gdao.check(bg_name,u_id);
		
		model.addAttribute("list", gsdto);
		model.addAttribute("check", check);
		
	}

}
