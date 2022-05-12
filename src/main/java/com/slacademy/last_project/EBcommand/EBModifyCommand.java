package com.slacademy.last_project.EBcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.UBDao.BDao;

import mountain.mania.com_command.MCommand;

public class EBModifyCommand implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); //Map
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String u_id = request.getParameter("u_id");
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");
		String b_id = request.getParameter("b_id");
		String b_pw = request.getParameter("b_pw");
		String b_img= request.getParameter("file");
		System.out.println(b_id);
		System.out.println(b_pw);
	 	boolean result=false;
	   	boolean usercheck=false;
		BDao dao = new BDao();
		String pass = dao.EPwCheck(b_id);
		if(pass.equals(b_pw)) {
			dao.EbModifyAction(b_id,u_id,b_title,b_content,b_img);
		}else{System.out.println("비밀번호 확인 요망");
		
	}

	}

}
