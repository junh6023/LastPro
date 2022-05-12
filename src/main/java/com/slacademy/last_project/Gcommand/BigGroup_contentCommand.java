package com.slacademy.last_project.Gcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;
import com.slacademy.last_project.GDTO.GDto;

import mountain.mania.com_command.MCommand;

public class BigGroup_contentCommand implements MCommand {

	@Override
	public void execute(Model model) {
		GDao gdao=new GDao();
		System.out.println("GroupcontentCommand 들어옴");
		
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		
		int bg_id = Integer.parseInt(request.getParameter("bg_id"));
		
		ArrayList<GDto> list=gdao.Groupcontent(bg_id);
		
		model.addAttribute("content", list);
		System.out.println(model);
		

	}

}
