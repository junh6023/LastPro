package com.slacademy.last_project.CSDao;



import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;


import com.slacademy.last_project.CSDto.CSDto;

import mountain.mania.com_util.Constant;


   

public class CSDao {
	

	JdbcTemplate template;
	
	//오라클DB연결
	public CSDao() { 
		this.template= Constant.template;
	}


	
//////////////////////////////////////////////Repetition_QnA/////////////////////////////////////////////	
	//게시글 수
	public int Ecount() {
		int count=0;
		String query = "select count(*) as count from Repetition_QnA";//as count 컬럼 명 변경해줌
		return template.queryForObject(query, Integer.class);//답변을 Integer로 바꿔서 리턴해줌 기본타입과 레퍼타입은 서로 자유롭게 섞어 쓸 수 있다/낮은 버전에서는 안됨
	}
	//자주하는 질문 페이지
	public ArrayList<CSDto> Elist(int page, int limit) {
		
		final int startrow=(page-1)*10; //읽기 시작할 row 번호.
	    final int endrow=startrow+limit; //읽을 마지막 row 번호.
		
		String query =" select * from (select b_id ,u_id ,b_title ,b_content ,b_date ,b_hit ,b_group ,b_pw ,b_lev from Repetition_QnA  order by b_group desc) ORDERS LIMIT "+startrow+","+endrow;
		
		System.out.println(query);
		return (ArrayList<CSDto>) template.query(query, new BeanPropertyRowMapper<CSDto>(CSDto.class));
		//new BeanPropertyRowMapper<CSDto>(CSDto.class) -> 빈즈에 담아주겠다 그럼 쿼리랑 같이 실행해서 ArrayList로 리턴해주겠다
	}

	//글쓰기
	public void EboardInsert(final CSDto boarddata) {
		int num;
		String sql0="select max(b_id)as b_id from Repetition_QnA";// max값을 찾는 sql을 쓰고

		if(template.queryForObject(sql0,Integer.class) != null) {//그 값이 null이 아니라면 찾은 값에 +1을 해주고
			num=template.queryForObject(sql0,Integer.class)+1;
	      }
	      else {//null이라면 그 값을 1로 바꿔줘라
	         num = 1;
	      }
		
		System.out.println(num);
		
		String sql = "insert into Repetition_QnA(b_id, u_id, b_title, b_content,b_pw,b_lev, b_hit, b_group ) values "
				+ "("+num+", ?,?,?,?,0,0,"+num+")";		
		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, boarddata.getU_id());
				ps.setString(2, boarddata.getB_title());
				ps.setString(3, boarddata.getB_content());
				ps.setString(4, boarddata.getB_pw());

			
				
			}
			
		});
		
	}
	//내용
	public CSDto EcontentView(String b_id, String uphit_change) {
		
		if(uphit_change.equals("ok")) {
			EupHit(b_id);
			}
			String sql = "select b_id ,u_id ,b_title ,b_content ,b_date ,b_hit ,b_group ,b_pw ,b_lev from Repetition_QnA where b_id= "+b_id;
			System.out.println(sql);
			return template.queryForObject(sql, new BeanPropertyRowMapper<CSDto>(CSDto.class));//queryForObject는 하나의 클래스를 리턴한다 그리고  제네릭이라서 객체생성과 동시에 결정이 된다   
		}
		
		private void EupHit(final String b_id) {
			String sql = "update Repetition_QnA set b_hit = b_hit + 1 where b_id ="+b_id;
			this.template.update(sql);
			
		
	}


		//검색한 글 수
		public int e_serch_count(String searchs) {
			int count=0;
			String query = "select count(*) as count from Repetition_QnA where u_id like '%"+searchs+"%' or b_title like  '%"+searchs+"%' or b_content like  '%"+searchs+"%' "; //as count 컬럼 명 변경해줌

			return template.queryForObject(query, Integer.class);
		}


		//검색
		public ArrayList<CSDto> e_serchs(final String searchs, int page, int limit) {
			final int startrow=(page-1)*10; //읽기 시작할 row 번호.
		    final int endrow=startrow+limit; //읽을 마지막 row 번호.
			
			String sql="select * from(select * from Repetition_QnA where u_id like ? or b_title like ? or b_content like ? ) ORDERS LIMIT "+startrow+","+endrow;
			return (ArrayList<CSDto>) template.query(sql, new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setString(1, "%"+searchs+"%");
					ps.setString(2, "%"+searchs+"%");
					ps.setString(3, "%"+searchs+"%");
					
				}
				
				
			}, new BeanPropertyRowMapper<CSDto>(CSDto.class));
		}



		public String EPwCheck(String b_id) {
			// TODO Auto-generated method stub
			String sql = "select b_pw from Repetition_QnA where b_id= "+b_id;
			System.out.println(sql);
			return template.queryForObject(sql,String.class);
		}



		public void EbModifyAction(final String b_id, final String u_id, final String b_title, final String b_content) {
			String sql ="update Repetition_QnA set u_id=?,b_title=?,b_content=? where b_id =?";
			this.template.update(sql, new PreparedStatementSetter() { //?로 쿼리문이 완성되지 않았기 때문에 완성시키기 위해서 PreparedStatementSetter를 이용해서 value를 채워줌 이건 어나니머스 클ㄹ래스

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setString(1, u_id);
					ps.setString(2, b_title);
					ps.setString(3, b_content);
					ps.setString(4, b_id);
				}
				
			});

			
		}


		//삭제시
		public void EbDelete(final String b_id) {
			String sql ="delete from Repetition_QnA where b_id =?";
			this.template.update(sql, new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setString(1, b_id);
				}
				
			});
			
			
		}



	

}
