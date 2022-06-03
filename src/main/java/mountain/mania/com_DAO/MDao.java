package mountain.mania.com_DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.SingleColumnRowMapper;

import com.slacademy.last_project.GDTO.GDto;
import com.slacademy.last_project.SGDTO.SGDto;
import com.slacademy.last_project.UBDto.BDto;

import mountain.mania.com_DTO.CDto;
import mountain.mania.com_DTO.IDto;
import mountain.mania.com_DTO.MDto;

import mountain.mania.com_util.Constant;



public class MDao {


	JdbcTemplate template;

	public MDao() {

		this.template = Constant.template;

	}

	public void MountainInsert(final MDto mdto) {
		System.out.println("MountainInsert");
		System.out.println("DAO : "+mdto.getM_name());
		int num;
		String sql0="select max(m_id)as m_id from mountain";

		if(template.queryForObject(sql0,Integer.class) != null) {
			num=template.queryForObject(sql0,Integer.class)+1;
		}
		else {
			num = 1;
		}



		String sql2="insert into mountain (m_id,m_name,m_level,m_img,";
		sql2+="area, parking, m_address,items_name,"+
				"items_img) values("+num+",?,?,?,?,?,?,?,?)";

		this.template.update(sql2, new PreparedStatementSetter() { //업데이트에 사용

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {


				pstmt.setString(1, mdto.getM_name());
				pstmt.setString(2, mdto.getM_level());
				pstmt.setString(3, mdto.getM_img());
				pstmt.setString(4, mdto.getArea());
				pstmt.setString(5, mdto.getParking());
				pstmt.setString(6, mdto.getM_address());
				pstmt.setString(7, mdto.getItems_name());
				pstmt.setString(8, mdto.getItems_img());

			}
		});

	}

	public int gethighcount(final String m_level) {

		int count=0;
		String query = "select count(*) as count from mountain where m_level=?";//as count 컬럼 명 변경해줌
		//return template.queryForObject(query, Integer.class);   //셀렉 문 사용queryForObject = 싱글 반환
		//		return template.queryForInt(query);
		count=template.query(query, new PreparedStatementSetter() { //업데이트에 사용

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {


				pstmt.setString(1, m_level);

			}
		}, new  SingleColumnRowMapper<Integer>(Integer.class)).get(0);


		System.out.println(count);
		return count;




	}

	public ArrayList<MDto> getMHighList(int page, int limit,  final String m_level) {
		final int startrow=(page-1)*8; //읽기 시작할 row 번호.
		final int endrow=startrow+limit; //읽을 마지막 row 번호.
		
		String query = "select * from mountain where m_level=? limit ?,?";
		return  (ArrayList<MDto>)template.query(query, new PreparedStatementSetter() { //업데이트에 사용

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {

				pstmt.setString(1, m_level);
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, endrow);

			}
		} , new BeanPropertyRowMapper<MDto>(MDto.class) );




		//		return (ArrayList<MDto>) template.query     // 셀렉문 사용 query = 리스트 반환
		//				(query, new BeanPropertyRowMapper<MDto>(MDto.class));
	}

	public void ItemInsert(final IDto idto) {
		int num;
		String sql0="select max(item_id)as item_id from items";

		if(template.queryForObject(sql0,Integer.class) != null) {
			num=template.queryForObject(sql0,Integer.class)+1;
		}
		else {
			num = 1;
		}



		String sql2="insert into items (item_id,items_name,site,img,ilevel) values("+num+",?,?,?,?)";


		this.template.update(sql2, new PreparedStatementSetter() { //업데이트에 사용

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {


				pstmt.setString(1, idto.getItems_name());
				pstmt.setString(2, idto.getSite());
				pstmt.setString(3, idto.getImg());
				pstmt.setString(4, "상");
				

			}
		});

	}

	public int getitemscount() {
		int count=0;
		String query = "select count(*) as count from items";//as count 컬럼 명 변경해줌
		return template.queryForObject(query, Integer.class);   //셀렉 문 사용queryForObject = 싱글 반환
	}

	public ArrayList<IDto> getItemsList(int page, int limit,final String item) {
		final int startrow=(page-1)*8; //읽기 시작할 row 번호.
		final int endrow=startrow+limit; //읽을 마지막 row 번호.
		//			String query = "select * from (select rownum rnum,m_id,m_name,m_level,"+
		//				"m_img,area,parking,m_address,items_name,items_img from "+
		//				"mountain)where rnum>=? and rnum<=? and m_level =?" ;
		//			
		//			String query = "select * from "+
		//					"(select rownum rnum,m_id,m_name,m_level,"+
		//					"m_img,area,parking,m_address,"+
		//					"items_name,items_img from "+
		//					"(select * from mountain order by m_id asc)) "+
		//					"where rnum>=? and rnum<=? and m_level=?" ;
		//		String query = "select * from mountain where m_level=? ";
		String query = "select * from items where ilevel = ? limit ?,?";
		return  (ArrayList<IDto>)template.query(query, new PreparedStatementSetter() { //업데이트에 사용

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {

				pstmt.setString(1, item);
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, endrow);

			}
		} , new BeanPropertyRowMapper<IDto>(IDto.class) );





	}

	public ArrayList<MDto> getMList() {
		// TODO Auto-generated method stub
		String query="select * from mountain";
		return (ArrayList<MDto>) template.query     // 셀렉문 사용 query = 리스트 반환
				(query, new BeanPropertyRowMapper<MDto>(MDto.class));
	}

	public int getRecommend(final String u_id) {
		System.out.println("getRecommend:왔나요?");
		String query="select u_level from users where u_id = ?";
		int count=0;
		count=template.query(query, new PreparedStatementSetter() { //업데이트에 사용

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {


				pstmt.setString(1, u_id);

			}
		}, new  SingleColumnRowMapper<Integer>(Integer.class)).get(0);


		System.out.println(count);
		return count;


	}

	public void MDelete(final int m_id) {
		// TODO Auto-generated method stub
		String board_delete_sql="delete from mountain where m_id=?";
		this.template.update(board_delete_sql, new PreparedStatementSetter() { //업데이트문

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, m_id);
			}
		});
	}

	public List getIList() {
		String query="select * from items";
		return (ArrayList<IDto>) template.query     // 셀렉문 사용 query = 리스트 반환
				(query, new BeanPropertyRowMapper<IDto>(IDto.class));


	}

	public void IDelete(final int item_id) {
		String board_delete_sql="delete from items where item_id=?";
		this.template.update(board_delete_sql, new PreparedStatementSetter() { //업데이트문

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, item_id);
			}
		});

	}

	//총 게시글 수 
	public int count() { 
		int count=0;
		String query = "select count(*) as count from userboard";//as count 컬럼 명 변경해줌
		return template.queryForObject(query, Integer.class);//답변을 Integer로 바꿔서 리턴해줌 기본타입과 레퍼타입은 서로 자유롭게 섞어 쓸 수 있다/낮은 버전에서는 안됨

	}


	//list페이지 -->페이징처리도 함께
	public ArrayList<BDto> userborderlist(int page, int limit){
		System.out.println("여긴 다오");


		String query =" select b_id ,u_id ,b_title ,b_content ,b_date ,b_hit ,b_group,b_step ,b_indent ,b_pw ,b_lev,b_img  from userboard order by b_group desc, b_id";


		//rnum 내장함수

		System.out.println( (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class)));
		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));

		//new BeanPropertyRowMapper<BDto>(BDto.class) -> 빈즈에 담아주겠다 그럼 쿼리랑 같이 실행해서 ArrayList로 리턴해주겠다
	}


	//제목 클릭시 상세보기 
	public BDto contentView(String b_id, String uphit_change) {

		if(uphit_change.equals("ok")) {
			upHit(b_id);
		}
		String sql = "select b_id ,u_id ,b_title ,b_content ,b_date ,b_hit ,b_group,b_step ,b_indent ,b_pw ,b_lev,b_img from userboard where b_id= "+b_id;
		System.out.println(sql);
		return template.queryForObject(sql, new BeanPropertyRowMapper<BDto>(BDto.class));//queryForObject는 하나의 클래스를 리턴한다 그리고  제네릭이라서 객체생성과 동시에 결정이 된다   

	}

	//조회수 업로드
	private void upHit(final String b_id) {
		String sql = "update userboard set b_hit = b_hit + 1 where b_id ="+b_id;
		this.template.update(sql);


	}



	//비밀번호 체크할때
	public String PwCheck(String b_id) {
		// TODO Auto-generated method stub
		String sql = "select b_pw from userboard where b_id= "+b_id;
		System.out.println(sql);
		return template.queryForObject(sql,String.class);

	}

	//게시글 삭제시
	public void bDelete(final String b_id) { 

		String sql ="delete from userboard where b_id =?";
		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, b_id);
			}

		});

	}

	//게시글 수정시
	public void bModifyAction(final String b_id, final String u_id, final String b_title, final String b_content, final String b_img) {
		String sql ="update userboard set u_id=?,b_title=?,b_content=?,b_img=? where b_id =?";
		this.template.update(sql, new PreparedStatementSetter() { //?로 쿼리문이 완성되지 않았기 때문에 완성시키기 위해서 PreparedStatementSetter를 이용해서 value를 채워줌 이건 어나니머스 클ㄹ래스

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, u_id);
				ps.setString(2, b_title);
				ps.setString(3, b_content);
				ps.setString(4, b_img);
				ps.setString(5, b_id);
			}

		});


	}

	//답글 쓰고 저장시 커맨드
	public void Replywrite(final String b_id, final String b_lev, final String u_id, final String b_title, final String b_content, final String b_Pw) {
		int num;
		String sql0="select max(b_id)as b_id from userboard";//동호회리스트의 max값을 찾는 sql을 쓰고
		System.out.println("retest");
		if(template.queryForObject(sql0,Integer.class) != null) {//그 값이 null이 아니라면 찾은 값에 +1을 해주고
			num=template.queryForObject(sql0,Integer.class)+1;
		}
		else {//null이라면 그 값을 1로 바꿔줘라
			num = 1;
		}

		System.out.println(num);

		String sql = "insert into userboard(b_id, u_id, b_title, b_content, b_pw, b_lev, b_hit, b_group, b_step, b_indent) values "
				+ "("+num+", ?,?,?,?,?,0,(select a.b_group from (select b_group from userboard where b_id=?)a),0,0)";
		this.template.update(sql, new PreparedStatementSetter() {
			int levInt=Integer.parseInt(b_lev)+1;

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, u_id);
				ps.setString(2, b_title);
				ps.setString(3, b_content);
				ps.setString(4, b_Pw);
				ps.setString(5,String.valueOf(levInt));
				ps.setString(6, b_id);

			}

		});

	}

	//글작성시
	public void boardInsert(final BDto boarddata) {

		int num;
		String sql0="select max(b_id)as b_id from userboard";// max값을 찾는 sql을 쓰고

		if(template.queryForObject(sql0,Integer.class) != null) {//그 값이 null이 아니라면 찾은 값에 +1을 해주고
			num=template.queryForObject(sql0,Integer.class)+1;
		}
		else {//null이라면 그 값을 1로 바꿔줘라
			num = 1;
		}

		System.out.println(num);

		String sql = "insert into userboard(b_id, u_id, b_title, b_content,b_pw,b_img,b_lev,  b_hit, b_group, b_step, b_indent ) values "
				+ "("+num+", ?,?,?,?,?,0,0,"+num+",0,0)";		
		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, boarddata.getU_id());
				ps.setString(2, boarddata.getB_title());
				ps.setString(3, boarddata.getB_content());
				ps.setString(4, boarddata.getB_pw());
				ps.setString(5, boarddata.getB_img());


			}

		});


	}

	public ArrayList<MDto> mountain() {
		String sql = "select m_name, m_address from mountain";
		return (ArrayList<MDto>) template.query(sql, new BeanPropertyRowMapper<MDto>(MDto.class));
	}

	public void CourseinInsert(final CDto cdto) {
		// TODO Auto-generated method stub
		int num;
		String sql0="select max(c_id)as c_id from course";

		if(template.queryForObject(sql0,Integer.class) != null) {
			num=template.queryForObject(sql0,Integer.class)+1;
		}
		else {
			num = 1;
		}

		// String sql1="select AVG(cleartime) from useractive where c_id=?";


		String sql2="insert into course (c_id,img,c_level,cleartime,m_id) values("+num+",?,?,?,?)";
		//		sql2+="area, parking, m_address,items_name,"+
		//				"items_img) values("+num+",?,?,?,?,?,?,?,?)";

		this.template.update(sql2, new PreparedStatementSetter() { //업데이트에 사용

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {


				pstmt.setString(1, cdto.getImg());
				pstmt.setString(2, cdto.getC_level());
				pstmt.setInt(3, 0);
				pstmt.setInt(4, cdto.getM_id());


			}
		});


	}

	public ArrayList<MDto> getAppMList() {

		String query = "select * from mountain";
		return  (ArrayList<MDto>)template.query(query,new BeanPropertyRowMapper<MDto>(MDto.class));



	}

	public ArrayList<CDto> ViewCourse(String m_id) {

		String query = "select * from course where m_id="+m_id;

		return (ArrayList<CDto>)template.query(query, new BeanPropertyRowMapper<CDto>(CDto.class));
	}

	public void cupdate(final String c_id) {
		// TODO Auto-generated method stub

		//String num;
		System.out.println("c_id: "+c_id);


		String query = "select AVG(cleartime) from useractive where c_id="+c_id;

		String num=template.queryForObject(query,String.class);
		System.out.println("DAOnum:"+num);
		//		String num=template.query(query, new PreparedStatementSetter() { //업데이트에 사용
		//
		//			@Override
		//		public void setValues(PreparedStatement pstmt) throws SQLException {
		//
		//
		//				pstmt.setString(1, c_id);
		//				
		//			}
		//		}, new  SingleColumnRowMapper<String>(String.class)).get(0);
		//		  
		//		  
		//		  System.out.println("DAOnum:"+num);
		String sql ="update course set cleartime="+num+" where c_id ="+c_id;
		this.template.update(sql);


	}






	public ArrayList<CDto> CourseDetail(String c_id) {

		String query = "select * from course where c_id="+c_id;

		return (ArrayList<CDto>)template.query(query, new BeanPropertyRowMapper<CDto>(CDto.class));
	}

	public ArrayList<GDto> list6() {

		String sql="select bg_id, bg_name, u_id,bg_experience, "
				+ " case "
				+ " when bg_experience > 5"
				+ " then '6'"
				+ " when bg_experience > 4"
				+ " then '5'"
				+ " when bg_experience > 3"
				+ " then '4'"
				+ " when bg_experience > 2"
				+ " then '3'"
				+ " when bg_experience > 1"
				+ " then '2'"
				+ " else '1'"
				+ " end as bg_level, bg_intro, bg_date from big_group_list order by bg_id limit 0,6";
		//String sql="select * from big_group_list order by bg_id";
		return (ArrayList<GDto>) template.query(sql, new BeanPropertyRowMapper<GDto>(GDto.class));
}


		//모임리스트
		public ArrayList<SGDto> Slist6() {
			System.out.println("sg list다오 들어옴");
			String sql="select * from small_group_list order by sg_id limit 0,6";
			return (ArrayList<SGDto>) template.query(sql, new BeanPropertyRowMapper<SGDto>(SGDto.class));
		}

		public ArrayList<GDto> bg_rank6() {

			String sql="select bg_id, bg_name, u_id,bg_experience, "
					+ " case "
					+ " when bg_experience > 5"
					+ " then '6'"
					+ " when bg_experience > 4"
					+ " then '5'"
					+ " when bg_experience > 3"
					+ " then '4'"
					+ " when bg_experience > 2"
					+ " then '3'"
					+ " when bg_experience > 1"
					+ " then '2'"
					+ " else '1'"
					+ " end as bg_level, bg_intro, bg_date, row_number() over (order by bg_experience desc) as bg_rank from big_group_list limit 0,6";


			return (ArrayList<GDto>) template.query(sql, new BeanPropertyRowMapper<GDto>(GDto.class));
		}

		public boolean adminlogin(String id, String pass) {
			// TODO Auto-generated method stub
			if(!id.equals("admin")) {
				return false;
			}
			
			String board_sql="select u_pw from users where u_id='admin'";
			String a = template.queryForObject(board_sql,String.class); //셀렉 문 사용queryForObject = 싱글 반환
			if(a.equals(pass)) {
				return true;
			}
			
			return false;
			
		}

}











