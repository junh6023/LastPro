package mountain.mania.com_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import mountain.mania.com_DAO.MDao;

public class IDelete implements MCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
	   
	   	int item_id=Integer.parseInt(request.getParameter("item_id"));
	   	
	    MDao mdao=new MDao();
	   	
	   	
	   	mdao.IDelete(item_id);
	}

}
