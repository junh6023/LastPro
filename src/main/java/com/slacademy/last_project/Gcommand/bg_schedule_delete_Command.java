package com.slacademy.last_project.Gcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;

import mountain.mania.com_command.MCommand;

public class bg_schedule_delete_Command implements MCommand {

	@Override
	public void execute(Model model) {
		GDao gdao=new GDao();
		System.out.println("bg_schedule_delete_Command 들어옴");
		
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int bgs_id = Integer.parseInt(request.getParameter("bgs_id"));
		String u_id=request.getParameter("u_id");
		System.out.println(bgs_id);
		System.out.println(u_id);
		
		gdao.bg_schedule_delete(bgs_id);
		
		model.addAttribute("u_id", u_id);

	}

}
