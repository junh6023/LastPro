package com.slacademy.last_project.Gcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;
import com.slacademy.last_project.GDTO.GDto;

import mountain.mania.com_command.MCommand;

public class BigGroupListCommand implements MCommand {

	@Override
	public void execute(Model model) {
		GDao gdao = new GDao();

	
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int page=1; 
		int limit=10;
		
		
		if(request.getParameter("page")!=null){ //넘겨받은 페이지가 널이 아닐때 값을 페이지에 넣어줌
			page=Integer.parseInt(request.getParameter("page")); 
		}
		
		String u_id=request.getParameter("u_id");
		
		
		//boolean check=gdao.nav_check(u_id);//동호회 장일 경우에만 보이는 메뉴 리스트 페이지에서 뽑아내려고, 준형오빠한테 붙이면 달라져야함
		//System.out.println(check);
		ArrayList<GDto>gdto= gdao.list(page, limit);
		
	
		int count = gdao.count();
		
	
		int maxpage=(int)((double)count/limit+0.95); 		
		int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
		int endpage = maxpage;

		if (endpage>startpage+10-1) endpage=startpage+10-1;

//		request.setAttribute("page", page);		  
//		request.setAttribute("maxpage", maxpage); 
//		request.setAttribute("startpage", startpage);
//		request.setAttribute("endpage", endpage);    
		 

		if(request.getParameter("bg_nameCheck")!=null) {
			String bg_nameCheck = request.getParameter("bg_nameCheck");
			System.out.println(bg_nameCheck);
			model.addAttribute("bg_nameCheck", bg_nameCheck);
		}
		
		model.addAttribute("page", page);
		model.addAttribute("maxpage", maxpage); 
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);  
		
		model.addAttribute("count", count);
	
		
		model.addAttribute("list", gdto);
		//model.addAttribute("check", check);
		
	

	}

}
