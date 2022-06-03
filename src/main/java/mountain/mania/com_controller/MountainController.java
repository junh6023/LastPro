package mountain.mania.com_controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;

import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.slacademy.last_project.Gcommand.mypage_command;
import com.slacademy.last_project.Mcommand.Mountain_map;
import com.slacademy.last_project.SGcommand.SmallGroupListCommand;

import mountain.mania.com_DTO.MDto;
import mountain.mania.com_command.*;
import mountain.mania.com_util.Constant;




@Controller
public class MountainController {
	MCommand command = null;
	private JdbcTemplate template;

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
		System.out.println("start");
	}
	//test2222

	@RequestMapping("/test")
	public String test(Model model,HttpServletRequest request) {
		System.out.println("test");
		command = new Mountain_map();
		//command = new BigGroupListCommand6();
		//command = new SmallGroupListCommand6();
		
		command.execute(model);	
		
		return "test";
	}
	@RequestMapping(value="logout", method=RequestMethod.GET)
    public String logoutMainGET(HttpServletRequest request) throws Exception{
       
        
        HttpSession session = request.getSession();
        
        session.invalidate();
        
        return "redirect:test";        
        
    }
	@RequestMapping("/mname_form")
	public String mname_form() {
		System.out.println("mname_form");

		return "mountain/mname_form";
	}
	@RequestMapping("/loginform")
	public String loginform() {
		System.out.println("loginform");

		return "loginform";
	}
	@RequestMapping("/mypage")
	public String mypage(HttpServletRequest request,Model model) {
		System.out.println("controller: mypage");
		model.addAttribute("request", request);
		
		command = new mypage_command();
		command.execute(model);	
		return "mypage";
	}

	@RequestMapping("/mountaininfo")
	public String mountaininfo(HttpServletRequest request,Model model) throws IOException {

		System.out.println("맵핑 : mountaininfo");
		model.addAttribute("request", request);
		String WeatherURL = "https://weather.naver.com/today"; 
		org.jsoup.nodes.Document doc = Jsoup.connect(WeatherURL).get(); 
		//HTML로 부터 데이터 가져오기 
		Elements elem = doc.select(".weather_area .summary .weather");
		//원하는 태그 선택 
		//String[] str = elem.text().split(" ");
		//정보 파싱 
		model.addAttribute("weather", elem);
		System.out.println(elem);
		
		command = new RecommendView();
		command.execute(model);
		return "mountaininfo";
	}

	@RequestMapping("/admin")
	public String Admin() {
		System.out.println("admin");
		return "adminlogin";
	}
	@RequestMapping("/adminlogin")
	public String AdminLogin(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		command = new AdminLogin();
		command.execute(model);
		return "adminform";
	}
	@RequestMapping("/weather")
	public String Weather(HttpServletRequest request,Model model) throws IOException {

		command = new MSearchAll();
		command.execute(model);
		return "weather";
	}

	@RequestMapping("/search_weather")
	public String search_weather(HttpServletRequest request,Model model){
		System.out.println("search_weather");
		model.addAttribute("request", request);
		command = new MSearchOne();
		command.execute(model);

		return "search_weather";
	}


	@RequestMapping(value="minsert_form")
	public String minsert_form(HttpServletRequest request,Model model) throws IOException {
		System.out.println("minsert");

		model.addAttribute("request", request);

		command = new MInsertForm();
		command.execute(model);

		return "minsert_form";
	}

	@RequestMapping("/minsert")
	public String minsert(HttpServletRequest request,Model model) {

		model.addAttribute("request", request);
		command = new MInsert();
		command.execute(model);

		return "adminform";
	}
	@RequestMapping("/items_add")
	public String items_add(HttpServletRequest request,Model model) {

		model.addAttribute("request", request);
		command = new ItemsAdd();
		command.execute(model);

		return "adminform";
	}
	@RequestMapping("/items_addform")
	public String itmes_addform() {
		return "items_addform";

	}
	@RequestMapping("/levelhigh")
	public String levelhigh(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		command = new MLevelHigh();
		command.execute(model);
		model.addAttribute("test", "test");
		return "mlevelhigh";

	}
	@RequestMapping("/itemslist")
	public String itemslist(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		command = new ItemsList();
		command.execute(model);
		return "itemslist";

	}
	@RequestMapping("/mcourse_form")
	public String mcourse_form(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		command = new MList();
		command.execute(model);
		return "mountain/mlist";

	}
	@RequestMapping("/mdelete_form")
	public String mdelete_form(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		command = new MList();
		command.execute(model);
		return "mountain/mdelete_form";

	}
	@RequestMapping("/idelete_form")
	public String idelete_form(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		command = new ilist();
		command.execute(model);
		return "mountain/ilist";

	}
	@RequestMapping("/mdelete")
	public String mdelete(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		command = new MDelete();
		command.execute(model);
		return "adminform";

	}
	@RequestMapping("/idelete")
	public String idelete(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		command = new IDelete();
		command.execute(model);
		return "adminform";

	}
	@RequestMapping("/mcourse_addform")
	public String mcourse_addform() {


		return "mountain/mcourse_addform";

	}
	@RequestMapping("/usercenter")
	public String usercenter() {
		return "usercenter";

	}
	@RequestMapping("/mcourse_add")
	public String mcourse_add(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		command = new MCourseAdd();
		command.execute(model);
		return "redirect:mcourse_form";
	}

	@RequestMapping("/courseview")
	public String courseview(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		command = new MCourseView();
		command.execute(model);
		return "mountain/course_view";
	}
	
	@RequestMapping("/course_detail")
	public String course_detail(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		command = new MCourseDetail();
		command.execute(model);
		return "mountain/course_detail";
	}



}
