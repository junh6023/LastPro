package com.slacademy.last_project.SGDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.SingleColumnRowMapper;

import com.slacademy.last_project.GDTO.GDto;
import com.slacademy.last_project.GDTO.GJoinDto;
import com.slacademy.last_project.GDTO.GMDto;

import com.slacademy.last_project.SGDTO.SGDto;
import com.slacademy.last_project.SGDTO.SGJoinDto;
import com.slacademy.last_project.SGDTO.SGMDto;
import com.slacademy.last_project.SGDTO.SGSDto;
import com.slacademy.last_project.SGDTO.SG_ADto;

import mountain.mania.com_DTO.CDto;
import mountain.mania.com_DTO.MDto;
import mountain.mania.com_util.Constant;


public class SGDao {
	DataSource dataSource;
	JdbcTemplate template;

	public SGDao() {
		this.template=Constant.template;
		try {
			Context context = new InitialContext();
			Context envContext = (Context) context.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/mysql");
			//dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//모임리스트
	public ArrayList<SGDto> list(int page, int limit) {
		
		final int startrow=(page-1)*10; //읽기 시작할 row 번호.
	    final int endrow=startrow+limit; //읽을 마지막 row 번호. 
	    
		System.out.println("sg list다오 들어옴");
		//String sql="select * from small_group_list order by sg_id";
		//return (ArrayList<SGDto>) template.query(sql, new BeanPropertyRowMapper<SGDto>(SGDto.class));
		
		String sql="select * from small_group_list order by sg_id LIMIT ?,? ";
				
//				String sql="select * from big_group_list order by bg_id";
				return (ArrayList<SGDto>) template.query(sql, new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setInt(1, startrow);
						ps.setInt(2, endrow);
						
					}
					
				},new BeanPropertyRowMapper<SGDto>(SGDto.class));
			}
	
	//모임가입시 추가
	public void SGroup_add(final String u_id, final String sg_name,final String sg_intro) {

		System.out.println("SGroup_add다오 들어옴");

		int num;
		String sql0="select max(sg_id)as sg_id from small_group_list";//동호회리스트의 max값을 찾는 sql을 쓰고

		if(template.queryForObject(sql0,Integer.class) != null) {//그 값이 null이 아니라면 찾은 값에 +1을 해주고
			num=template.queryForObject(sql0,Integer.class)+1;
		}
		else {//null이라면 그 값을 1로 바꿔줘라
			num = 1;
		}

		System.out.println(num);


		//String sql="insert into big_group_list (bg_id, u_id,bg_name,bg_experience,bg_level,bg_intro) values ((select a.bg_id from (select max(bg_id)+1 as bg_id  from big_group_list)a),?,?,?) ";
		String sql="insert into small_group_list (sg_id, u_id,sg_name,sg_intro) values ("+num+",?,?,?) ";
		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, u_id);
				ps.setString(2, sg_name);
				ps.setString(3, sg_intro);				
			}	
		});

		//동호회 장이 개설하고나서 바로 회원 리스트에 들어가도록....모임은 한 아이디당 하나만 개설가능으로 조건을 줘야될꺼같음 (앞단에서)

		int num1;
		String sql3="select max(sgm_id)as sgm_id from small_group_member";

		if(template.queryForObject(sql3,Integer.class) != null) {
			num1=template.queryForObject(sql3,Integer.class)+1;
		}
		else {
			num1 = 1;
		}

		System.out.println(num1);

		String sql2="insert into small_group_member (sgm_id, sg_id, sg_name, u_id) values ("+num1+",(select sg_id from small_group_list where u_id=?),(select sg_name from small_group_list where u_id=?),?)";

		this.template.update(sql2, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,u_id);
				ps.setString(2,u_id);
				ps.setString(3,u_id);			
			}	
		});
	}
	//모임 상세보기
	public ArrayList<SGDto> Groupcontent(int sg_id) {

		String sql="select * from small_group_list where sg_id="+sg_id;
		return (ArrayList<SGDto>) template.query(sql, new BeanPropertyRowMapper<SGDto>(SGDto.class));
	}
	//모임 가입신청시 가입신청 테이블에 저장
	public void small_group_join(final int sg_id, final String u_id, final String sg_name) {
		int num;
		String sql0="select max(sgj_id)as sg_id from sg_join";//동호회리스트의 max값을 찾는 sql을 쓰고

		if(template.queryForObject(sql0,Integer.class) != null) {//그 값이 null이 아니라면 찾은 값에 +1을 해주고
			num=template.queryForObject(sql0,Integer.class)+1;
		}
		else {//null이라면 그 값을 1로 바꿔줘라
			num = 1;
		}

		System.out.println(num);
		String sql="insert into sg_join(sgj_id, sg_id, sg_name, u_id) values("+num+",?,?,?)";
		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1,sg_id);
				ps.setString(2,sg_name);
				ps.setString(3,u_id);

			}	
		});		

	}
	//좌측 메뉴에서 내가 신청한 모임가입신청내역 눌렀을때
	public ArrayList<SGJoinDto> sg_joinlist(final String u_id) {
		System.out.println("sg_joinlist 다오들어옴");
		String sql = "select * from sg_join where u_id=?";
		return (ArrayList<SGJoinDto>) template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setNString(1, u_id);
			}

		}, new BeanPropertyRowMapper<SGJoinDto>(SGJoinDto.class));

	}
	//모임장이 가입한 내역 볼때
	public ArrayList<SGJoinDto> mysg_joinlist(final String u_id) {
		String sql="select * from sg_join where sg_id=(select sg_id from small_group_list where u_id=?) and y_n is null";

		return (ArrayList<SGJoinDto>) template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setNString(1, u_id);
			}

		}, new BeanPropertyRowMapper<SGJoinDto>(SGJoinDto.class));
	}

	//모임장이 가입신청 승인했을 때, 멤버리스트에 추가 및 승인 여부 표시.
	public void Group_member_add(final int sg_id, final String u_id, final int sgj_id) {
		int num;
		String sql0="select max(sgm_id)as sgm_id from small_group_member";//모임리스트의 max값을 찾는 sql을 쓰고

		if(template.queryForObject(sql0,Integer.class) != null) {//그 값이 null이 아니라면 찾은 값에 +1을 해주고
			num=template.queryForObject(sql0,Integer.class)+1;
		}
		else {//null이라면 그 값을 1로 바꿔줘라
			num = 1;
		}

		System.out.println(num);

		String sql="insert into small_group_member(sgm_id, sg_id, sg_name, u_id) values("+num+",?,(select sg_name from small_group_list where sg_id=? ),?)";
		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1,sg_id);
				ps.setInt(2,sg_id);
				ps.setString(3,u_id);


			}	
		});

		String sql1="update sg_join set y_n= 'Y', note = '가입이 승인되었습니다.' where sgj_id=? ";
		this.template.update(sql1, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, sgj_id);
			}				
		});

		//			//sg_join테이블에 위의 업데이트 쿼리 후 where u_id=? and y_n is null 로 조회하여 해당 로우는 y_n= n, note= '이미 다른 모임에 가입되었습니다 '로 업데이트
		//			
		//			
		//			String sql2="update sg_join set y_n= 'N', note = '이미 다른 모임에 가입이 되어있습니다.' where u_id=? and y_n is null ";
		//			this.template.update(sql2, new PreparedStatementSetter() {
		//
		//				@Override
		//				public void setValues(PreparedStatement ps) throws SQLException {
		//					// TODO Auto-generated method stub
		//					ps.setString(1, u_id);
		//				}				
		//			});

	}

	//모임장이 거절을 눌렀을 때
	public void sg_no_add(final int sgj_id) {
		String sql="update sg_join set y_n= 'N', note = '모임장이 가입을 거절하였습니다.' where sgj_id=? ";
		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, sgj_id);
			}				
		});

	}
	//가입한 모임 보기
	public ArrayList<SGDto> join_bg_list(final String u_id) {
		//String sql="select * from small_group_list where sg_id=(select sg_id from small_group_member where u_id=?)";
		//서브쿼리에서는 답이 하나만 나와야됨...
		String sql="SELECT r.* FROM small_group_list AS r, small_group_member AS c WHERE r.sg_id = c.sg_id and c.u_id=?";
		return (ArrayList<SGDto>) template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,u_id);							
			}							
		}, new BeanPropertyRowMapper<SGDto>(SGDto.class));

	}
	//모임 탈퇴할때
	public void delete_sg_group(final String u_id, final int sg_id) {
		String sql = "delete from small_group_member where u_id = ? and sg_id=?";

		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, u_id);
				ps.setInt(2, sg_id);
			}

		});

	}
	//내 모임 멤버리스트 보기
	public ArrayList<SGMDto> sg_member_list(final String u_id) {
		String sql ="select * from small_group_member where sg_id=(select sg_id from small_group_list where u_id=?)";
		return (ArrayList<SGMDto>) template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, u_id);
			}

		}, new BeanPropertyRowMapper<SGMDto>(SGMDto.class));

	}

	//스케줄표 불러와질때 내가 속한 모임에 대한 내용만 볼 수 있도록..
	public ArrayList<SGSDto> bg_Schedule_select(final String u_id) {
		String sql = "SELECT r.* FROM sg_Scheduler AS r, small_group_member AS c WHERE r.sg_name = c.sg_name and c.u_id=?";
		return (ArrayList<SGSDto>) template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, u_id);

			}

		}, new BeanPropertyRowMapper<SGSDto>(SGSDto.class));
	}
	//스케줄 작성시 산이름들 불러오기
	public ArrayList<MDto> MountainList() {
		String sql="select * from mountain";
		return (ArrayList<MDto>) template.query(sql, new BeanPropertyRowMapper<MDto>(MDto.class));
	}

	//산이름 선택시 산코스 가져오기
	public ArrayList<CDto> mountaincourse(final int m_id) {
		String sql="select * from course where m_id = ?";
		return (ArrayList<CDto>) template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, m_id);
			}				
		}, new BeanPropertyRowMapper<CDto>(CDto.class));
	}

	//산이름 선택시 산이름 가져오기
	public ArrayList<MDto> mountain_name(final int m_id) {
		String sql="select * from mountain where m_id= ?";
		return (ArrayList<MDto>) template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, m_id);
			}				
		}, new BeanPropertyRowMapper<MDto>(MDto.class));
	}

	//일정등록 폼 작성후 일정등록하기 눌렀을때
	public void schedule_save(final int m_id, final int c_id, final String title, final String content, final String date, final String u_id) {
		int num;
		String sql0="select max(sgs_id)as sgs_id from sg_scheduler";//동호회리스트의 max값을 찾는 sql을 쓰고

		if(template.queryForObject(sql0,Integer.class) != null) {//그 값이 null이 아니라면 찾은 값에 +1을 해주고
			num=template.queryForObject(sql0,Integer.class)+1;
		}
		else {//null이라면 그 값을 1로 바꿔줘라
			num = 1;
		}

		System.out.println(num);
		String sql = "insert into sg_scheduler values("+num+",?,(select m_name from mountain where m_id=?),(select sg_name from small_group_list where u_id=?),(select c_level from course where c_id=?),?,?)";
		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {

				ps.setString(1, title);
				ps.setInt(2, m_id);
				ps.setString(3, u_id);
				ps.setInt(4, c_id);
				ps.setString(5, content);
				ps.setString(6, date);
			}

		});	

	}


	//스케줄러에서 title클릭시 상세내용
	public ArrayList<SGSDto> sg_Schedule_check(final int sgs_id, final String title) {
		String sql = "select * from sg_scheduler where sgs_id=? and sgs_title=?";
		return (ArrayList<SGSDto>) template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, sgs_id);
				ps.setString(2, title);
			}				
		}, new BeanPropertyRowMapper<SGSDto>(SGSDto.class));
	}
	//수정 완료시 업데이트
	public void schedule_update(final String m_name, final String c_name, final String title, final String content, final String date, final int sgs_id) {
		String sql="update sg_scheduler set sgs_title=?,m_name=?,c_name=?,content=?,sgs_date=? where sgs_id=?"; 
		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, title);
				ps.setString(2, m_name);
				ps.setString(3, c_name);
				ps.setString(4, content);
				ps.setString(5, date);
				ps.setInt(6, sgs_id);
			}

		});

	}
	//일정삭제
	public void sg_schedule_delete(final int sgs_id) {
		String sql="delete from sg_scheduler where sgs_id=?";
		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, sgs_id);

			}

		});

	}
	//모임 강퇴시
	public void sg_member_out(final int sg_id, final String u_id) {
		String sql="delete from small_group_member where sg_id=? and u_id=?";
		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, sg_id);
				ps.setString(2, u_id);
			}

		});

	}

	public boolean nav_check(String u_id) {
		String sql = "select count(u_id) as u_id from small_group_list where u_id=?";


		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,u_id);
			ResultSet rs = preparedStatement.executeQuery();

			rs.next();	

			System.out.println(rs.getString("u_id"));

			if(!(rs.getString("u_id").equals("0"))) {
				return true;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean check(String sg_name, String u_id) {
		String sql="select u_id from small_group_list where sg_id in (select sg_id from small_group_list where sg_name =?) and u_id=? ";
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,sg_name);
			preparedStatement.setString(2,u_id);
			ResultSet rs = preparedStatement.executeQuery();

			rs.next();				
			if(u_id.equals(rs.getString("u_id"))) {
				return true;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	//////////////////////////////////////////활동내역 ////////////////////////




	//활동내역 저장
	public void sg_active_save(final int m_id, final int sg_id, final int c_id, final int climb) {
		System.out.println("sg_active_save 다오 들어옴");

		int num;
		String sql0="select max(sa_id)as sa_id from sg_active";//동호회리스트의 max값을 찾는 sql을 쓰고

		if(template.queryForObject(sql0,Integer.class) != null) {//그 값이 null이 아니라면 찾은 값에 +1을 해주고
			num=template.queryForObject(sql0,Integer.class)+1;
		}
		else {//null이라면 그 값을 1로 바꿔줘라
			num = 1;
		}


		String sql = "insert into sg_active values("+num+",?,?,?,?)";

		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, sg_id);
				ps.setInt(2, m_id);
				ps.setInt(3, c_id);
				ps.setInt(4, climb);

			}

		});


	}

	//활동내역 리스트 보여줌 
	public ArrayList<SG_ADto> sg_active(final String u_id) {



		String sql="select c.m_name,a.sg_name,e.c_level "
				+ "from small_group_member a , sg_active b, mountain c, course e "
				+ "where a.sg_id=b.sg_id  "
				+ "and b.m_id=c.m_id "
				+ "and b.c_id=e.c_id "
				+ "and a.u_id=?";
		return (ArrayList<SG_ADto>) template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, u_id);

			}

		}, new BeanPropertyRowMapper<SG_ADto>(SG_ADto.class) );
	}
	//등산횟수
	public int s_climb(final String u_id) {



		System.out.println("s_climb 다오임"+u_id);

		int climb=0;

		String sql="select count(*)  as climb from sg_active a, small_group_member b where a.sg_id=b.sg_id and b.u_id=?";
		System.out.println(sql);
		climb=template.query(sql, new PreparedStatementSetter() { 

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {


				pstmt.setString(1, u_id);

			}
		}, new  SingleColumnRowMapper<Integer>(Integer.class)).get(0);


		System.out.println(climb);

		return climb;

	}

	public ArrayList<SGDto> Slist6() {
		// TODO Auto-generated method stub
		return null;
	}
	//소모임리스트 서치
	public ArrayList<SGDto> search(final String search) {
		String sql = "select * from small_group_list where sg_name like ?";
		return (ArrayList<SGDto>) template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,"%"+search+"%");
				
			}
			
		},new BeanPropertyRowMapper<SGDto>(SGDto.class));
	}

	public boolean sg_nameCheck(final String sg_name) {
		String sql= "select sg_name from small_group_list where sg_name =?";
		ArrayList<SGDto> sg_nameCheck = (ArrayList<SGDto>) template.query(sql,new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, sg_name);
				
			}
			
		},new BeanPropertyRowMapper<SGDto>(SGDto.class));
		
	
		for(int i=0;i<sg_nameCheck.size();i++) {
			String name=sg_nameCheck.get(i).getSg_name();
			
			if(name.trim().contains(sg_name)) {
				return false;
			}
	
	}
		return true;
	}

	public int count() {
		int count=0;
		String query = "select count(*) as count from small_group_list";//as count 컬럼 명 변경해줌
		return template.queryForObject(query, Integer.class);//답변을 Integer로 바꿔서 리턴해줌 기본타입과 레퍼타입은 서로 자유롭게 섞어 쓸 수 있다/낮은 버전에서는 안됨
	}











}
