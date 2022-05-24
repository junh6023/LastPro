package com.slacademy.last_project.NBcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.UBDao.BDao;
import com.slacademy.last_project.UBDto.BDto;

import mountain.mania.com_command.MCommand;


public class search_nboard implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String ,Object> map=model.asMap();
	      HttpServletRequest request= (HttpServletRequest)map.get("request");
	      BDao dao=new BDao();
	      
	      int page=1; 
		  int limit=10;
		  
			HttpSession session = request.getSession();
		    String u_id= (String) session.getAttribute("u_id");
		 // String u_id=request.getParameter("u_id");
		  
		  if(request.getParameter("page")!=null){ //넘겨받은 페이지가 널이 아닐때 값을 페이지에 넣어줌
				page=Integer.parseInt(request.getParameter("page")); 
			}
		  
		  String searchs=request.getParameter("searchs");
	      System.out.println(searchs);
		  
		  int count = dao.n_serch_count(searchs);
		System.out.println(count);

		  ArrayList<BDto> list=dao.n_serchs(searchs,page, limit);
		  System.out.println(list);
			
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
	      model.addAttribute("searchs", list);
	      model.addAttribute("u_id", u_id);

	}

}
