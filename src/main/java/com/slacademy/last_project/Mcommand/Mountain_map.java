package com.slacademy.last_project.Mcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDTO.GDto;
import com.slacademy.last_project.SGDTO.SGDto;

import mountain.mania.com_DAO.MDao;
import mountain.mania.com_DTO.MDto;
import mountain.mania.com_command.MCommand;


public class Mountain_map implements MCommand {

	@Override
	public void execute(Model model) {
		System.out.println("Mountain_map 커맨드 들어옴");
		
		
		MDao mdao=new MDao();
		ArrayList<MDto> list = mdao.mountain();
		
		System.out.println(list);
		
		ArrayList<GDto>gdto= mdao.list6();
		ArrayList<SGDto>sgdto= mdao.Slist6();
		ArrayList<GDto>gdtorank=mdao.bg_rank6();
		model.addAttribute("list", list);
		 
		 model.addAttribute("bg_rank", gdtorank);
		model.addAttribute("slist6", sgdto);
		model.addAttribute("list6", gdto);
		

	}

}
