package com.slacademy.last_project.QnAcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.QnADao.QnADao;

import mountain.mania.com_command.MCommand;

public class QnA_ReplyCommand implements MCommand {

	@Override
	public void execute(Model model) {
		QnADao dao = new QnADao(); //데이터베이스 접속.
		Map<String, Object> map = model.asMap(); //Map
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String b_id = request.getParameter("b_id");
		String b_lev = request.getParameter("b_lev");
		//String u_id = request.getParameter("u_id");
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");
		String b_pw = request.getParameter("b_pw");

		HttpSession session = request.getSession();
	    String u_id= (String) session.getAttribute("u_id");

		dao.Replywrite(b_id,b_lev,u_id,b_title,b_content,b_pw);
		
	}

}
