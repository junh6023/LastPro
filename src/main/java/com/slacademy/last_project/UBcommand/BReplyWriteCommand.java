package com.slacademy.last_project.UBcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.UBDao.BDao;
import com.slacademy.last_project.UBDto.BDto;

import mountain.mania.com_command.MCommand;

public class BReplyWriteCommand implements MCommand {

	@Override
	public void execute(Model model) {
	    Map<String ,Object> map=model.asMap();
	    HttpServletRequest request= (HttpServletRequest)map.get("request");
	    
		String b_id = request.getParameter("b_id");
		String u_id = request.getParameter("u_id");
		String uphit_change="no";
		BDao dao= new BDao();
		BDto dto = new BDto();
		
		try {
			
			dto=dao.contentView(b_id,uphit_change);
			model.addAttribute("dto", dto);
			model.addAttribute("u_id", u_id);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
