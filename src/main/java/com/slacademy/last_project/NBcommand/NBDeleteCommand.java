package com.slacademy.last_project.NBcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.UBDao.BDao;

import mountain.mania.com_command.MCommand;



public class NBDeleteCommand implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); //Map
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String b_id = request.getParameter("b_id");
		String b_pw = request.getParameter("b_pw");
		System.out.println(b_id);
		System.out.println(b_pw);	   	
		BDao dao = new BDao();
		String pass= dao.NPwCheck(b_id);
		System.out.println(pass);
		if(pass.equals(b_pw)) {
			dao.NbDelete(b_id);
		}else{System.out.println("비밀번호 확인 요망");
		
	}
	}

}
