package com.slacademy.last_project.SGcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.SGDAO.SGDao;

import mountain.mania.com_command.MCommand;

public class sg_active_saveCommand implements MCommand {

	@Override
	public void execute(Model model) {
		SGDao gdao=new SGDao();
		System.out.println("sg_active_saveCommand 들어옴");
		
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int m_id = Integer.parseInt(request.getParameter("m_id")) ;
		int sg_id = Integer.parseInt(request.getParameter("sg_id"));
		int c_id= Integer.parseInt(request.getParameter("c_id"));
		int climb = Integer.parseInt(request.getParameter("climb"));
		//String u_id= request.getParameter("u_id");
		
		HttpSession session = request.getSession();
	    String u_id= (String) session.getAttribute("u_id");
		
		System.out.println(m_id);
		System.out.println(sg_id);
		System.out.println(c_id);
		System.out.println(climb);
		System.out.println(u_id);
		
		
		
		gdao.sg_active_save(m_id,sg_id,c_id,climb);

		model.addAttribute("u_id", u_id);

	}

}
