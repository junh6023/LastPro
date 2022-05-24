package com.slacademy.last_project.CScommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.CSDao.CSDao;
import com.slacademy.last_project.CSDto.CSDto;

import mountain.mania.com_command.MCommand;


public class CSModifyViewCommand implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); //Map
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String b_id = request.getParameter("b_id");
		
		String uphit_change="no";
		
		CSDao dao = new CSDao();
		CSDto dto = dao.EcontentView(b_id,uphit_change);
		
		model.addAttribute("content_view",dto);

	}

}
