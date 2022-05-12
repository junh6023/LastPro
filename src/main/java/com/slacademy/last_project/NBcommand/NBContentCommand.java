package com.slacademy.last_project.NBcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.UBDao.BDao;
import com.slacademy.last_project.UBDto.BDto;

import mountain.mania.com_command.MCommand;


public class NBContentCommand implements MCommand {

	@Override
	public void execute(Model model) {
		//model.addAttribute("request",request);
				Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
				HttpServletRequest request = (HttpServletRequest) map.get("request");
				
				String b_id = request.getParameter("b_id");
				String u_id = request.getParameter("u_id");
				System.out.println("EBContentCommand");
				BDao dao = new BDao();
				
				String uphit_change= "ok";
				
				BDto dto = dao.NcontentView(b_id,uphit_change );
					
				
				model.addAttribute("content_view",dto);
				model.addAttribute("u_id",u_id);


	}

}
