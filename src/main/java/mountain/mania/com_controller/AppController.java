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

import com.slacademy.last_project.GDTO.GDto;

import com.slacademy.last_project.Gcommand.*;

import Appbig_group_addCommand.java.AppBigGroup_joinCommand;
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
	   @RequestMapping("/appbglist")
	   @ResponseBody
	   public Map<String,Object > androidTestWithRequestAndResponse2(Model model){
	       Map<String, Object> result = new HashMap<String, Object>();
	       Map<String, Object> map = model.asMap();
	       
	      System.out.println("동호회 리스트 컨트롤러");   
	      command = new AppBigGroupListCommand();
	      
	      command.execute(model);   
	  
	      ArrayList asd=(ArrayList)map.get("list");
	     
	      for(int i=0 ; i<asd.size();i++) {
	      result.put("list"+i, asd.get(i));
	      }
	        return result;
	}
	   @RequestMapping("/appbgranklist")
	   @ResponseBody
	   public Map<String,Object > androidTestWithRequestAndResponse3(Model model){
	       Map<String, Object> result = new HashMap<String, Object>();
	       Map<String, Object> map = model.asMap();
	       
	      System.out.println("동호회 리스트 컨트롤러");   
	      command = new bg_rank();
	      
	      command.execute(model);   
	   
	      ArrayList asd=(ArrayList)map.get("bg_rank");
	     
	      for(int i=0 ; i<asd.size();i++) {
	      result.put("bg_rank"+i, asd.get(i));
	      }
	        return result;
	}
	   @RequestMapping("/appbgranksearch")
	   @ResponseBody
	   public Map<String,Object > androidTestWithRequestAndResponse4(Model model){
	       Map<String, Object> result = new HashMap<String, Object>();
	       Map<String, Object> map = model.asMap();
	       
	      System.out.println("동호회 서치");   
	      command = new Appbg_rankSearch();
	      
	      command.execute(model);   
	   
	      ArrayList asd=(ArrayList)map.get("list");
	     
	      for(int i=0 ; i<asd.size();i++) {
	      result.put("list"+i, asd.get(i));
	      }
	        return result;
	}
	   
	   @RequestMapping("/appbgadd")
	   @ResponseBody
	   public Map<String,Object > androidTestWithRequestAndResponse5(Model model){
	       Map<String, Object> result = new HashMap<String, Object>();
	       Map<String, Object> map = model.asMap();
	       
	      System.out.println("동호회 만들기 페이지 컨트롤러 ");   // u_id 받아서 이미 동호회멤버인 사람은 새 동호회 만들기 안됨
	      command = new Appbig_group_addCommand();
	      
	      command.execute(model);   
	   
	        return result;
	}
	   
	   @RequestMapping("/appbgjoin")
	   @ResponseBody
	   public Map<String,Object > androidTestWithRequestAndResponse6(Model model){
	       Map<String, Object> result = new HashMap<String, Object>();
	       Map<String, Object> map = model.asMap();
	       
	      System.out.println("동호회 가입 컨트롤러");   
	      command = new AppBigGroup_joinCommand();
	      
	      command.execute(model);   
	   
	      ArrayList asd=(ArrayList)map.get("check");
	     
	      for(int i=0 ; i<asd.size();i++) {
	      result.put("check"+i, asd.get(i));
	      }
	        return result;
	}
	
	   
	   @RequestMapping("/appbgjoinlist")//내가 가입신청한 리스트
	   @ResponseBody
	   public Map<String,Object > androidTestWithRequestAndResponse7(Model model){
	       Map<String, Object> result = new HashMap<String, Object>();
	       Map<String, Object> map = model.asMap();
	       
	      System.out.println("가입신청한 리스트 컨트롤러");   
	      command = new AppBigGroup_joinListCommand();
	      
	      command.execute(model);   
	   
	      ArrayList asd=(ArrayList)map.get("join_list");
	     
	      for(int i=0 ; i<asd.size();i++) {
	      result.put("join_list"+i, asd.get(i));
	      }
	        return result;
	}
	   
	   @RequestMapping("/appbgjoinlist_gi")//가입신청온 리스트 모임장이 확인 가능
	   @ResponseBody
	   public Map<String,Object > androidTestWithRequestAndResponse8(Model model){
	       Map<String, Object> result = new HashMap<String, Object>();
	       Map<String, Object> map = model.asMap();
	       
	      System.out.println("가입신청온 리스트 컨트롤러");   
	      command = new Appbg_joinlist_giCommand();
	      
	      command.execute(model);   
	   
	      ArrayList asd=(ArrayList)map.get("joinlist");
	     
	      for(int i=0 ; i<asd.size();i++) {
	      result.put("join_list"+i, asd.get(i));
	      }
	        return result;
	}
	   
	   
	   @RequestMapping("/appbgjoin_yes")//가입신청온 리스트 모임장이 확인 가능
	   @ResponseBody
	   public Map<String,Object > androidTestWithRequestAndResponse9(Model model){
	       Map<String, Object> result = new HashMap<String, Object>();
	       Map<String, Object> map = model.asMap();
	       
	      System.out.println("가입신청 승인 컨트롤러");   
	      command = new Appbgjoin_yesCommand();
	      
	      command.execute(model);   
	   
	   
	        return result;
	}
	   
	   
	   @RequestMapping("/appbgjoin_no")//가입신청온 리스트 모임장이 확인 가능
	   @ResponseBody
	   public Map<String,Object > androidTestWithRequestAndResponse10(Model model){
	       Map<String, Object> result = new HashMap<String, Object>();
	       Map<String, Object> map = model.asMap();
	       
	      System.out.println("가입신청 거절 컨트롤러");   
	      command = new Appbgjoin_noCommand();
	      
	      command.execute(model);   
	   
	        return result;
	}
	   
}
