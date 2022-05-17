package com.slacademy.last_project.Gcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;

import mountain.mania.com_command.MCommand;

public class Appbgjoin_noCommand implements MCommand {

	@Override
	public void execute(Model model) {
		GDao gdao = new GDao();
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int bgj_id =  Integer.parseInt(request.getParameter("bgj_id"));

		System.out.println(bgj_id);
		
		gdao.bg_no_add(bgj_id);

	}

}
