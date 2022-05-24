package com.slacademy.last_project.QnAcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.QnADao.QnADao;
import com.slacademy.last_project.QnADto.QnADto;

import mountain.mania.com_command.MCommand;

public class QnA_listCommand implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String ,Object> map=model.asMap();
	    HttpServletRequest request= (HttpServletRequest)map.get("request");
		System.out.println("QnA_listCommand왔다");
		QnADao dao = new QnADao(); //데이터베이스 접속.
		
		int page=1; 
		int limit=10;	

		if(request.getParameter("page")!=null){ //넘겨받은 페이지가 널이 아닐때 값을 페이지에 넣어줌
			page=Integer.parseInt(request.getParameter("page")); 
		}
		
		
		
		int count = dao.Ecount();
		System.out.println(count);
		ArrayList<QnADto> dtos = dao.Elist(page, limit);	
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
	

		
		
		System.out.println(model);
		System.out.println("모델담기 성공");	

	}

}
