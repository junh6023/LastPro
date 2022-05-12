package com.slacademy.last_project.Gcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import mountain.mania.com_command.MCommand;

public class bg_Schedule_write_Command implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		


		
	}

}
