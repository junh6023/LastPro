package com.slacademy.last_project.Gcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;

import mountain.mania.com_command.MCommand;

public class AppBigGroup_joinCommand implements MCommand {

	@Override
	public void execute(Model model) {
		System.out.println("BigGroup_joinCommand 들어옴");
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		GDao gdao= new GDao();
			
		HttpSession session = request.getSession();
	    String u_id= (String) session.getAttribute("u_id");

		
		int bg_id=Integer.parseInt(request.getParameter("bg_id"));
		//String u_id=request.getParameter("u_id");
		String bg_name=request.getParameter("bg_name");
		
		System.out.println(bg_id);
		System.out.println(u_id);
		System.out.println(bg_name);
		
		boolean check= gdao.Create_bg_check(u_id);
		System.out.println(check);
		
		if(check==true) {
			System.out.println("true니까 join에 저장할께~");
		gdao.big_group_join(bg_id,u_id,bg_name);
		}
		
		model.addAttribute("check", check);

	}

}
