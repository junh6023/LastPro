package com.slacademy.last_project.Gcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;
import com.slacademy.last_project.GDTO.GDto;

import mountain.mania.com_command.MCommand; 

public class bg_rank implements MCommand {

	@Override
	public void execute(Model model) {

				 
			Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
			HttpServletRequest request = (HttpServletRequest) map.get("request");
				
			int page=1; 
			int limit=30;
				
				
			if(request.getParameter("page")!=null){ //넘겨받은 페이지가 널이 아닐때 값을 페이지에 넣어줌
				page=Integer.parseInt(request.getParameter("page")); 
			}
			 
			
			
			 GDao gdao = new GDao();
			 ArrayList<GDto> gdto=gdao.bg_rank(page,limit);

			 int count = gdao.count();
				System.out.println(count);
			
				int maxpage=(int)((double)count/limit+0.95); 		
				int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
				int endpage = maxpage;

				if (endpage>startpage+10-1) endpage=startpage+10-1;

//				request.setAttribute("page", page);		  
//				request.setAttribute("maxpage", maxpage); 
//				request.setAttribute("startpage", startpage);
//				request.setAttribute("endpage", endpage);    
				 
				model.addAttribute("page", page);
				model.addAttribute("maxpage", maxpage); 
				model.addAttribute("startpage", startpage);
				model.addAttribute("endpage", endpage);  
				
				model.addAttribute("count", count);
			
				model.addAttribute("bg_rank", gdto);

	}

}
