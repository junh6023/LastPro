package mountain.mania.com_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import mountain.mania.com_DAO.MDao;

public class Mcourse_delete implements MCommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
	   
	   	int c_id=Integer.parseInt(request.getParameter("c_id"));
	   	
	    MDao mdao=new MDao();
	   	
	   	
	   	mdao.CDelete(c_id);
		
	}
	
	

}
