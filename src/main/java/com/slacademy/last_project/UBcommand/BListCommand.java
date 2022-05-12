package com.slacademy.last_project.UBcommand;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.UBDto.BDto;

import mountain.mania.com_DAO.MDao;
import mountain.mania.com_command.MCommand;



 

public class BListCommand implements MCommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Map<String ,Object> map=model.asMap();
	    HttpServletRequest request= (HttpServletRequest)map.get("request");
		System.out.println("BListCommand왔다");
		MDao dao = new MDao(); //데이터베이스 접속.
		String result = "";

		if(null != request.getParameter("result")) {
		 result=request.getParameter("result");
		
		}
		
//		int page=1; 
//		int limit=10;
//		
//
//		if(request.getParameter("page")!=null){ //넘겨받은 페이지가 널이 아닐때 값을 페이지에 넣어줌
//			page=Integer.parseInt(request.getParameter("page")); 
//		}
		
		
		

		
		ArrayList<BDto> dtos = dao.userborderlist();	
		
		int count = dao.count();
		
//		int maxpage=(int)((double)count/limit+0.95); 		
//		int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
//		int endpage = maxpage;

//		if (endpage>startpage+10-1) endpage=startpage+10-1;

//		request.setAttribute("page", page);		  
//		request.setAttribute("maxpage", maxpage); 
//		request.setAttribute("startpage", startpage);
//		request.setAttribute("endpage", endpage);    
		 
//		model.addAttribute("page", page);
//		model.addAttribute("maxpage", maxpage); 
//		model.addAttribute("startpage", startpage);
//		model.addAttribute("endpage", endpage);  
		
		model.addAttribute("count", count);
		model.addAttribute("list",dtos);
		model.addAttribute("result",result);
		
		
		System.out.println(model);
		System.out.println("모델담기 성공");
	}


	



}
