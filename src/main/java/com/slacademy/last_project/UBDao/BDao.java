package com.slacademy.last_project.UBDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.slacademy.last_project.UBDto.BDto;

import mountain.mania.com_util.Constant;




public class BDao {
	

	JdbcTemplate template;
	
	//오라클DB연결
	public BDao() { 
		this.template= Constant.template;
	}
	
	
	//총 게시글 수 
	public int count() { 
		int count=0;
		String query = "select count(*) as count from userboard";//as count 컬럼 명 변경해줌
		return template.queryForObject(query, Integer.class);//답변을 Integer로 바꿔서 리턴해줌 기본타입과 레퍼타입은 서로 자유롭게 섞어 쓸 수 있다/낮은 버전에서는 안됨

	}
	
	
	//list페이지 -->페이징처리도 함께
	public ArrayList<BDto> list(){
		System.out.println("여긴 다오");
	
		
		String query =" select b_id ,u_id ,b_title ,b_content ,b_date ,b_hit ,b_group,b_step ,b_indent ,b_pw ,b_lev,b_img  from userboard  order by b_group desc, b_id";
		//rnum 내장함수
		System.out.println("test3");
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


	public int serch_count(String searchs) {
		int count=0;
		String query = "select count(*) as count from userboard where u_id like '%"+searchs+"%' or b_title like  '%"+searchs+"%' or b_content like  '%"+searchs+"%' "; //as count 컬럼 명 변경해줌

		return template.queryForObject(query, Integer.class);
	}


	public ArrayList<BDto> serchs(final String searchs, int page, int limit) {
		final int startrow=(page-1)*10; //읽기 시작할 row 번호.
	    final int endrow=startrow+limit; //읽을 마지막 row 번호.
		
		String sql="select * from(select * from userboard where u_id like ? or b_title like ? or b_content like ? ) ORDERS LIMIT "+startrow+","+endrow;
		return (ArrayList<BDto>) template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, "%"+searchs+"%");
				ps.setString(2, "%"+searchs+"%");
				ps.setString(3, "%"+searchs+"%");
				
			}
			
			
		}, new BeanPropertyRowMapper<BDto>(BDto.class));
	}

////////////////////////////////////////이벤트게시판//////////////////////////////////////////////
	public int Ecount() {
		int count=0;
		String query = "select count(*) as count from eventboard";
		return template.queryForObject(query, Integer.class);
	}


	public ArrayList<BDto> Elist(int page, int limit) {
		
		final int startrow=(page-1)*10; //읽기 시작할 row 번호.
	    final int endrow=startrow+limit; //읽을 마지막 row 번호.
		
		String query =" select * from (select b_id ,u_id ,b_title ,b_content ,b_date ,b_hit ,b_group ,b_pw ,b_img  from eventboard  order by b_group desc) ORDERS LIMIT "+startrow+","+endrow;
		
		System.out.println(query);
		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		//new BeanPropertyRowMapper<BDto>(BDto.class) -> 빈즈에 담아주겠다 그럼 쿼리랑 같이 실행해서 ArrayList로 리턴해주겠다
	}


	public void EboardInsert(final BDto boarddata) {
		int num;
		String sql0="select max(b_id)as b_id from eventboard";// max값을 찾는 sql을 쓰고

		if(template.queryForObject(sql0,Integer.class) != null) {//그 값이 null이 아니라면 찾은 값에 +1을 해주고
			num=template.queryForObject(sql0,Integer.class)+1;
	      }
	      else {//null이라면 그 값을 1로 바꿔줘라
	         num = 1;
	      }
		
		System.out.println(num);
		
		String sql = "insert into eventboard(b_id, u_id, b_title, b_content,b_pw,b_img,b_lev,  b_hit, b_group, b_step, b_indent ) values "
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


	public BDto EcontentView(String b_id, String uphit_change) {
		if(uphit_change.equals("ok")) {
			EupHit(b_id);
			}
			String sql = "select b_id ,u_id ,b_title ,b_content ,b_date ,b_hit ,b_group,b_step ,b_indent ,b_pw ,b_lev,b_img from eventboard where b_id= "+b_id;
			System.out.println(sql);
			return template.queryForObject(sql, new BeanPropertyRowMapper<BDto>(BDto.class));//queryForObject는 하나의 클래스를 리턴한다 그리고  제네릭이라서 객체생성과 동시에 결정이 된다   
	}

	private void EupHit(final String b_id) {
		String sql = "update eventboard set b_hit = b_hit + 1 where b_id ="+b_id;
		this.template.update(sql);
		
		
	}


	public String EPwCheck(String b_id) {
		String sql = "select b_pw from eventboard where b_id= "+b_id;
		System.out.println(sql);
		return template.queryForObject(sql,String.class);
	}


	public void EbDelete(final String b_id) {
		String sql ="delete from eventboard where b_id =?";
		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, b_id);
			}
			
		});
		
	}


	public void EbModifyAction(final String b_id, final String u_id, final String b_title, final String b_content, final String b_img) {
		String sql ="update eventboard set u_id=?,b_title=?,b_content=?,b_img=? where b_id =?";
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


	public int e_serch_count(String searchs) {
		int count=0;
		String query = "select count(*) as count from eventboard where u_id like '%"+searchs+"%' or b_title like  '%"+searchs+"%' or b_content like  '%"+searchs+"%' "; //as count 컬럼 명 변경해줌

		return template.queryForObject(query, Integer.class);
	}


	public ArrayList<BDto> e_serchs(final String searchs, int page, int limit) {
		final int startrow=(page-1)*10; //읽기 시작할 row 번호.
	    final int endrow=startrow+limit; //읽을 마지막 row 번호.
		
		String sql="select * from(select * from eventboard where u_id like ? or b_title like ? or b_content like ? ) ORDERS LIMIT "+startrow+","+endrow;
		return (ArrayList<BDto>) template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, "%"+searchs+"%");
				ps.setString(2, "%"+searchs+"%");
				ps.setString(3, "%"+searchs+"%");
				
			}
			
			
		}, new BeanPropertyRowMapper<BDto>(BDto.class));
	}

///////////////////////////////////////공지게시판//////////////////////////////////////////////////////
	public int Ncount() {
		int count=0;
		String query = "select count(*) as count from noticeboard";
		return template.queryForObject(query, Integer.class);
	}

	public ArrayList<BDto> Nlist(int page, int limit) {
		
		final int startrow=(page-1)*10; //읽기 시작할 row 번호.
	    final int endrow=startrow+limit; //읽을 마지막 row 번호.
		
		String query =" select * from (select b_id ,u_id ,b_title ,b_content ,b_date ,b_hit ,b_group ,b_pw ,b_img  from noticeboard  order by b_group desc) ORDERS LIMIT "+startrow+","+endrow;
		
		System.out.println(query);
		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		//new BeanPropertyRowMapper<BDto>(BDto.class) -> 빈즈에 담아주겠다 그럼 쿼리랑 같이 실행해서 ArrayList로 리턴해주겠다
	}

	public void NboardInsert(final BDto boarddata) {
		int num;
		String sql0="select max(b_id)as b_id from noticeboard";// max값을 찾는 sql을 쓰고

		if(template.queryForObject(sql0,Integer.class) != null) {//그 값이 null이 아니라면 찾은 값에 +1을 해주고
			num=template.queryForObject(sql0,Integer.class)+1;
	      }
	      else {//null이라면 그 값을 1로 바꿔줘라
	         num = 1;
	      }
		
		System.out.println(num);
		
		String sql = "insert into noticeboard(b_id, u_id, b_title, b_content,b_pw,b_img,b_lev,  b_hit, b_group, b_step, b_indent ) values "
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

	public BDto NcontentView(String b_id, String uphit_change) {
		if(uphit_change.equals("ok")) {
			EupHit(b_id);
			}
			String sql = "select b_id ,u_id ,b_title ,b_content ,b_date ,b_hit ,b_group,b_step ,b_indent ,b_pw ,b_lev,b_img from noticeboard where b_id= "+b_id;
			System.out.println(sql);
			return template.queryForObject(sql, new BeanPropertyRowMapper<BDto>(BDto.class));//queryForObject는 하나의 클래스를 리턴한다 그리고  제네릭이라서 객체생성과 동시에 결정이 된다   
	}

	public String NPwCheck(String b_id) {
		// TODO Auto-generated method stub
		String sql = "select b_pw from noticeboard where b_id= "+b_id;
		System.out.println(sql);
		return template.queryForObject(sql,String.class);
	}

	public void NbDelete(final String b_id) {
		String sql ="delete from noticeboard where b_id =?";
		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, b_id);
			}
			
		});
		
	}

	public void NbModifyAction(final String b_id, final String u_id, final String b_title, final String b_content, final String b_img) {
		String sql ="update noticeboard set u_id=?,b_title=?,b_content=?,b_img=? where b_id =?";
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

	public int n_serch_count(String searchs) {
		int count=0;
		String query = "select count(*) as count from noticeboard where u_id like '%"+searchs+"%' or b_title like  '%"+searchs+"%' or b_content like  '%"+searchs+"%' "; //as count 컬럼 명 변경해줌

		return template.queryForObject(query, Integer.class);
	}

	
	public ArrayList<BDto> n_serchs(final String searchs, int page, int limit) {
		final int startrow=(page-1)*10; //읽기 시작할 row 번호.
	    final int endrow=startrow+limit; //읽을 마지막 row 번호.
		
		String sql="select * from(select * from noticeboard where u_id like ? or b_title like ? or b_content like ? ) ORDERS LIMIT "+startrow+","+endrow;
		return (ArrayList<BDto>) template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, "%"+searchs+"%");
				ps.setString(2, "%"+searchs+"%");
				ps.setString(3, "%"+searchs+"%");
				
			}
			
			
		}, new BeanPropertyRowMapper<BDto>(BDto.class));
	}

	


	



}
