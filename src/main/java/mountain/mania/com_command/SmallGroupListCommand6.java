package mountain.mania.com_command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.slacademy.last_project.SGDAO.SGDao;
import com.slacademy.last_project.SGDTO.SGDto;

public class SmallGroupListCommand6 implements MCommand{

	@Override
	public void execute(Model model) {
		SGDao sgdao=new SGDao();
		System.out.println("SmallGroupListCommand 들어왔다");
		
		ArrayList<SGDto>sgdto= sgdao.Slist6();
		
		model.addAttribute("Slist6", sgdto);
		System.out.println(model);

	}
	

}
