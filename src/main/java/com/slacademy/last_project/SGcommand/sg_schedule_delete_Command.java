package com.slacademy.last_project.SGcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;



import com.slacademy.last_project.SGDAO.SGDao;

import mountain.mania.com_command.MCommand;

public class sg_schedule_delete_Command implements MCommand {

	@Override
	public void execute(Model model) {
		SGDao sgdao=new SGDao();
		System.out.println("sg_schedule_delete_Command 들어옴");
		
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int sgs_id = Integer.parseInt(request.getParameter("sgs_id"));
		String u_id=request.getParameter("u_id");
		System.out.println(sgs_id);
		System.out.println(u_id);
		
		sgdao.sg_schedule_delete(sgs_id);
		
		model.addAttribute("u_id", u_id);

	}

}
