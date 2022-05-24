package com.slacademy.last_project.Gcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;
import com.slacademy.last_project.GDTO.BG_ADto;

import mountain.mania.com_command.MCommand;

public class bg_activeCommand implements MCommand {

	@Override
	public void execute(Model model) {
		GDao gdao=new GDao();
		System.out.println("bg_activeCommand 들어옴");
		
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HttpSession session = request.getSession();
	    String u_id= (String) session.getAttribute("u_id");
		
		//String u_id= request.getParameter("u_id");
		System.out.println("u_id:"+u_id);
		
		
		ArrayList<BG_ADto> list = gdao.bg_active(u_id);
		int climb = gdao.climb(u_id);
		
		System.out.println("활동내역 리스트 : " + list);
		
		model.addAttribute("list", list);
		model.addAttribute("climb", climb);
		

	}

}
