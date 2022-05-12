package com.slacademy.last_project.SGcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;



import com.slacademy.last_project.SGDAO.SGDao;
import com.slacademy.last_project.SGDTO.SGSDto;

import mountain.mania.com_command.MCommand;

public class sg_Schedule_checkCommand implements MCommand {

	@Override
	public void execute(Model model) {
		
		SGDao sgdao=new SGDao();
		System.out.println("sg_Schedule_Command 들어옴");		
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int sgs_id=Integer.parseInt(request.getParameter("sgs_id"));
		String title = request.getParameter("title");
		String sg_name= request.getParameter("sg_name");
		String u_id= request.getParameter("u_id");
		
		
		System.out.println(sgs_id);
		System.out.println(title);
		System.out.println(sg_name);
		System.out.println(u_id);
		
		ArrayList<SGSDto> gsdto=sgdao.sg_Schedule_check(sgs_id,title);
		boolean check=sgdao.check(sg_name,u_id);
		
		model.addAttribute("list", gsdto);
		model.addAttribute("check", check);
		
	}

}
