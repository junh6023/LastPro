package mountain.mania.com_command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.slacademy.last_project.GDAO.GDao;
import com.slacademy.last_project.GDTO.GDto;

import mountain.mania.com_DAO.MDao;
import mountain.mania.com_command.MCommand;

public class BigGroupListCommand6 implements MCommand{

	@Override
	public void execute(Model model1) {
		// TODO Auto-generated method stub
		MDao gdao = new MDao();
		//ArrayList<GDto>list = new ArrayList<GDto>();
		
//		Map<String, Object> map = model.asMap(); //model객체를 asMap을 이용해 Map으로 변환
//		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		//String check=request.getParameter("check");
		
		ArrayList<GDto>gdto= gdao.list6();
		
		model1.addAttribute("list6", gdto);
		//model.addAttribute("check", check);
		
		
	}

}
