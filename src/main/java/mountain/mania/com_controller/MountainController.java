package mountain.mania.com_controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.jsoup.Jsoup;

import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slacademy.last_project.EBcommand.EBContentCommand;
import com.slacademy.last_project.EBcommand.EBDeleteCommand;
import com.slacademy.last_project.EBcommand.EBListCommand;
import com.slacademy.last_project.EBcommand.EBModifyCommand;
import com.slacademy.last_project.EBcommand.EBModifyViewCommand;
import com.slacademy.last_project.EBcommand.EBWriteCommand;
import com.slacademy.last_project.EBcommand.search_eboard;
import com.slacademy.last_project.Gcommand.BigGroupListCommand;
import com.slacademy.last_project.Gcommand.BigGroup_contentCommand;
import com.slacademy.last_project.Gcommand.BigGroup_joinCommand;
import com.slacademy.last_project.Gcommand.BigGroup_joinListCommand;
import com.slacademy.last_project.Gcommand.BigGroupaddCommand;
import com.slacademy.last_project.Gcommand.Create_bg_check_Command;
import com.slacademy.last_project.Gcommand.bg_Schedule_Command;
import com.slacademy.last_project.Gcommand.bg_Schedule_checkCommand;
import com.slacademy.last_project.Gcommand.bg_Schedule_saveCommand;
import com.slacademy.last_project.Gcommand.bg_Schedule_write1_Command;
import com.slacademy.last_project.Gcommand.bg_Schedule_write_view1;
import com.slacademy.last_project.Gcommand.bg_activeCommand;
import com.slacademy.last_project.Gcommand.bg_active_saveCommand;
import com.slacademy.last_project.Gcommand.bg_joinlist_giCommand;
import com.slacademy.last_project.Gcommand.bg_member_list;
import com.slacademy.last_project.Gcommand.bg_member_out_Command;
import com.slacademy.last_project.Gcommand.bg_rank;
import com.slacademy.last_project.Gcommand.bg_schedule_delete_Command;
import com.slacademy.last_project.Gcommand.bg_schedule_modifyCommand;
import com.slacademy.last_project.Gcommand.bg_schedule_modifyaction_Command;
import com.slacademy.last_project.Gcommand.delete_bg_group;
import com.slacademy.last_project.Gcommand.join_bg_listcommand;
import com.slacademy.last_project.Gcommand.mypage_command;
import com.slacademy.last_project.Gcommand.nocommand;
import com.slacademy.last_project.Gcommand.search_Command;
import com.slacademy.last_project.Gcommand.yescommand;
import com.slacademy.last_project.Mcommand.Mountain_map;
import com.slacademy.last_project.NBcommand.NBContentCommand;
import com.slacademy.last_project.NBcommand.NBDeleteCommand;
import com.slacademy.last_project.NBcommand.NBListCommand;
import com.slacademy.last_project.NBcommand.NBModifyCommand;
import com.slacademy.last_project.NBcommand.NBModifyViewCommand;
import com.slacademy.last_project.NBcommand.NBWriteCommand;
import com.slacademy.last_project.NBcommand.search_nboard;
import com.slacademy.last_project.SGcommand.SmallGroupListCommand;
import com.slacademy.last_project.SGcommand.delete_sg_groupCommand;
import com.slacademy.last_project.SGcommand.join_sgroup_listcommand;
import com.slacademy.last_project.SGcommand.sg_Schedule_Command;
import com.slacademy.last_project.SGcommand.sg_Schedule_checkCommand;
import com.slacademy.last_project.SGcommand.sg_Schedule_saveCommand;
import com.slacademy.last_project.SGcommand.sg_Schedule_write1_Command;
import com.slacademy.last_project.SGcommand.sg_Schedule_write_view1;
import com.slacademy.last_project.SGcommand.sg_activeCommand;
import com.slacademy.last_project.SGcommand.sg_active_saveCommand;
import com.slacademy.last_project.SGcommand.sg_joinlist_giCommand;
import com.slacademy.last_project.SGcommand.sg_member_listCommand;
import com.slacademy.last_project.SGcommand.sg_member_out_Command;
import com.slacademy.last_project.SGcommand.sg_nocommand;
import com.slacademy.last_project.SGcommand.sg_schedule_delete_Command;
import com.slacademy.last_project.SGcommand.sg_schedule_modifyCommand;
import com.slacademy.last_project.SGcommand.sg_schedule_modifyaction_Command;
import com.slacademy.last_project.SGcommand.sg_yescommand;
import com.slacademy.last_project.SGcommand.small_group_addCommand;
import com.slacademy.last_project.SGcommand.small_group_contentCommand;
import com.slacademy.last_project.SGcommand.small_group_joinCommand;
import com.slacademy.last_project.SGcommand.small_group_joinlistCommand;
import com.slacademy.last_project.UBcommand.BContentCommand;
import com.slacademy.last_project.UBcommand.BDeleteCommand;
import com.slacademy.last_project.UBcommand.BListCommand;
import com.slacademy.last_project.UBcommand.BModifyCommand;
import com.slacademy.last_project.UBcommand.BModifyViewCommand;
import com.slacademy.last_project.UBcommand.BReplyCommand;
import com.slacademy.last_project.UBcommand.BReplyWriteCommand;
import com.slacademy.last_project.UBcommand.BWriteCommand;
import com.slacademy.last_project.UBcommand.search_uboard;

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
		command.execute(model);	
		return "test";
	}
	@RequestMapping("/test2")
	public String test2() {
		System.out.println("test2");

		return "test2";
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
		System.out.println("mypage");
		model.addAttribute("request", request);
		System.out.println(model);
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

	//동호회리스트 모두 볼때
	@RequestMapping("/big_group_list")
	public String GroupList(Model model,HttpServletRequest request ) {
		System.out.println("동호회 리스트 컨트롤러");	
		model.addAttribute("request", request);
		command = new BigGroupListCommand();
		command.execute(model);	
		return "Group/big_group_list";
	}

	//상위랭킹 30개
	@RequestMapping("/bg_rank30")
	public String bg_rank30(Model model,HttpServletRequest request) {
		System.out.println("bg_rank30 컨트롤러");	
		model.addAttribute("request", request);
		command = new bg_rank();
		command.execute(model);	
		return "Group/bg_rank30";
	}

	@RequestMapping("/group_recruit")
	public String Group_recruit() {	
		System.out.println("모집글 페이지 컨트롤러");
		return "Group/group_recruit";
	}

	@RequestMapping("/Create_big_group")
	public String Create_Group(HttpServletRequest request, Model model) {
		System.out.println("동호회 만들기 페이지 컨트롤러");
		model.addAttribute("request", request);
		command = new Create_bg_check_Command();
		command.execute(model);
		return "Group/Create_big_group";
	}

	@RequestMapping("/big_group_addCommand") //아이디 세션값은 어떻게 할것인가 
	public String Groupadd(HttpServletRequest request, Model model ) {
		System.out.println("동호회추가 컨트롤러 big_group_addCommand");	
		model.addAttribute("request", request);
		command = new BigGroupaddCommand();
		command.execute(model);

		return "redirect:big_group_list";
	}

	@RequestMapping("/big_group_content")
	public String Group_content(HttpServletRequest request, Model model ) {
		System.out.println("동호회 상세정보 big_group_content컨트롤러");	
		model.addAttribute("request", request);
		command=new BigGroup_contentCommand();
		command.execute(model);

		return "Group/big_group_content";
	}

	@RequestMapping("/big_group_join")
	public String BigGroup_join(HttpServletRequest request, Model model ) {
		System.out.println("동호회 가입  big_group_join 컨트롤러");	
		model.addAttribute("request", request);
		command=new BigGroup_joinCommand();
		command.execute(model);

		return "redirect:big_group_list";
	}
	//좌측 메뉴에서 내가 신청한 동호회가입신청내역 눌렀을때
	@RequestMapping("/big_group_joinlist")
	public String big_group_joinlist(HttpServletRequest request, Model model ) {
		System.out.println("내 가입신청내역 big_group_joinlist컨트롤러 ");	
		model.addAttribute("request", request);
		command=new BigGroup_joinListCommand();
		command.execute(model);

		return "Group/big_group_join";
	}

	//동호회장이 가입신청서 확인하기를 눌렀을때
	@RequestMapping("/bg_joinlist_gi")
	public String bg_joinlist_gi(HttpServletRequest request, Model model ) {
		System.out.println("동호회장 가입신청내역 bg_joinlist_gi컨트롤러");	
		model.addAttribute("request", request);
		command=new bg_joinlist_giCommand();
		command.execute(model);

		return "Group/bg_joinlist_gi";
	}

	//동호회장이 승인 눌렀을때
	@RequestMapping("/yes")
	public String yes(HttpServletRequest request, Model model ) {
		System.out.println("동호회장이 Y 눌렀을때 yes컨트롤러");	
		model.addAttribute("request", request);
		command=new yescommand();
		command.execute(model);

		return "redirect:big_group_list";
	}

	//동호회장이 거절 눌렀을때
	@RequestMapping("/no")
	public String no(HttpServletRequest request, Model model ) {
		System.out.println("동호회장이 N 눌렀을때 no컨트롤러");	
		model.addAttribute("request", request);
		command=new nocommand();
		command.execute(model);

		return "redirect:big_group_list";
	}


	//유저가 가입한 모임 보기 클릭시
	@RequestMapping("/join_bgroup_list")
	public String join_bgroup_list(HttpServletRequest request, Model model ) {
		System.out.println("가입한 모임 보기 oin_bgroup_list 컨트롤러");	
		model.addAttribute("request", request);
		command=new join_bg_listcommand();
		command.execute(model);

		return "Group/join_bgroup_list";
	}


	//모든 동호회 랭킹확인
	@RequestMapping("/bg_rank")
	public String bg_rank(HttpServletRequest request, Model model ) {
		System.out.println("동호회랭크보기 컨트롤러");	
		model.addAttribute("request", request);
		command=new bg_rank();
		command.execute(model);

		return "Group/bg_rank";
	}

	//내 동호회 멤버 리스트
	@RequestMapping("/bg_member_list ")
	public String bg_member_list (HttpServletRequest request, Model model ) {
		System.out.println("동호회랭크보기 컨트롤러");	
		model.addAttribute("request", request);
		command=new bg_member_list();
		command.execute(model);

		return "Group/bg_member_list";
	}


	//동호회탈퇴하기
	@RequestMapping("/delete_bg_group")
	public String delete_bg_group(HttpServletRequest request, Model model ) {
		System.out.println("동호회랭크보기 컨트롤러");	
		model.addAttribute("request", request);
		command=new delete_bg_group();
		command.execute(model);

		return "redirect:join_bgroup_list";
	}

	//일정메뉴 클릭시 
	@RequestMapping("/bg_Schedule")
	public String bg_Schedule(HttpServletRequest request, Model model ) {
		System.out.println("bg_Schedule 컨트롤러");	
		model.addAttribute("request", request);
		command=new bg_Schedule_Command();
		command.execute(model);

		return "Group/bg_Schedule";
	}


	//동호회장이 일정폼 날짜를 눌렀을때<동호회장만 가능>
	@RequestMapping("/bg_Schedule_write_view1")
	public String bg_Schedule_write_view1(HttpServletRequest request, Model model ) {
		System.out.println("bg_Schedule_write_view1 컨트롤러");
		model.addAttribute("request", request);
		command=new bg_Schedule_write_view1();
		command.execute(model);
		return "Group/bg_Schedule_write_view1";
	}

	//산이름 고르고난 뒤
	@RequestMapping("/bg_Schedule_write1")
	public String bg_Schedule_write(HttpServletRequest request, Model model ) {
		System.out.println("bg_Schedule_write1 컨트롤러");	
		model.addAttribute("request", request);
		command=new bg_Schedule_write1_Command();
		command.execute(model);

		return "Group/bg_Schedule_write_view1";
	}

	//일정 폼 작성 후 일정 등록하기 클릭시
	@RequestMapping("/bg_Schedule_save")
	public String bg_Schedule_save(HttpServletRequest request, Model model ) {
		System.out.println(" 컨트롤러");	
		model.addAttribute("request", request);
		command=new  bg_Schedule_saveCommand();
		command.execute(model);

		return "redirect:bg_Schedule";
	}

	//일정 폼에서 타이틀 눌렀을때
	@RequestMapping("/bg_Schedule_check")
	public String bg_Schedule_check(HttpServletRequest request, Model model ) {
		System.out.println(" 컨트롤러");	
		model.addAttribute("request", request);
		command=new  bg_Schedule_checkCommand();
		command.execute(model);

		return "Group/bg_Schedule_check";
	}


	//일정 수정하기 클릭시 <동호회장만 보이기>
	@RequestMapping("/bg_schedule_modify")
	public String bg_schedule_modify(HttpServletRequest request, Model model ) {
		System.out.println(" bg_schedule_modify컨트롤러");	
		model.addAttribute("request", request);
		command=new  bg_schedule_modifyCommand();
		command.execute(model);

		return "Group/bg_schedule_modify_view";
	}

	//일정 수정완료 클릭시 업데이트<동호회장만 보이기>
	@RequestMapping("/bg_schedule_modifyaction")
	public String bg_schedule_modifyaction(HttpServletRequest request, Model model ) {
		System.out.println(" bg_schedule_modifyaction컨트롤러");	
		model.addAttribute("request", request);
		command=new  bg_schedule_modifyaction_Command();
		command.execute(model);

		return "redirect:bg_Schedule";
	}

	//일정 삭제하기 눌렀을 때<동호회장만 보이기>
	@RequestMapping("/bg_schedule_delete")
	public String bg_schedule_delete(HttpServletRequest request, Model model ) {
		System.out.println(" bg_schedule_modifyaction컨트롤러");	
		model.addAttribute("request", request);
		command=new bg_schedule_delete_Command();
		command.execute(model);

		return "redirect:bg_Schedule";
	}

	//멤버강퇴
	@RequestMapping("/bg_member_out")
	public String bg_member_out(HttpServletRequest request, Model model ) {
		System.out.println(" bg_member_out컨트롤러");	
		model.addAttribute("request", request);
		command=new bg_member_out_Command();
		command.execute(model);

		return "redirect:big_group_list";
	}


	//랭킹 더보기 - 서치
	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model ) {
		System.out.println(" search컨트롤러");	
		model.addAttribute("request", request);
		command=new search_Command();
		command.execute(model);

		return "Group/search";
	}


	///////////////////////////////////////////여기부턴 소모임////////////////////////


	@RequestMapping("/Create_small_group")
	public String Create_small_group() {	
		return "SGroup/Create_small_group";
	}
	//동호회리스트 모두 볼때
	@RequestMapping("/small_group_list")
	public String SmallGroupList(Model model) {
		System.out.println("모임 리스트 컨트롤러");	
		command = new SmallGroupListCommand();
		command.execute(model);	
		return "SGroup/small_group_list";
	}
	//
	@RequestMapping("/small_group_addCommand") //아이디 세션값은 어떻게 할것인가 
	public String small_group_add(HttpServletRequest request, Model model ) {
		System.out.println("모임추가 컨트롤러 small_group_add 컨트롤러");	
		model.addAttribute("request", request);
		command = new small_group_addCommand();
		command.execute(model);

		return "redirect:small_group_list";
	}
	//모임 이름 클릭시 상세보기
	@RequestMapping("/small_group_content")
	public String small_group_content(HttpServletRequest request, Model model ) {
		System.out.println("모임 상세정보 small_group_content컨트롤러");	
		model.addAttribute("request", request);
		command=new small_group_contentCommand();
		command.execute(model);

		return "SGroup/small_group_content";
	}
	//모임 가입하기 
	@RequestMapping("/small_group_join")
	public String small_group_join(HttpServletRequest request, Model model ) {
		System.out.println("모임 가입  big_group_join 컨트롤러");	
		model.addAttribute("request", request);
		command=new small_group_joinCommand();
		command.execute(model);

		return "redirect:small_group_list";
	}

	//좌측 메뉴에서 내가 신청한 모임가입신청내역 눌렀을때
	@RequestMapping("/small_group_joinlist")
	public String small_group_joinlist(HttpServletRequest request, Model model ) {
		System.out.println("내 가입신청내역 small_group_joinlist컨트롤러 ");	
		model.addAttribute("request", request);
		command=new small_group_joinlistCommand();
		command.execute(model);

		return "SGroup/small_group_join";
	}

	//모임장이 가입신청서 확인하기를 눌렀을때
	@RequestMapping("/sg_joinlist_gi")
	public String sg_joinlist_gi(HttpServletRequest request, Model model ) {
		System.out.println("모임장 가입신청내역 sg_joinlist_gi컨트롤러");	
		model.addAttribute("request", request);
		command=new sg_joinlist_giCommand();
		command.execute(model);

		return "SGroup/sg_joinlist_gi";
	}

	//모임장이 승인 눌렀을때
	@RequestMapping("/sg_yes")
	public String sg_yes(HttpServletRequest request, Model model ) {
		System.out.println("동호회장이 Y 눌렀을때 yes컨트롤러");	
		model.addAttribute("request", request);
		command=new sg_yescommand();
		command.execute(model);

		return "redirect:small_group_list";
	}

	//모임장이 거절 눌렀을때
	@RequestMapping("/sg_no")
	public String sg_no(HttpServletRequest request, Model model ) {
		System.out.println("동호회장이 Y 눌렀을때 yes컨트롤러");	
		model.addAttribute("request", request);
		command=new sg_nocommand();
		command.execute(model);

		return "redirect:small_group_list";
	}
	//유저가 가입한 모임 보기 클릭시
	@RequestMapping("/join_sgroup_list")
	public String join_sgroup_list(HttpServletRequest request, Model model ) {
		System.out.println("가입한 모임 보기 oin_bgroup_list 컨트롤러");	
		model.addAttribute("request", request);
		command=new join_sgroup_listcommand();
		command.execute(model);

		return "SGroup/join_sgroup_list";
	}
	//모임탈퇴하기
	@RequestMapping("/delete_sg_group")
	public String delete_sg_group(HttpServletRequest request, Model model ) {
		System.out.println("동호회랭크보기 컨트롤러");	
		model.addAttribute("request", request);
		command=new delete_sg_groupCommand();
		command.execute(model);

		return "redirect:join_sgroup_list";
	}

	//내 모임 멤버 리스트
	@RequestMapping("/sg_member_list ")
	public String sg_member_list (HttpServletRequest request, Model model ) {
		System.out.println("동호회랭크보기 컨트롤러");	
		model.addAttribute("request", request);
		command=new sg_member_listCommand();
		command.execute(model);

		return "SGroup/sg_member_list";
	}
	//일정메뉴 클릭시 
	@RequestMapping("/sg_Schedule")
	public String sg_Schedule(HttpServletRequest request, Model model ) {
		System.out.println("sg_Schedule 컨트롤러");	
		model.addAttribute("request", request);
		command=new sg_Schedule_Command();
		command.execute(model);

		return "SGroup/sg_Schedule";
	}

	//모임장이 일정폼 날짜를 눌렀을때<모임장만 가능>
	@RequestMapping("/sg_Schedule_write_view1")
	public String sg_Schedule_write_view1(HttpServletRequest request, Model model ) {
		System.out.println("sg_Schedule_write_view1 컨트롤러");
		model.addAttribute("request", request);
		command=new sg_Schedule_write_view1();
		command.execute(model);
		return "SGroup/sg_Schedule_write_view1";
	}

	//산이름 고르고난 뒤
	@RequestMapping("/sg_Schedule_write1")
	public String sg_Schedule_write(HttpServletRequest request, Model model ) {
		System.out.println("sg_Schedule_write1 컨트롤러");	
		model.addAttribute("request", request);
		command=new sg_Schedule_write1_Command();
		command.execute(model);

		return "SGroup/sg_Schedule_write_view1";
	}
	//일정 폼 작성 후 일정 등록하기 클릭시
	@RequestMapping("/sg_Schedule_save")
	public String sg_Schedule_save(HttpServletRequest request, Model model ) {
		System.out.println(" sg_Schedule_save 컨트롤러");	
		model.addAttribute("request", request);
		command=new sg_Schedule_saveCommand();
		command.execute(model);

		return "redirect:sg_Schedule";
	}
	//일정 폼에서 타이틀 눌렀을때
	@RequestMapping("/sg_Schedule_check")
	public String sg_Schedule_check(HttpServletRequest request, Model model ) {
		System.out.println(" sg_Schedule_check 컨트롤러");	
		model.addAttribute("request", request);
		command=new  sg_Schedule_checkCommand();
		command.execute(model);

		return "SGroup/sg_Schedule_check";
	}

	//일정 수정하기 클릭시 <모임장만 보이기>
	@RequestMapping("/sg_schedule_modify")
	public String sg_schedule_modify(HttpServletRequest request, Model model ) {
		System.out.println(" sg_schedule_modify컨트롤러");	
		model.addAttribute("request", request);
		command=new  sg_schedule_modifyCommand();
		command.execute(model);

		return "SGroup/sg_schedule_modify_view";
	}

	//일정 수정완료 클릭시 업데이트<모임장만 보이기>
	@RequestMapping("/sg_schedule_modifyaction")
	public String sg_schedule_modifyaction(HttpServletRequest request, Model model ) {
		System.out.println(" sg_schedule_modifyaction컨트롤러");	
		model.addAttribute("request", request);
		command=new  sg_schedule_modifyaction_Command();
		command.execute(model);

		return "redirect:sg_Schedule";
	}

	//일정 삭제하기 눌렀을 때<동호회장만 보이기>
	@RequestMapping("/sg_schedule_delete")
	public String sg_schedule_delete(HttpServletRequest request, Model model ) {
		System.out.println(" sg_schedule_modifyaction컨트롤러");	
		model.addAttribute("request", request);
		command=new sg_schedule_delete_Command();
		command.execute(model);

		return "redirect:sg_Schedule";
	}


	//멤버강퇴
	@RequestMapping("/sg_member_out")
	public String sg_member_out(HttpServletRequest request, Model model ) {
		System.out.println(" sg_member_out컨트롤러");	
		model.addAttribute("request", request);
		command=new sg_member_out_Command();
		command.execute(model);

		return "redirect:small_group_list";
	}

	///////////////////////유저게시판////////////////////////////////////////////	
	@RequestMapping("/list")//url매핑
	public String list(HttpServletRequest request,Model model) {
		System.out.println("list()");
		model.addAttribute("request",request);	
		command = new BListCommand();
		command.execute(model); // 동적바인딩
		System.out.println("test5");
		return "user_board/list";
	}

	@RequestMapping("/write")
	public String write( HttpServletRequest request, Model model) {
		System.out.println("write()");	
		model.addAttribute("request",request);		
		command = new BWriteCommand();
		command.execute(model);
		return "redirect:list";//컨트롤에 되어있는 list로 맵핑된 곳으로 찾아가라 
	}
	@RequestMapping("/write_view")
	public String write_view() {
		return "user_board/write_view";
	}

	@RequestMapping("/content_view")//상세페이지
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");

		model.addAttribute("request",request);

		command = new BContentCommand();
		command.execute(model);

		return "user_board/content_view";
	}
	@RequestMapping("/delete")
	public String delete() {
		return "user_board/content_delete";//현재 이 url을 유지하면서 뷰페이지만 보여줘라
	}

	@RequestMapping("/bDeleteAction")
	public String bDeleteAction(HttpServletRequest request, Model model) {
		System.out.println("bDelteAction");

		model.addAttribute("request",request);
		command = new BDeleteCommand();
		command.execute(model);

		return "redirect:list";//url까지 바꾸면서 list뷰로 가라
	}

	@RequestMapping("/modify")
	public String bModify(HttpServletRequest request, Model model) {
		System.out.println("bmodify");
		model.addAttribute("request",request);
		command = new BModifyViewCommand();
		command.execute(model);
		return "user_board/modifyForm";
	}

	@RequestMapping("/modifyAction")
	public String bModifyAction(HttpServletRequest request, Model model) {
		System.out.println("bmodifyAct");

		model.addAttribute("request",request);
		command = new BModifyCommand();
		command.execute(model);
		return "redirect:list";

	}

	@RequestMapping("/reply_view")
	public String breply(HttpServletRequest request, Model model) {
		System.out.println("rere");
		model.addAttribute("request",request);
		command = new BReplyWriteCommand();
		command.execute(model);
		return "user_board/reply_view";
	}

	@RequestMapping("/ReplyAction")
	public String bReplyAction(HttpServletRequest request, Model model) {
		System.out.println("breply");
		model.addAttribute("request",request);
		command = new BReplyCommand();
		command.execute(model);
		return "redirect:list";

	}

	@RequestMapping("/search_uboard")
	public String serch_uboard(HttpServletRequest request, Model model) {
		System.out.println("search_uboard");
		model.addAttribute("request",request);
		command = new search_uboard();
		command.execute(model);
		return "user_board/search";

	}

	//지도
	@RequestMapping("/mountain_map")
	public String Mountain_map(Model model ) {
		command = new Mountain_map();
		command.execute(model);	
		return "redirect:test";
	}

	@RequestMapping("/map")
	public String map(HttpServletRequest request,Model model ) {
		//		System.out.println(" map 컨트롤러");	
		String m_name=request.getParameter("m_name");
		model.addAttribute("m_name",m_name);
		//		model.addAttribute("request", request);
		//		System.out.println(model);
		command.execute(model);	
		return "MountainMap/map";
	}



	///////////////////////////////이벤트게시판////////////////////////////////////////////////////

	@RequestMapping("/e_list")//url매핑
	public String e_list(HttpServletRequest request,Model model) {
		System.out.println("e_list()컨트롤러");
		model.addAttribute("request",request);	
		command = new EBListCommand();
		command.execute(model); // 동적바인딩
		return "event_board/list";
	}

	@RequestMapping("/e_write_view")
	public String e_write_view(HttpServletRequest request, Model model) {

		return "event_board/write_view";
	}

	@RequestMapping("/e_write")
	public String e_write( HttpServletRequest request, Model model) {
		System.out.println("e_write()");	
		model.addAttribute("request",request);		
		command = new EBWriteCommand();
		command.execute(model);
		return "redirect:e_list";//컨트롤에 되어있는 list로 맵핑된 곳으로 찾아가라 
	}


	@RequestMapping("/e_content_view")//상세페이지
	public String e_content_view(HttpServletRequest request, Model model) {
		System.out.println("e_content_view()");

		model.addAttribute("request",request);

		command = new EBContentCommand();
		command.execute(model);

		return "event_board/content_view";
	}

	@RequestMapping("/e_delete")
	public String e_delete() {
		return "event_board/content_delete";//현재 이 url을 유지하면서 뷰페이지만 보여줘라
	}

	@RequestMapping("/e_bDeleteAction")
	public String e_bDeleteAction(HttpServletRequest request, Model model) {
		System.out.println("e_bDelteAction");

		model.addAttribute("request",request);
		command = new EBDeleteCommand();
		command.execute(model);

		return "redirect:e_list";//url까지 바꾸면서 list뷰로 가라
	}

	@RequestMapping("/e_modify")
	public String e_bModify(HttpServletRequest request, Model model) {
		System.out.println("e_bmodify");
		model.addAttribute("request",request);
		command = new EBModifyViewCommand();
		command.execute(model);
		return "event_board/modifyForm";
	}

	@RequestMapping("/e_modifyAction")
	public String e_bModifyAction(HttpServletRequest request, Model model) {
		System.out.println("bmodifyAct");

		model.addAttribute("request",request);
		command = new EBModifyCommand();
		command.execute(model);
		return "redirect:e_list";

	}

	@RequestMapping("/search_eboard")
	public String serch_eboard(HttpServletRequest request, Model model) {
		System.out.println("search_eboard");
		model.addAttribute("request",request);
		command = new search_eboard();
		command.execute(model);
		return "event_board/search";

	}

	///////////////////////////////공지게시판////////////////////////////////////////////////////

	@RequestMapping("/n_list")//url매핑
	public String n_list(HttpServletRequest request,Model model) {
		System.out.println("n_list()컨트롤러");
		model.addAttribute("request",request);	
		command = new NBListCommand();
		command.execute(model); // 동적바인딩
		return "notice_board/list";
	}

	@RequestMapping("/n_write_view")
	public String n_write_view(HttpServletRequest request, Model model) {

		return "notice_board/write_view";
	}

	@RequestMapping("/n_write")
	public String n_write( HttpServletRequest request, Model model) {
		System.out.println("n_write()");	
		model.addAttribute("request",request);		
		command = new NBWriteCommand();
		command.execute(model);
		return "redirect:n_list";//컨트롤에 되어있는 list로 맵핑된 곳으로 찾아가라 
	}


	@RequestMapping("/n_content_view")//상세페이지
	public String n_content_view(HttpServletRequest request, Model model) {
		System.out.println("n_content_view()");

		model.addAttribute("request",request);

		command = new NBContentCommand();
		command.execute(model);

		return "notice_board/content_view";
	}

	@RequestMapping("/n_delete")
	public String n_delete() {
		return "notice_board/content_delete";//현재 이 url을 유지하면서 뷰페이지만 보여줘라
	}

	@RequestMapping("/n_bDeleteAction")
	public String n_bDeleteAction(HttpServletRequest request, Model model) {
		System.out.println("n_bDelteAction");

		model.addAttribute("request",request);
		command = new NBDeleteCommand();
		command.execute(model);

		return "redirect:n_list";//url까지 바꾸면서 list뷰로 가라
	}

	@RequestMapping("/n_modify")
	public String n_bModify(HttpServletRequest request, Model model) {
		System.out.println("n_bmodify");
		model.addAttribute("request",request);
		command = new NBModifyViewCommand();
		command.execute(model);
		return "notice_board/modifyForm";
	}

	@RequestMapping("/n_modifyAction")
	public String n_bModifyAction(HttpServletRequest request, Model model) {
		System.out.println("n_modifyAction");

		model.addAttribute("request",request);
		command = new NBModifyCommand();
		command.execute(model);
		return "redirect:n_list";

	}
	@RequestMapping("/search_nboard")
	public String serch_nboard(HttpServletRequest request, Model model) {
		System.out.println("search_nboard");
		model.addAttribute("request",request);
		command = new search_nboard();
		command.execute(model);
		return "notice_board/search";

	}

	//////////////////////////////////////////동호회활동/////////////////////////////////////////

	@RequestMapping("/bg_active")//활동내역 보기-> u_id 필요
	public String bg_active(HttpServletRequest request, Model model) {
		System.out.println("bg_active 컨트롤러");
		model.addAttribute("request",request);
		command = new bg_activeCommand();
		command.execute(model);
		return "Group/bg_active";
	}	

	@RequestMapping("/bg_active_form")
	public String bg_active_form() {
		System.out.println("bg_active_form 컨트롤러");
		return "Group/bg_active_form";
	}	

	@RequestMapping("/bg_active_save")
	public String bg_active_save(HttpServletRequest request, Model model) {
		System.out.println("bg_active_save 컨트롤러");
		model.addAttribute("request",request);
		command = new bg_active_saveCommand();
		command.execute(model);
		return "redirect:bg_active";
	}	

	//////////////////////////////////////////소모임활동/////////////////////////////////////////	

	@RequestMapping("/sg_active") //활동내역 보기-> u_id 필요
	public String sg_active(HttpServletRequest request, Model model) {
		System.out.println("sg_active 컨트롤러");
		model.addAttribute("request",request);
		command = new sg_activeCommand();
		command.execute(model);
		return "SGroup/sg_active";
	}	


	@RequestMapping("/sg_active_form")
	public String sg_active_form() {
		System.out.println("sg_active_form 컨트롤러");
		return "SGroup/sg_active_form";
	}	


	@RequestMapping("/sg_active_save")
	public String sg_active_save(HttpServletRequest request, Model model) {
		System.out.println("sg_active_save 컨트롤러");
		model.addAttribute("request",request);
		command = new sg_active_saveCommand();
		command.execute(model);
		return "redirect:sg_active";
	}	






}
