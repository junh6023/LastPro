package com.slacademy.last_project.SGcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;


import com.slacademy.last_project.SGDAO.SGDao;

import mountain.mania.com_command.MCommand;

public class sg_yescommand implements MCommand {

	@Override
	public void execute(Model model) {
		SGDao sgdao = new SGDao();
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String u_id=request.getParameter("u_id");
		int sg_id = Integer.parseInt(request.getParameter("sg_id"));
		int sgj_id =  Integer.parseInt(request.getParameter("sgj_id"));

		System.out.println(u_id);
		System.out.println(sg_id);
		System.out.println(sgj_id);
		
		sgdao.Group_member_add(sg_id, u_id,sgj_id);

	}

}
