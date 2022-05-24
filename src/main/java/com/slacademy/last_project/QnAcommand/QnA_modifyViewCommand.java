package com.slacademy.last_project.QnAcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.QnADao.QnADao;
import com.slacademy.last_project.QnADto.QnADto;

import mountain.mania.com_command.MCommand;

public class QnA_modifyViewCommand implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); //Map
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String b_id = request.getParameter("b_id");
		
		String uphit_change="no";
		
		QnADao dao = new QnADao();
		QnADto dto = dao.QnAcontentView(b_id,uphit_change);
		
		model.addAttribute("content_view",dto);

	}

}
