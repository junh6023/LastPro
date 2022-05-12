package mountain.mania.com_command;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mountain.mania.com_DAO.MDao;
import mountain.mania.com_DTO.IDto;

public class ItemsAdd implements MCommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		MDao mdao=new MDao();
	   	IDto idto=new IDto();
	  
	   	
		String realFolder="";
   		String saveFolder="mimg";
   		
   		int fileSize=5*1024*1024;
   		String filename1="";
   		
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
   			filename1 = multi.getFilesystemName("img");
   	      
   		
   			
   			idto.setItems_name(multi.getParameter("items_name"));
   			idto.setSite(multi.getParameter("site"));
   			idto.setImg(filename1);
   	
   			System.out.println("1파일 : "+filename1);
   			
   		
	   		mdao.ItemInsert(idto);
	   		
	   		
	   		
	   		
  		}catch(Exception ex){
   			ex.printStackTrace();
   		}
   		
  		
	}  	
	
}
