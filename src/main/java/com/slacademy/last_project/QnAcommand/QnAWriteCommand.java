package com.slacademy.last_project.QnAcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.QnADao.QnADao;
import com.slacademy.last_project.QnADto.QnADto;

import mountain.mania.com_command.MCommand;

public class QnAWriteCommand implements MCommand {

	@Override
	public void execute(Model model) {
		 Map<String ,Object> map=model.asMap();
	      HttpServletRequest request= (HttpServletRequest)map.get("request");
	      QnADao boarddao=new QnADao();
	      QnADto boarddata=new QnADto();
	     
	      boolean result=false;
	      
			HttpSession session = request.getSession();
		    String u_id= (String) session.getAttribute("u_id");
	      
	        boarddata.setU_id(u_id);
	        boarddata.setB_pw(request.getParameter("b_pw"));
	        boarddata.setB_title(request.getParameter("b_title"));
	        boarddata.setB_content(request.getParameter("b_content"));

	        
	       boarddao.EboardInsert(boarddata);
	        
	        if(result==false){
	           System.out.println(" 등록 실패");
	           return;
	        }
	        System.out.println(" 등록 성공");

	}

}
