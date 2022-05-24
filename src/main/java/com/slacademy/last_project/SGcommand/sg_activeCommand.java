package com.slacademy.last_project.SGcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.SGDAO.SGDao;
import com.slacademy.last_project.SGDTO.SG_ADto;

import mountain.mania.com_command.MCommand;

public class sg_activeCommand implements MCommand {

	@Override
	public void execute(Model model) {
		SGDao gdao=new SGDao();
		System.out.println("sg_activeCommand 들어옴");
		
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HttpSession session = request.getSession();
	    String u_id= (String) session.getAttribute("u_id");
		
		//String u_id= request.getParameter("u_id");
		System.out.println(u_id);
		
		
		ArrayList<SG_ADto> list = gdao.sg_active(u_id);
		int climb = gdao.s_climb(u_id);
		
		System.out.println("sg활동내역 리스트 : " + list);
		System.out.println("등산횟수 :" + climb);
		
		model.addAttribute("list", list);
		model.addAttribute("climb", climb);
	}

}
