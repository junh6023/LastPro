package com.slacademy.last_project.Gcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;

import mountain.mania.com_command.MCommand;

public class bg_active_saveCommand implements MCommand {

	@Override
	public void execute(Model model) {
		GDao gdao=new GDao();
		System.out.println("bg_active_saveCommand 들어옴");
		
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int m_id = Integer.parseInt(request.getParameter("m_id")) ;
		int bg_id = Integer.parseInt(request.getParameter("bg_id"));
		int c_id= Integer.parseInt(request.getParameter("c_id"));
		float bg_experience =  Float.parseFloat(request.getParameter("bg_experience"));
		int climb = Integer.parseInt(request.getParameter("climb"));
		String u_id= request.getParameter("u_id");
		
		System.out.println(m_id);
		System.out.println(bg_id);
		System.out.println(c_id);
		System.out.println(bg_experience);
		System.out.println(climb);
		System.out.println(u_id);
		
		
		
		gdao.bg_active_save(m_id,bg_id,c_id,bg_experience,climb);
		
	
		model.addAttribute("u_id", u_id);
		
		
		
		

	}

}
