package com.slacademy.last_project.SGcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;
import com.slacademy.last_project.SGDAO.SGDao;
import com.slacademy.last_project.SGDTO.SGMDto;

import mountain.mania.com_command.MCommand;

public class sg_member_listCommand implements MCommand {

	@Override
	public void execute(Model model) {
		System.out.println("bg_member_list 커맨드 들어옴");
		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		SGDao sgdao= new SGDao();
		GDao gdao= new GDao();
		
		HttpSession session = request.getSession();
	    String u_id= (String) session.getAttribute("u_id");
		
		//String u_id = request.getParameter("u_id");
		
		ArrayList<SGMDto> sgmdto = sgdao.sg_member_list(u_id);
		boolean check=gdao.nav_check(u_id);//동호회 장일 경우에만 보이는 메뉴 리스트 페이지에서 뽑아내려고
		System.out.println(check);
		
		boolean s_check=gdao.small_nav_check(u_id);//동호회 장일 경우에만 보이는 메뉴 리스트 페이지에서 뽑아내려고
		System.out.println(check);
		
		
		model.addAttribute("check", check);
		model.addAttribute("s_check", s_check);
	
		
		model.addAttribute("sg_member", sgmdto);


	}

}
