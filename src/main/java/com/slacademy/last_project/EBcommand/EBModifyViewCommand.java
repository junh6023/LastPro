package com.slacademy.last_project.EBcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.UBDao.BDao;
import com.slacademy.last_project.UBDto.BDto;

import mountain.mania.com_command.MCommand;

public class EBModifyViewCommand implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); //Map
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String b_id = request.getParameter("b_id");
		
		String uphit_change="no";
		
		BDao dao = new BDao();
		BDto dto = dao.EcontentView(b_id,uphit_change);
		
		model.addAttribute("content_view",dto);
	}

}
