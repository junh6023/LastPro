package com.slacademy.last_project.Gcommand;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;

import mountain.mania.com_command.MCommand;

public class Appbig_group_addCommand implements MCommand {

	@Override
	public void execute(Model model) {
		GDao gdao = new GDao();
		
		String u_id = "test1";
		String g_name = "yiyi";
		String g_intro = "hihi";

		gdao.Group_add(u_id,g_name,g_intro);

	}

}
