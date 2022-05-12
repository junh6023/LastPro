package com.slacademy.last_project.Gcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;
import com.slacademy.last_project.GDTO.GJoinDto;

import mountain.mania.com_command.MCommand;

public class bg_joinlist_giCommand implements MCommand {

	@Override
	public void execute(Model model) {
		GDao gdao=new GDao();
		System.out.println("모임장이보는 bg_joinlist_giCommand 들어옴");
		
		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String u_id=request.getParameter("u_id");
		System.out.println("u_id : " +u_id);
		
		ArrayList<GJoinDto> gjdto = gdao.mybg_joinlist(u_id);
		
		model.addAttribute("joinlist", gjdto);

	}

}
