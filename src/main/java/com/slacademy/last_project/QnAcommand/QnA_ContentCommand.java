package com.slacademy.last_project.QnAcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.QnADao.QnADao;
import com.slacademy.last_project.QnADto.QnADto;

import mountain.mania.com_command.MCommand;

public class QnA_ContentCommand implements MCommand {

	@Override
	public void execute(Model model) {
System.out.println("QnA_ContentCommand");
		
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HttpSession session = request.getSession();
	    String u_id= (String) session.getAttribute("u_id");
		
		String b_id = request.getParameter("b_id");
		//String u_id = request.getParameter("u_id");
		
		System.out.println(b_id);
		System.out.println(u_id);
		
		QnADao dao = new QnADao();
		String uphit_change= "ok";
		
		QnADto dto = dao.QnAcontentView(b_id,uphit_change );
			
		
		model.addAttribute("content_view",dto);
		model.addAttribute("u_id",u_id);

	}

}
