package com.slacademy.last_project.UBcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;


import com.slacademy.last_project.UBDao.BDao;
import com.slacademy.last_project.UBDto.BDto;

import mountain.mania.com_command.MCommand;


public class BContentCommand implements MCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		//model.addAttribute("request",request);
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String b_id = request.getParameter("b_id");
		System.out.println("BContentCommand");
		BDao dao = new BDao();
		
		String uphit_change= "ok";
		
		BDto dto = dao.contentView(b_id,uphit_change );
			
		
		model.addAttribute("content_view",dto);
		
	}

}
