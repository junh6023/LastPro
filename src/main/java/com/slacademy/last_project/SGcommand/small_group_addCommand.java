package com.slacademy.last_project.SGcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.SGDAO.SGDao;

import mountain.mania.com_command.MCommand;

public class small_group_addCommand implements MCommand {

	@Override
	public void execute(Model model) {
		
		SGDao sgdao = new SGDao();
		

		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HttpSession session = request.getSession();
	    String u_id= (String) session.getAttribute("u_id");
		
		//String u_id = request.getParameter("u_id");
		String sg_name = request.getParameter("sg_name");
		String sg_intro = request.getParameter("sg_intro");
		
		System.out.println(u_id);
		System.out.println(sg_name);
		System.out.println(sg_intro);
		
		boolean sg_nameCheck= sgdao.sg_nameCheck(sg_name);
		System.out.println(sg_nameCheck);
		
		if(sg_nameCheck==true) {
			sgdao.SGroup_add(u_id,sg_name,sg_intro);
		}
		
		model.addAttribute("sg_nameCheck", sg_nameCheck);
		
	}

}
