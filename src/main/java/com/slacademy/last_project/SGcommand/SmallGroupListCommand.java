package com.slacademy.last_project.SGcommand;

import java.util.ArrayList;

import org.springframework.ui.Model;


import com.slacademy.last_project.SGDAO.SGDao;
import com.slacademy.last_project.SGDTO.SGDto;

import mountain.mania.com_command.MCommand;

public class SmallGroupListCommand implements MCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		SGDao sgdao=new SGDao();
		System.out.println("SmallGroupListCommand 들어왔다");
		
		ArrayList<SGDto>sgdto= sgdao.list();
		
		model.addAttribute("list", sgdto);
		System.out.println(model);

	}

}
