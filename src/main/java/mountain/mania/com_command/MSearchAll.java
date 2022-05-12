package mountain.mania.com_command;

import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.ui.Model;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MSearchAll implements MCommand{
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
		LocalDateTime now = LocalDateTime.now();
		// 현재 날짜/시간 출력
		//System.out.println(now); // 2021-06-17T06:43:21.419878100
		// 포맷팅
		String formatedNow1 = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

		String time1= formatedNow1.substring(0,8);
		String time2= formatedNow1.substring(8,10);
		int time3= Integer.parseInt(time2);
	      int time4 = time3-1;
	      String a = "";
	      
	      if(time4<10) {
	         a= "0"+time4;
	      }else {
	         a=""+time4;
	      }
		String searchArea = "서울/경기";
		model.addAttribute("searchArea", searchArea);
		try{

			// parsing할 url 지정(API 키 포함해서)
			StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst"); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=cKmGPlf4cOVxezDPgvcwIjsH0pp%2BaFY0WgS6egQJ5SiUAHwc28PnzN0FoHqJSs9SgTmEHE7a8g6WkC97ZZWrtQ%3D%3D"); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
			urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
			urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("XML", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
			urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(time1, "UTF-8")); /*‘21년 6월 28일 발표*/
			urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(a+"30", "UTF-8")); /*06시 발표(정시단위) */
			urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode("60", "UTF-8")); /*예보지점의 X 좌표값*/
			urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode("127", "UTF-8")); /*예보지점의 Y 좌표값*/
			URL url = new URL(urlBuilder.toString());
			InputStream stream = url.openStream();

			DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
			Document doc = dBuilder.parse(stream);

			// root tag 060
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			// 파싱할 tag
			NodeList nList = doc.getElementsByTagName("item");
			System.out.println("파싱할 리스트 수 : "+ nList.getLength());
			//System.out.println("nList:" + nList);

			//				List<String> mname = new ArrayList<>();
			//				List<String> maddress = new ArrayList<>();
			for(int temp = 0; temp < nList.getLength(); temp++){
				Node nNode = nList.item(temp);
				//System.out.println("nNode:"+nNode);
				NodeList item_childlist = nNode.getChildNodes();

					//System.out.println("item_childlist: "+item_childlist.getLength());

//					for(int j=0; j<item_childlist.getLength(); j++) {
//					Node item_child = item_childlist.item(j);
				Element eElement = (Element) nNode;
				if(getTagValue("category", eElement).equals("T1H") && getTagValue("baseTime", eElement).equals(a+"30")) {
					String temperature = getTagValue("fcstValue", eElement);
					model.addAttribute("b1", temperature); //온도
					
					//System.out.println(item_child.getNodeName()+":"+item_child.getTextContent());
					//}
				}
				if(getTagValue("category", eElement).equals("RN1") && getTagValue("baseTime", eElement).equals(a+"30")) {
					String precipitation = getTagValue("fcstValue", eElement);
					model.addAttribute("precipitation", precipitation); //강수량
					//System.out.println("값:"+getTagValue("obsrValue", eElement));
					//System.out.println(item_child.getNodeName()+":"+item_child.getTextContent());
					//}
				}
				if(getTagValue("category", eElement).equals("REH") && getTagValue("baseTime", eElement).equals(a+"30")) {
					String REH = getTagValue("fcstValue", eElement);
					model.addAttribute("REH", REH); //습도
					//System.out.println("값:"+getTagValue("obsrValue", eElement));
					//System.out.println(item_child.getNodeName()+":"+item_child.getTextContent());
					//}
				}
				if(getTagValue("category", eElement).equals("VEC") && getTagValue("baseTime", eElement).equals(a+"30")) {
					String VEC = getTagValue("fcstValue", eElement);
					model.addAttribute("VEC", VEC); //풍향
					//System.out.println("값:"+getTagValue("obsrValue", eElement));
					//System.out.println(item_child.getNodeName()+":"+item_child.getTextContent());
					//}
				}
				if(getTagValue("category", eElement).equals("WSD") && getTagValue("baseTime", eElement).equals(a+"30")) {
					String WSD = getTagValue("fcstValue", eElement);
					model.addAttribute("WSD", WSD); //풍속
					
				}
				if(getTagValue("category", eElement).equals("SKY") && getTagValue("baseTime", eElement).equals(a+"30")) {
					String SKY = getTagValue("fcstValue", eElement);
					model.addAttribute("SKY", SKY); //하늘
					
				}
				if(getTagValue("category", eElement).equals("PTY") && getTagValue("baseTime", eElement).equals(a+"30")) {
					String PTY = getTagValue("fcstValue", eElement);
					model.addAttribute("PTY", PTY); //강수형태
					
				}
				if(getTagValue("nx", eElement).equals("60")) {
					
					model.addAttribute("a1", "서울/경기"); //도시
					
				
					
				}


			}	// for end
			



		} catch (Exception e){	
			e.printStackTrace();
		}	
	}

}
