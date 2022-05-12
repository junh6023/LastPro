package com.slacademy.last_project.Gcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;
import com.slacademy.last_project.GDTO.GDto;

import mountain.mania.com_command.MCommand;

public class BigGroupListCommand implements MCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub		
		GDao gdao = new GDao();
		//ArrayList<GDto>list = new ArrayList<GDto>();
		System.out.println("GroupListCommand 들어왔다");
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String check=request.getParameter("check");
		
		ArrayList<GDto>gdto= gdao.list();
		
		model.addAttribute("list", gdto);
		model.addAttribute("check", check);
		System.out.println(model);
		

	}

}
