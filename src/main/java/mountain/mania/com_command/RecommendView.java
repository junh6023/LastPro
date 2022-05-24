package mountain.mania.com_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import mountain.mania.com_DAO.MDao;

public class RecommendView implements MCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("u_id") != null) {			
			String u_id= (String) session.getAttribute("u_id");
			MDao mdao=new MDao();
			int result = mdao.getRecommend(u_id);
			
			model.addAttribute("levelresult",result);
		} else {			
			model.addAttribute("idnull","idnull");
		}
		
//		if(u_id==null) {
//		}else {
//			
//		}
	   
	    
		
	}

}
