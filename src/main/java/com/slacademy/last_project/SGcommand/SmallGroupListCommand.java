package com.slacademy.last_project.SGcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;


import com.slacademy.last_project.SGDAO.SGDao;
import com.slacademy.last_project.SGDTO.SGDto;

import mountain.mania.com_command.MCommand;

public class SmallGroupListCommand implements MCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		SGDao sgdao=new SGDao();
		System.out.println("SmallGroupListCommand 들어왔다");
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int page=1; 
		int limit=10;
		
		if(request.getParameter("page")!=null){ //넘겨받은 페이지가 널이 아닐때 값을 페이지에 넣어줌
			page=Integer.parseInt(request.getParameter("page")); 
		}
		
		String u_id=request.getParameter("u_id");
		System.out.println(u_id);
		
		boolean check=sgdao.nav_check(u_id);
		System.out.println(check);
		ArrayList<SGDto>sgdto= sgdao.list(page, limit);
		
		int count = sgdao.count();
		System.out.println(count);
	
		int maxpage=(int)((double)count/limit+0.95); 		
		int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
		int endpage = maxpage;

		if (endpage>startpage+10-1) endpage=startpage+10-1;
		
		if(request.getParameter("sg_nameCheck")!=null) {
			String sg_nameCheck = request.getParameter("sg_nameCheck");
			System.out.println(sg_nameCheck);
			model.addAttribute("sg_nameCheck", sg_nameCheck);
		}

		request.setAttribute("page", page);		  
		request.setAttribute("maxpage", maxpage); 
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);    
		 
		model.addAttribute("page", page);
		model.addAttribute("maxpage", maxpage); 
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);  
		
		
		model.addAttribute("list", sgdto);
		model.addAttribute("check", check);
		System.out.println(model);

	}

}
