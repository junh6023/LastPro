package mountain.mania.com_command;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mountain.mania.com_DAO.MDao;
import mountain.mania.com_DTO.MDto;



public class MInsert implements MCommand{

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		MDao mdao=new MDao();
	   	MDto mdto=new MDto();
	  
	   	
		String realFolder="";
   		String saveFolder="mimg";
   		
   		int fileSize=5*1024*1024;
   		String filename1="";
   		String filename2="";
   		String filename3="";
   		realFolder=request.getRealPath(saveFolder);
   		try{
   			
   			MultipartRequest multi=null;
   			
   			multi=new MultipartRequest(request,
   					realFolder,
   					fileSize,
   					"UTF-8",
   					new DefaultFileRenamePolicy());
   			
   			Enumeration files = multi.getFileNames();
     	      
   			String file1 = (String)files.nextElement();
   			filename1 = multi.getFilesystemName("m_img");
   	      
   			String file2 = (String)files.nextElement();
   			filename2 = multi.getFilesystemName("m_parking");
   			
   			String file3 = (String)files.nextElement();
   			filename3 = multi.getFilesystemName("items_img");
   			
   			mdto.setM_name(multi.getParameter("m_name"));
   			mdto.setM_level(multi.getParameter("m_level"));
   			mdto.setM_img(filename1);
   			mdto.setArea(multi.getParameter("m_area"));
   			mdto.setParking(filename2);
   			mdto.setM_address(multi.getParameter("m_address"));
   			mdto.setItems_name(multi.getParameter("items_name"));
   			mdto.setItems_img(filename3);
   			System.out.println(multi.getParameter("m_name"));
   			System.out.println("1파일 : "+filename1);
   			System.out.println("2파일 : "+filename2);
   			System.out.println("3파일 : "+filename3);
	   		mdao.MountainInsert(mdto);
	   		
	   		
	   		
	   		
  		}catch(Exception ex){
   			ex.printStackTrace();
   		}
   		
  		
	}  	
		
	

}
