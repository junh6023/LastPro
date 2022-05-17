package mountain.mania.com_command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import mountain.mania.com_DAO.MDao;

public class MCourseDetail implements MCommand{

	@Override
	public void execute(Model model) {
		System.out.println("test1");
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String c_id= request.getParameter("c_id");
		System.out.println("actionclass c_id: " +c_id);
		MDao mdao = new MDao();
		List clist=new ArrayList();
		mdao.cupdate(c_id);
		clist = mdao.CourseDetail(c_id);
		model.addAttribute("list", clist);
	}

}
