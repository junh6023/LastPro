package mountain.mania.com_command;

import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
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

public class MInsertForm implements MCommand{
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
		
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String m_name=request.getParameter("m_name");
		int page = 1;	// 페이지 초기값 
		try{
		
				// parsing할 url 지정(API 키 포함해서)
				StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1400000/service/cultureInfoService/mntInfoOpenAPI"); /*URL*/
				urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=zs6ElEqkrJPzV0ZkXDRImDScj8cv3UXyvJglP1Ney1bp%2B8oKVbdTqIcQBKGc435NVDy%2FeBRucg%2BozUNADVEulQ%3D%3D"); /*Service Key*/
				urlBuilder.append("&" + URLEncoder.encode("searchWrd","UTF-8") + "=" + URLEncoder.encode(m_name, "UTF-8")); /*예:1) searchWrd = “북한산”일때 산명안에 “북한산”을 포함하는 “북한산”이 검색됨*/
				URL url = new URL(urlBuilder.toString());
				InputStream stream = url.openStream();
				//char ch=0;
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(stream);

				// root tag 
				doc.getDocumentElement().normalize();
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

				// 파싱할 tag
				NodeList nList = doc.getElementsByTagName("item");
				System.out.println("파싱할 리스트 수 : "+ nList.getLength());
				//System.out.println("nList:" + nList);

				List<String> mname = new ArrayList<>();
				List<String> maddress = new ArrayList<>();
				for(int temp = 0; temp < nList.getLength(); temp++){
					Node nNode = nList.item(temp);
					//System.out.println("nNode:"+nNode);
					if(nNode.getNodeType() == Node.ELEMENT_NODE){

						Element eElement = (Element) nNode;
						//System.out.println("######################");
						//System.out.println(eElement.getTextContent());

						mname.add(getTagValue("mntiname", eElement));
						maddress.add(getTagValue("mntiadd", eElement));
						System.out.println("mname: "+mname);
						System.out.println("산이름  : " + getTagValue("mntiname", eElement));

					}	// for end
				}	// if end


				model.addAttribute("mname", mname); //산이름
				model.addAttribute("maddress", maddress); //산주소


			

		} catch (Exception e){	
			e.printStackTrace();
		}	
	}

}
