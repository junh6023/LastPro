package mountain.mania.com_controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mountain.mania.com_DTO.MDto;
import mountain.mania.com_command.MAppInfo;
import mountain.mania.com_command.MCommand;
import mountain.mania.com_command.MLevelHigh;
import mountain.mania.com_util.Constant;
@Controller
public class AppController {
	MCommand command = null;
	private JdbcTemplate template;

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
		System.out.println("start");
	}
	
	   @RequestMapping("/app")
	   @ResponseBody
	   public Map<String,Object > androidTestWithRequestAndResponse(Model model){
	       Map<String, Object> result = new HashMap<String, Object>();
	       Map<String, Object> map = model.asMap();
	       
	      System.out.println("동호회 리스트 컨트롤러");   
	      command = new MAppInfo();
	      
	      command.execute(model);   
	      System.out.println("익스큐트 실행완료");
	      ArrayList<MDto> asd=(ArrayList)map.get("list");
	      System.out.println("asd: "+asd);
	      for(int i=0 ; i<asd.size();i++) {
	      result.put("list"+i, asd.get(i));
	      }
	        return result;
	}

	
}
