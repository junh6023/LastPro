package com.slacademy.last_project.SGcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;


import com.slacademy.last_project.SGDAO.SGDao;

import mountain.mania.com_command.MCommand;

public class sg_member_out_Command implements MCommand {

	@Override
	public void execute(Model model) {
		SGDao sgdao=new SGDao();
		System.out.println("sg_member_out_Command 들어옴");		
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int sg_id=Integer.parseInt(request.getParameter("sg_id"));
		String u_id = request.getParameter("u_id");
		System.out.println(sg_id);
		System.out.println(u_id);
		
		sgdao.sg_member_out(sg_id,u_id);
	}

}
