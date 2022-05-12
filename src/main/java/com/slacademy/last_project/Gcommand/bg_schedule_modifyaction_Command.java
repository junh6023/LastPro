package com.slacademy.last_project.Gcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;

import mountain.mania.com_command.MCommand;

public class bg_schedule_modifyaction_Command implements MCommand {

	@Override
	public void execute(Model model) {
		
		System.out.println("스케줄 DB update할 bg_schedule_modifyaction_Command");
		
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		GDao gdao=new GDao();
		
		String m_name= request.getParameter("m_name");
		String c_name = request.getParameter("c_name");
		String title=request.getParameter("bgs_title");
		String content=request.getParameter("content");
		int bgs_id = Integer.parseInt(request.getParameter("bgs_id"));
		String u_id=request.getParameter("u_id");
		
		
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");		
		String date= year.concat("-"+month).concat("-"+day);
		
		System.out.println(m_name);
		System.out.println(c_name);
		System.out.println(title);
		System.out.println(content);
		System.out.println(date);
		System.out.println(bgs_id);
		System.out.println(u_id);
		
		gdao.schedule_update(m_name,c_name,title,content,date,bgs_id);
		
		model.addAttribute("u_id", u_id);

	}

}
