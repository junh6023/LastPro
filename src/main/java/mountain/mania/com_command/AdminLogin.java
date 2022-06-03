package mountain.mania.com_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import mountain.mania.com_DAO.MDao;

public class AdminLogin implements MCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		MDao mdao = new MDao();
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		boolean usercheck=false;
		usercheck = mdao.adminlogin(id,pass);
		

	   	if(usercheck==false){
	   		model.addAttribute("usercheck", "no");
	   		
	   	}else {
	   	model.addAttribute("usercheck", "ok");
	   	}
	}
	

}
