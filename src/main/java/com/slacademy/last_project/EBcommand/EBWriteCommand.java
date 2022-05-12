package com.slacademy.last_project.EBcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.slacademy.last_project.UBDao.BDao;
import com.slacademy.last_project.UBDto.BDto;

import mountain.mania.com_command.MCommand;

public class EBWriteCommand implements MCommand {

	@Override
	public void execute(Model model) {
		 Map<String ,Object> map=model.asMap();
	      HttpServletRequest request= (HttpServletRequest)map.get("request");
	      BDao boarddao=new BDao();
	      BDto boarddata=new BDto();
	     
	         
	      String realFolder="";
	      String saveFolder="img";
	         
	     int fileSize=5*1024*1024;
	     
	     realFolder=request.getRealPath(saveFolder);
	     
	     boolean result=false;
	         
	     try{
	        request.setCharacterEncoding("UTF-8");
	        MultipartRequest multi=null;
	        
	        multi=new MultipartRequest(request,
	              realFolder,
	              fileSize,
	              "UTF-8",
	              new DefaultFileRenamePolicy());
	        
	        boarddata.setU_id(multi.getParameter("u_id"));
	        boarddata.setB_pw(multi.getParameter("b_pw"));
	        boarddata.setB_title(multi.getParameter("b_title"));
	        boarddata.setB_content(multi.getParameter("b_content"));
	        boarddata.setB_img(
	              multi.getFilesystemName((String)multi.getFileNames().nextElement()));
	        
	       boarddao.EboardInsert(boarddata);
	        
	        if(result==false){
	           System.out.println("게시판 등록 실패");
	           return;
	        }
	        System.out.println("게시판 등록 성공");
	        
	    }catch(Exception ex){
	        ex.printStackTrace();
	        
	     }

	}

}
