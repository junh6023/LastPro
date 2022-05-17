package com.slacademy.last_project.Gcommand;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;
import com.slacademy.last_project.GDTO.GDto;

import mountain.mania.com_command.MCommand;

public class AppBigGroupListCommand implements MCommand{

	@Override
	public void execute(Model model) {
		GDao gdao = new GDao();
		//ArrayList<GDto>list = new ArrayList<GDto>();
		
		ArrayList<GDto>gdto= gdao.list();
		
		model.addAttribute("list", gdto);
		
		
		
	}

}
