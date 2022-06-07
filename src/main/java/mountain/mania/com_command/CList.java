package mountain.mania.com_command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import mountain.mania.com_DAO.MDao;

public class CList implements MCommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		MDao mdao = new MDao();
		List boardlist=new ArrayList(); //게시글을 읽어오기위해
		String m_id=request.getParameter("m_id");
        boardlist = mdao.getCList(m_id); //리스트를 받아옴.
        
        request.setAttribute("clist", boardlist);
      

	}

}
