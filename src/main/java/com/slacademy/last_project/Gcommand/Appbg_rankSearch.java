package com.slacademy.last_project.Gcommand;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;

import mountain.mania.com_command.MCommand;

public class Appbg_rankSearch implements MCommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		String search="hh"; //이거바꿔라 민규야 
		System.out.println(search);
		
		GDao gdao = new GDao();
		
		ArrayList search_list=gdao.search(search);
		System.out.println(search_list);
		
		model.addAttribute("list", search_list);
		
	}

}
