package com.slacademy.last_project.QnAcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.QnADao.QnADao;
import com.slacademy.last_project.QnADto.QnADto;

import mountain.mania.com_command.MCommand;

public class QnAReplyWriteCommand implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String ,Object> map=model.asMap();
	    HttpServletRequest request= (HttpServletRequest)map.get("request");
	    
		HttpSession session = request.getSession();
	    String u_id= (String) session.getAttribute("u_id");
	    
		String b_id = request.getParameter("b_id");
		//String u_id = request.getParameter("u_id");
		String uphit_change="no";
		QnADao dao= new QnADao();
		QnADto dto = new QnADto();
		
		dto=dao.QnAcontentView(b_id,uphit_change);
		model.addAttribute("dto", dto);
		model.addAttribute("u_id", u_id);

	}

}
