package mountain.mania.com_controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slacademy.last_project.EBcommand.AppEBListCommand;
import com.slacademy.last_project.GDTO.GDto;

import com.slacademy.last_project.Gcommand.*;
import com.slacademy.last_project.SGcommand.AppSG_joinListCommand;
import com.slacademy.last_project.SGcommand.AppSmallGroupListCommand;
import com.slacademy.last_project.SGcommand.Appjoin_sg_listCommand;
import com.slacademy.last_project.SGcommand.Appsg_activeCommand;
import com.slacademy.last_project.SGcommand.Appsg_joinlist_giCommand;
import com.slacademy.last_project.SGcommand.Appsg_member_listCommand;
import com.slacademy.last_project.SGcommand.Appsgjoin_noCommand;
import com.slacademy.last_project.SGcommand.Appsgjoin_yesCommand;
import com.slacademy.last_project.SGcommand.Appsglist_searchCommand;
import com.slacademy.last_project.SGcommand.Appsmall_group_addCommand;
import com.slacademy.last_project.SGcommand.Appsmall_group_joinCommand;

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
	       
	       
	      command = new MAppInfo();
	      
	      command.execute(model);   
	      System.out.println("???????????? ????????????");
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
	          
	         System.out.println("????????? ????????? ????????????");   
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
	          
	         System.out.println("????????? ?????? ????????????");   
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
	          
	         System.out.println("??????????????? ??????");   
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
	      public void androidTestWithRequestAndResponse5(Model model){
	          Map<String, Object> result = new HashMap<String, Object>();
	          Map<String, Object> map = model.asMap();
	          
	         System.out.println("????????? ????????? ????????? ???????????? ");   // u_id ????????? ?????? ?????????????????? ????????? ??? ????????? ????????? ??????
	         command = new Appbig_group_addCommand();
	         
	         command.execute(model);   
	      
	      
	   }
	      
	      @RequestMapping("/appbgjoin")
	      @ResponseBody
	      public Map<String,Object > androidTestWithRequestAndResponse6(Model model){
	          Map<String, Object> result = new HashMap<String, Object>();
	          Map<String, Object> map = model.asMap();
	          
	         System.out.println("????????? ?????? ????????????");   
	         command = new AppBigGroup_joinCommand();
	         
	         command.execute(model);   
	      
	         ArrayList asd=(ArrayList)map.get("check");
	        
	         for(int i=0 ; i<asd.size();i++) {
	         result.put("check"+i, asd.get(i));
	         }
	           return result;
	   }
	   
	      
	      @RequestMapping("/appbgjoinlist")//?????? ??????????????? ?????????
	      @ResponseBody
	      public Map<String,Object > androidTestWithRequestAndResponse7(Model model){
	          Map<String, Object> result = new HashMap<String, Object>();
	          Map<String, Object> map = model.asMap();
	          
	         System.out.println("??????????????? ????????? ????????????");   
	         command = new AppBigGroup_joinListCommand();
	         
	         command.execute(model);   
	      
	         ArrayList asd=(ArrayList)map.get("join_list");
	        
	         for(int i=0 ; i<asd.size();i++) {
	         result.put("join_list"+i, asd.get(i));
	         }
	           return result;
	   }
	      
	      @RequestMapping("/appbgjoinlist_gi")//??????????????? ????????? ???????????? ?????? ??????
	      @ResponseBody
	      public Map<String,Object > androidTestWithRequestAndResponse8(Model model){
	          Map<String, Object> result = new HashMap<String, Object>();
	          Map<String, Object> map = model.asMap();
	          
	         System.out.println("??????????????? ????????? ????????????");   
	         command = new Appbg_joinlist_giCommand();
	         
	         command.execute(model);   
	      
	         ArrayList asd=(ArrayList)map.get("joinlist");
	        
	         for(int i=0 ; i<asd.size();i++) {
	         result.put("join_list"+i, asd.get(i));
	         }
	           return result;
	   }
	      
	      
	      @RequestMapping("/appbgjoin_yes")//??????????????? ????????? ???????????? ?????? ??????
	      @ResponseBody
	      public void androidTestWithRequestAndResponse9(HttpServletRequest request, Model model){
	        String str="";
	        model.addAttribute("request",request);
	         System.out.println("???????????? ?????? ????????????");   
	         command = new Appbgjoin_yesCommand();
	         
	         command.execute(model);   

	   }
	      
	      
	      @RequestMapping("/appbgjoin_no")//??????????????? ????????? ???????????? ?????? ??????
	      @ResponseBody
	      public void androidTestWithRequestAndResponse10(HttpServletRequest request, Model model){
	         String str="";
	         model.addAttribute("request",request);
	         
	         System.out.println("???????????? ?????? ????????????");   
	         command = new Appbgjoin_noCommand();
	         
	         command.execute(model);   

	   }
	      
	      //????????? ???????????????
	      @RequestMapping("/app_join_bgroup_list")
	      @ResponseBody
	      public Map<String,Object > androidTestWithRequestAndResponse21(Model model){
	          Map<String, Object> result = new HashMap<String, Object>();
	          Map<String, Object> map = model.asMap();
	     
	         command = new Appjoin_bg_listCommand();
	         
	         command.execute(model);   
	     
	         ArrayList asd=(ArrayList)map.get("join_bg_list");
	        
	         for(int i=0 ; i<asd.size();i++) {
	         result.put("join_bg_list"+i, asd.get(i));
	         }
	           return result;
	   }
	      
	      //???????????? ???????????? ??????
	      @RequestMapping("/app_bg_active")
	      @ResponseBody
	      public Map<String,Object > androidTestWithRequestAndResponse22(Model model){
	          Map<String, Object> result = new HashMap<String, Object>();
	          Map<String, Object> map = model.asMap();
	     
	         command = new AppactiveCommand();
	         
	         command.execute(model);   
	     
	         ArrayList asd=(ArrayList)map.get("list");
	        
	         for(int i=0 ; i<asd.size();i++) {
	         result.put("list"+i, asd.get(i));
	         }
	           return result;
	   }
	      
	    //????????????????????????
	      @RequestMapping("/appbg_member_list")
	      @ResponseBody
	      public Map<String,Object > androidTestWithRequestAndResponse23(Model model){
	          Map<String, Object> result = new HashMap<String, Object>();
	          Map<String, Object> map = model.asMap();
	     
	         command = new Appbg_member_listCommand();
	         
	         command.execute(model);   
	     
	         ArrayList asd=(ArrayList)map.get("bg_member");
	        
	         for(int i=0 ; i<asd.size();i++) {
	         result.put("bg_member"+i, asd.get(i));
	         }
	           return result;
	   }
	      
	////////////////////////////////////////////?????????//////////////////////////////////////////////////////////

	      //????????? ?????????
	      @RequestMapping("/appsglist")
	      @ResponseBody
	      public Map<String,Object > androidTestWithRequestAndResponse11(Model model){
	          Map<String, Object> result = new HashMap<String, Object>();
	          Map<String, Object> map = model.asMap();
	          
	         
	         command = new AppSmallGroupListCommand();
	         
	         command.execute(model);   
	     
	         ArrayList asd=(ArrayList)map.get("list");
	        
	         for(int i=0 ; i<asd.size();i++) {
	         result.put("list"+i, asd.get(i));
	         }
	           return result;
	   }
	      //????????? ????????? ??????
	      @RequestMapping("/appsglist_search")
	      @ResponseBody
	      public Map<String,Object > androidTestWithRequestAndResponse12(Model model){
	          Map<String, Object> result = new HashMap<String, Object>();
	          Map<String, Object> map = model.asMap();
	     
	         command = new Appsglist_searchCommand();
	         
	         command.execute(model);   
	     
	         ArrayList asd=(ArrayList)map.get("list");
	        
	         for(int i=0 ; i<asd.size();i++) {
	         result.put("list"+i, asd.get(i));
	         }
	           return result;
	   }
	      
	      @RequestMapping("/appsg_addCommand")
	      @ResponseBody
	      public void androidTestWithRequestAndResponse13(HttpServletRequest request, Model model){
	         String str="";
	         model.addAttribute("request",request);
	          
	         System.out.println("?????? ?????? ????????????");   
	         command = new Appsmall_group_addCommand();
	         
	         command.execute(model);   
	   }
	      
	      @RequestMapping("/appsgjoin")
	      @ResponseBody
	      public void androidTestWithRequestAndResponse14(HttpServletRequest request, Model model){
	         String str="";
	         model.addAttribute("request",request);
	          
	         System.out.println("?????? ?????? ????????????");   
	         command = new Appsmall_group_joinCommand();         
	         command.execute(model);   
	      
	   }


	//////////////////////////////////////////////////////////////////////////////////////////////////
	      @RequestMapping("/appsgjoinlist")//?????? ??????????????? ?????????
	      @ResponseBody
	      public Map<String,Object > androidTestWithRequestAndResponse15(Model model){
	          Map<String, Object> result = new HashMap<String, Object>();
	          Map<String, Object> map = model.asMap();
	          
	         System.out.println("??????????????? ????????? ????????????");   
	         command = new AppSG_joinListCommand();
	         
	         command.execute(model);   
	      
	         ArrayList asd=(ArrayList)map.get("join_list");
	        
	         for(int i=0 ; i<asd.size();i++) {
	         result.put("join_list"+i, asd.get(i));
	         }
	           return result;
	      }
	      
	      @RequestMapping("/appsgjoinlist_gi")//??????????????? ????????? ???????????? ?????? ??????
	      @ResponseBody
	      public Map<String,Object > androidTestWithRequestAndResponse16(Model model){
	          Map<String, Object> result = new HashMap<String, Object>();
	          Map<String, Object> map = model.asMap();
	          
	         System.out.println("??????????????? ????????? ????????????");   
	         command = new Appsg_joinlist_giCommand();
	         
	         command.execute(model);   
	      
	         ArrayList asd=(ArrayList)map.get("joinlist");
	        
	         for(int i=0 ; i<asd.size();i++) {
	         result.put("join_list"+i, asd.get(i));
	         }
	           return result;
	      }
	      
	      
	      @RequestMapping("/appsgjoin_yes")//?????? ?????????
	      @ResponseBody
	      public void androidTestWithRequestAndResponse17(HttpServletRequest request, Model model){
	         String str="";
	         model.addAttribute("request", request);
	          
	         System.out.println("???????????? ?????? ????????????");   
	         command = new Appsgjoin_yesCommand();      
	         command.execute(model);   
	      }
	      
	      
	      @RequestMapping("/appsgjoin_no")//????????????
	      @ResponseBody
	      public void androidTestWithRequestAndResponse18(HttpServletRequest request, Model model){
	         String str="";
	         model.addAttribute("request", request);;
	          
	         System.out.println("???????????? ?????? ????????????");   
	         command = new Appsgjoin_noCommand();         
	         command.execute(model);   

	      }
	      
	       //????????? ????????????
	         @RequestMapping("/app_join_sgroup_list")
	         @ResponseBody
	         public Map<String,Object > androidTestWithRequestAndResponse24(Model model){
	             Map<String, Object> result = new HashMap<String, Object>();
	             Map<String, Object> map = model.asMap();
	        
	            command = new Appjoin_sg_listCommand();
	            
	            command.execute(model);   
	        
	            ArrayList asd=(ArrayList)map.get("join_sg_list");
	           
	            for(int i=0 ; i<asd.size();i++) {
	            result.put("join_sg_list"+i, asd.get(i));
	            }
	              return result;
	      }
	         
	         //????????? ???????????? ??????
	         @RequestMapping("/app_sg_active")
	         @ResponseBody
	         public Map<String,Object > androidTestWithRequestAndResponse25(Model model){
	             Map<String, Object> result = new HashMap<String, Object>();
	             Map<String, Object> map = model.asMap();
	        
	            command = new Appsg_activeCommand();
	            
	            command.execute(model);   
	        
	            ArrayList asd=(ArrayList)map.get("list");
	           
	            for(int i=0 ; i<asd.size();i++) {
	            result.put("list"+i, asd.get(i));
	            }
	              return result;
	      }
	         
	         //?????????????????????
	         @RequestMapping("/appsg_member_list")
	         @ResponseBody
	         public Map<String,Object > androidTestWithRequestAndResponse26(Model model){
	             Map<String, Object> result = new HashMap<String, Object>();
	             Map<String, Object> map = model.asMap();
	        
	            command = new Appsg_member_listCommand();
	            
	            command.execute(model);   
	        
	            ArrayList asd=(ArrayList)map.get("sg_member");
	           
	            for(int i=0 ; i<asd.size();i++) {
	            result.put("sg_member"+i, asd.get(i));
	            }
	              return result;
	      }
	//////////////////////////////////////////////////////////////////////////////////////////////
	      
	      //??????????????????
	         @RequestMapping("/appe_list")
	         @ResponseBody
	         public Map<String,Object > androidTestWithRequestAndResponse19(Model model){
	             Map<String, Object> result = new HashMap<String, Object>();
	             Map<String, Object> map = model.asMap();
	        
	            command = new AppEBListCommand();
	            
	            command.execute(model);   
	        
	            ArrayList asd=(ArrayList)map.get("list");
	           
	            for(int i=0 ; i<asd.size();i++) {
	            result.put("list"+i, asd.get(i));
	            }
	              return result;
	      }

		   
		   
		   
		   
		   
		
}
