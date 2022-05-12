package mountain.mania.com_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import mountain.mania.com_DAO.MDao;

public class RecommendView implements MCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String u_id = request.getParameter("u_id");
		MDao mdao=new MDao();
		
		int result = mdao.getRecommend(u_id);
		
		request.setAttribute("levelresult",result);
	}

}
