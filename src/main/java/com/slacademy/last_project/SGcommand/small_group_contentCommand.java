package com.slacademy.last_project.SGcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;


import com.slacademy.last_project.SGDAO.SGDao;
import com.slacademy.last_project.SGDTO.SGDto;

import mountain.mania.com_command.MCommand;

public class small_group_contentCommand implements MCommand {

	@Override
	public void execute(Model model) {
		SGDao sgdao=new SGDao();
		System.out.println("SGroupcontentCommand 들어옴");
		
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		
		int sg_id = Integer.parseInt(request.getParameter("sg_id"));
		
		ArrayList<SGDto> list=sgdao.Groupcontent(sg_id);
		
		model.addAttribute("content", list);
		System.out.println(model);

	}

}
