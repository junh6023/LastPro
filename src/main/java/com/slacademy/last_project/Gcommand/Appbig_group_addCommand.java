package com.slacademy.last_project.Gcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;

import mountain.mania.com_command.MCommand;

public class Appbig_group_addCommand implements MCommand {

	@Override
	public void execute(Model model) {
		GDao gdao = new GDao();
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HttpSession session = request.getSession();
	      String u_id= (String) session.getAttribute("u_id");
	      //String u_id="dd";
		String g_name = "yiyi";
		String g_intro = "hihi";

		gdao.Group_add(u_id,g_name,g_intro);

	}

}
