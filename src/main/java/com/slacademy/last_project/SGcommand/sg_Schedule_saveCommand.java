package com.slacademy.last_project.SGcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;



import com.slacademy.last_project.SGDAO.SGDao;

import mountain.mania.com_command.MCommand;

public class sg_Schedule_saveCommand implements MCommand {

	@Override
	public void execute(Model model) {
		
		System.out.println("스케줄 DB저장할 sg_Schedule_saveCommand");
		
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		SGDao sgdao=new SGDao();
		
		int m_id = Integer.parseInt(request.getParameter("m_id"));
		int c_id = Integer.parseInt(request.getParameter("course"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		//String u_id=request.getParameter("u_id");
		
		
		HttpSession session = request.getSession();
	    String u_id= (String) session.getAttribute("u_id");
		
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");		
		String date= year.concat("-"+month).concat("-"+day);
		
		System.out.println(m_id);
		System.out.println(c_id);
		System.out.println(title);
		System.out.println(content);
		System.out.println(date);
		System.out.println(u_id);
		
		sgdao.schedule_save(m_id,c_id,title,content,date,u_id);
		
		model.addAttribute("u_id", u_id);
	
	}

}
