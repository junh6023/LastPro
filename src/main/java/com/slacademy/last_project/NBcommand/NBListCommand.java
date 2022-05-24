package com.slacademy.last_project.NBcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.UBDao.BDao;
import com.slacademy.last_project.UBDto.BDto;

import mountain.mania.com_command.MCommand;

public class NBListCommand implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String ,Object> map=model.asMap();
	    HttpServletRequest request= (HttpServletRequest)map.get("request");
		System.out.println("NBListCommand왔다");
		BDao dao = new BDao(); //데이터베이스 접속.
		
		int page=1; 
		int limit=10;	

		if(request.getParameter("page")!=null){ //넘겨받은 페이지가 널이 아닐때 값을 페이지에 넣어줌
			page=Integer.parseInt(request.getParameter("page")); 
		}
		
//		String u_id=request.getParameter("u_id");
		HttpSession session = request.getSession();
	    String u_id= (String) session.getAttribute("u_id");
		
		int count = dao.Ncount();
		System.out.println(count);
		ArrayList<BDto> dtos = dao.Nlist(page, limit);	
		System.out.println(dtos);
		
		int maxpage=(int)((double)count/limit+0.95); 		
		int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
		int endpage = maxpage;

		if (endpage>startpage+10-1) endpage=startpage+10-1;

		request.setAttribute("page", page);		  
		request.setAttribute("maxpage", maxpage); 
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);    
		 
		model.addAttribute("page", page);
		model.addAttribute("maxpage", maxpage); 
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);  
		
		model.addAttribute("count", count);
		model.addAttribute("list",dtos);
		model.addAttribute("u_id",u_id);

		
		
		System.out.println(model);
		System.out.println("모델담기 성공");
	}

}
