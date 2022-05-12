package mountain.mania.com_command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import mountain.mania.com_DAO.MDao;
import mountain.mania.com_DTO.MDto;


public class MList implements MCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		MDao mdao = new MDao();
		MDto idto = new MDto();
		List boardlist=new ArrayList(); //게시글을 읽어오기위해

        boardlist = mdao.getMList(); //리스트를 받아옴.
        
        request.setAttribute("boardlist", boardlist);
      

		
	}
		
	

}
