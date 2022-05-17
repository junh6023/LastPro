package mountain.mania.com_command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import mountain.mania.com_DAO.MDao;

public class MCourseView implements MCommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		MDao mdao = new MDao();
		String m_id = request.getParameter("m_id");
		System.out.println("mid: "+request.getParameter("m_id"));
		List clist=new ArrayList();
		clist = mdao.ViewCourse(m_id);
		model.addAttribute("list", clist);
		
	}
	

}
