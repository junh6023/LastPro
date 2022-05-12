package com.slacademy.last_project.UBcommand;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.ui.Model;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import mountain.mania.com_DAO.MDao;
import mountain.mania.com_command.MCommand;

public class BReplyCommand implements MCommand {

	// tag값의 정보를 가져오는 메소드
	private static String getTagValue(String tag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		if(nValue == null) 
			return null;
		return nValue.getNodeValue();
	}


	@Override
	public void execute(Model model) {		

		MDao dao = new MDao(); //데이터베이스 접속.
		Map<String, Object> map = model.asMap(); //Map
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String b_id = request.getParameter("b_id");
		String b_lev = request.getParameter("b_lev");
		String u_id = request.getParameter("u_id");
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");
		String b_pw = request.getParameter("b_pw");
		System.out.println("reply: test1");
		try {
			// parsing할 url 지정
			String utest = "file:///C:\\test\\test.xml";
			System.out.println("reply:test2");
			StringBuilder urlBuilder = new StringBuilder(utest); /*URL*/
			System.out.println("reply:test3"+urlBuilder.toString());
			URL url = new URL(urlBuilder.toString());
			
			System.out.println("reply:test4");
			InputStream stream = url.openStream();

			DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
			Document doc = dBuilder.parse(stream);

			// root tag 
			doc.getDocumentElement().normalize(); 
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());//xml의 최상위 태그값을 가져온다

			// 파싱할 tag
			NodeList nList = doc.getElementsByTagName("vulgarism");
			System.out.println("파싱할 리스트 수 : "+ nList.getLength());

			String testtest= "";

			List<String> items = new ArrayList<>();
			List<String> array= new ArrayList<>();

			for(int temp = 0; temp < nList.getLength(); temp++){
				Node nNode = nList.item(temp);
				//System.out.println("nNode:"+nNode);
				NodeList item_childlist = nNode.getChildNodes();
				System.out.println("for: test");
				System.out.println("너지? : "+item_childlist.getLength());

				for(int j=0; j<item_childlist.getLength(); j++) {
					Node item_child = item_childlist.item(j);
					if(item_child.getNodeType() == Node.ELEMENT_NODE) { // 노드의 타입이 Element일 경우(공백이 아닌 경우)

						//System.out.print("욕설목록: "+item_child.getTextContent()+" ");
						String str = item_child.getTextContent()+" ";
						array.add(str);
						    

					} 
				}
			

			}   // for end
			
			//출력				
			for(int i=0;i<array.size();i++) {	
				String badString = array.get(i).trim(); // trim은 공백제거
				badString=".*"+badString+".*";  //.*문자열*.은 정규식
				if(b_content.trim().matches(badString)) {
					//matches를 이용하여 정규식으로 문자열 비교
					testtest = "no";
					break;
				}else {
					testtest="ok";
				}
			}  

			System.out.println("testtest: "+ testtest);
			if(testtest.equals("ok")) {

				dao.Replywrite(b_id,b_lev,u_id,b_title,b_content,b_pw);
				model.addAttribute("result", testtest);
			}else {
				model.addAttribute("result", testtest);

			}
			

		}catch(Exception e) {
			e.printStackTrace();
		}



	}

}
