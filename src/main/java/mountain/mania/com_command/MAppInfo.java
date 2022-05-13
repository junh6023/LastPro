package mountain.mania.com_command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

import mountain.mania.com_DAO.MDao;

public class MAppInfo implements MCommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		MDao mdao = new MDao();
		List boardlist=new ArrayList();
		boardlist = mdao.getAppMList();
		
		model.addAttribute("list", boardlist);
		
		
	}

}
