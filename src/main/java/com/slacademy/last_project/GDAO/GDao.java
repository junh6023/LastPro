package com.slacademy.last_project.GDAO;

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

import com.slacademy.last_project.GDTO.BG_ADto;

import com.slacademy.last_project.GDTO.GDto;
import com.slacademy.last_project.GDTO.GJoinDto;
import com.slacademy.last_project.GDTO.GMDto;
import com.slacademy.last_project.GDTO.GSDto;

import mountain.mania.com_DTO.CDto;
import mountain.mania.com_DTO.MDto;
import mountain.mania.com_util.Constant;


public class GDao {
	DataSource dataSource;
	JdbcTemplate template;


	public GDao() {
		this.template = Constant.template;
		try {
			Context context = new InitialContext();
			Context envContext = (Context) context.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/mysql");
			//dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/////////////////////////////////////////////////동호회////////////////////////////////////////////////////////



	//동호회 리스트 조회
	public ArrayList<GDto> list(int page, int limit) {
		final int startrow=(page-1)*10; //읽기 시작할 row 번호.
	    final int endrow=startrow+limit; //읽을 마지막 row 번호.
		System.out.println("startrow: "+ startrow + "endrow: " +endrow);
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
				+ " end as bg_level, bg_intro, bg_date from big_group_list order by bg_id LIMIT ?,? ";
		
//		String sql="select * from big_group_list order by bg_id";
		return (ArrayList<GDto>) template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, startrow);
				ps.setInt(2, endrow);
				
			}
			
		},new BeanPropertyRowMapper<GDto>(GDto.class));
	}

	//동호회 생성
	public void Group_add(final String u_id, final String bg_name, final String bg_intro) {
		// TODO Auto-generated method stub
		

		int num;
		String sql0="select max(bg_id)as bg_id from big_group_list";//동호회리스트의 max값을 찾는 sql을 쓰고
		if(template.queryForObject(sql0,Integer.class) != null) {//그 값이 null이 아니라면 찾은 값에 +1을 해주고
			
			num=template.queryForObject(sql0,Integer.class)+1;
			
		}else {//null이라면 그 값을 1로 바꿔줘라
			num = 1;
		}

		


		//String sql="insert into big_group_list (bg_id, u_id,bg_name,bg_experience,bg_level,bg_intro) values ((select a.bg_id from (select max(bg_id)+1 as bg_id  from big_group_list)a),?,?,0,0,?) ";
		String sql="insert into big_group_list (bg_id, u_id,bg_name,bg_experience,bg_level,bg_intro) values ("+num+",?,?,0,0,?) ";
		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, u_id);
				ps.setString(2, bg_name);
				ps.setString(3, bg_intro);				
			}	
		});

		//동호회 장이 개설하고나서 바로 회원 리스트에 들어가도록....모임은 한 아이디당 하나만 개설가능으로 조건을 줘야될꺼같음 (앞단에서)

		int num1;
		String sql3="select max(bgm_id)as bgm_id from big_group_member";

		if(template.queryForObject(sql3,Integer.class) != null) {
			num1=template.queryForObject(sql3,Integer.class)+1;
		}
		else {
			num1 = 1;
		}

	
		String sql2="insert into big_group_member (bgm_id, bg_id, bg_name, u_id, u_experience,u_level) values ("+num1+",(select bg_id from big_group_list where u_id=?),(select bg_name from big_group_list where u_id=?),?,(select u_experience from users where u_id=?),(select u_level from users where u_id=?))";

		this.template.update(sql2, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,u_id);
				ps.setString(2,u_id);
				ps.setString(3,u_id);	
				ps.setString(4,u_id);
				ps.setString(5,u_id);
			}	
		});
	}
	//동호회리스트에서 제목 클릭시 상세페이지 보여주는 기능
	public ArrayList<GDto> Groupcontent(int bg_id) {
		// TODO Auto-generated method stub

		String sql="select * from big_group_list where bg_id="+bg_id;
		return (ArrayList<GDto>) template.query(sql, new BeanPropertyRowMapper<GDto>(GDto.class));
	}

	//동호회 가입하기 눌렀을 때 승인 받아야하니까 임시테이블이 insert
	public void big_group_join(final int bg_id, final String u_id,final String bg_name) {
		int num;
		String sql0="select max(bgj_id)as bg_id from bg_join";//동호회리스트의 max값을 찾는 sql을 쓰고

		if(template.queryForObject(sql0,Integer.class) != null) {//그 값이 null이 아니라면 찾은 값에 +1을 해주고
			num=template.queryForObject(sql0,Integer.class)+1;
		}
		else {//null이라면 그 값을 1로 바꿔줘라
			num = 1;
		}

		
		String sql="insert into bg_join(bgj_id, bg_id, bg_name, u_id, u_experience, u_level) values("+num+",?,?,?,(select u_experience from users where u_id=?),(select u_level from users where u_id=?))";
		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1,bg_id);
				ps.setString(2,bg_name);
				ps.setString(3,u_id);
				ps.setString(4,u_id);	
				ps.setString(5,u_id);

			}	
		});		
	}

	//내가 신청한 동호회 가입내역 
	public ArrayList<GJoinDto> bg_joinlist(final String u_id) {
		
		String sql = "select * from bg_join where u_id=?";
		return (ArrayList<GJoinDto>) template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setNString(1, u_id);
			}

		}, new BeanPropertyRowMapper<GJoinDto>(GJoinDto.class));

	}


	//동호회장이 가입내역 볼때
	public ArrayList<GJoinDto> mybg_joinlist(final String u_id){

		String sql="select * from bg_join where bg_id=(select bg_id from big_group_list where u_id=?) and y_n is null";

		return (ArrayList<GJoinDto>) template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setNString(1, u_id);
			}

		}, new BeanPropertyRowMapper<GJoinDto>(GJoinDto.class));
	}


	//동호회장이 가입신청 승인했을 때, 멤버리스트에 추가 및 승인 여부 표시.
	public void Group_member_add(final int bg_id, final String u_id, final int bgj_id) {
		int num;
		String sql0="select max(bgm_id)as bgm_id from big_group_member";//동호회리스트의 max값을 찾는 sql을 쓰고

		if(template.queryForObject(sql0,Integer.class) != null) {//그 값이 null이 아니라면 찾은 값에 +1을 해주고
			num=template.queryForObject(sql0,Integer.class)+1;
		}
		else {//null이라면 그 값을 1로 바꿔줘라
			num = 1;
		}



		String sql="insert into big_group_member(bgm_id, bg_id, bg_name, u_id, u_experience, u_level) values("+num+",?,(select bg_name from big_group_list where bg_id=? ),?,(select u_experience from users where u_id=?),(select u_level from users where u_id=?))";
		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1,bg_id);
				ps.setInt(2,bg_id);
				ps.setString(3,u_id);
				ps.setString(4,u_id);	
				ps.setString(5,u_id);

			}	
		});

		String sql1="update bg_join set y_n= 'Y', note = '가입이 승인되었습니다.' where bgj_id=? ";
		this.template.update(sql1, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, bgj_id);
			}				
		});

		//bg_join테이블에 위의 업데이트 쿼리 후 where u_id=? and y_n is null 로 조회하여 해당 로우는 y_n= n, note= '이미 다른 모임에 가입되었습니다 '로 업데이트


		String sql2="update bg_join set y_n= 'N', note = '이미 다른 모임에 가입이 되어있습니다.' where u_id=? and y_n is null ";
		this.template.update(sql2, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, u_id);
			}				
		});


		//			String sql1="delete from bg_join where u_id=?";
		//			this.template.update(sql1, new PreparedStatementSetter() {
		//
		//				@Override
		//				public void setValues(PreparedStatement ps) throws SQLException {
		//					// TODO Auto-generated method stub
		//					ps.setString(1, u_id);
		//				}
		//				
		//			});			
	}

	//동호회장이 거절을 눌렀을때
	public void bg_no_add(final int bgj_id) {
		String sql="update bg_join set y_n= 'N', note = '동호회장이 가입을 거절하였습니다.' where bgj_id=? ";
		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, bgj_id);
			}				
		});

	}

	//내가 가입한 동호회리스트 뽑아내기
	public ArrayList<GDto> join_bg_list(final String u_id) {

		String sql="select bg_id, bg_name, u_id,bg_experience, bg_level, bg_intro, bg_date, bg_rank "
				+ "from (select bg_id, bg_name, u_id, bg_experience, bg_level, bg_intro, bg_date, row_number() over (order by bg_experience desc) as bg_rank from big_group_list)a "
				+ "where bg_id=(select bg_id from big_group_member where u_id=?)";
		return (ArrayList<GDto>) template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,u_id);							
			}							
		}, new BeanPropertyRowMapper<GDto>(GDto.class));

	}

	//bg_랭킹보기 눌렀을때
	public ArrayList<GDto> bg_rank(int page, int limit) {


		final int startrow=(page-1)*30; //읽기 시작할 row 번호.
	    final int endrow=startrow+limit; //읽을 마지막 row 번호.
		
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
				+ " end as bg_level, bg_intro, bg_date, row_number() over (order by bg_experience desc) as bg_rank from big_group_list LIMIT "+startrow+","+endrow ;

		return (ArrayList<GDto>) template.query(sql, new BeanPropertyRowMapper<GDto>(GDto.class));
	}


	//동호회 탈퇴하기 눌렀을 때
	public void delete_bg_group(final String u_id, final int bg_id) {
		String sql = "delete from big_group_member where u_id = ? and bg_id=?";

		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, u_id);
				ps.setInt(2, bg_id);
			}

		});

	}

	//내 동호회 멤버리스트 확인
	public ArrayList<GMDto> bg_member_list(final String u_id) {

		String sql ="select * from big_group_member where bg_id=(select bg_id from big_group_list where u_id=?)";
		return (ArrayList<GMDto>) template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, u_id);
			}

		}, new BeanPropertyRowMapper<GMDto>(GMDto.class));


	}
	
	//스케줄표 불러와질때 내가 속한 동호회/모임에 대한 내용만 볼 수 있도록..
			public ArrayList<GSDto> bg_Schedule_select(final String u_id) {
				
				String sql = "select * from bg_Scheduler where bg_name in (select bg_name from big_group_member where u_id=?)";
				return (ArrayList<GSDto>) template.query(sql, new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setString(1, u_id);
						
					}
					
				}, new BeanPropertyRowMapper<GSDto>(GSDto.class));
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
				String sql0="select max(bgs_id)as bgs_id from bg_scheduler";//동호회리스트의 max값을 찾는 sql을 쓰고

				if(template.queryForObject(sql0,Integer.class) != null) {//그 값이 null이 아니라면 찾은 값에 +1을 해주고
					num=template.queryForObject(sql0,Integer.class)+1;
			      }
			      else {//null이라면 그 값을 1로 바꿔줘라
			         num = 1;
			      }
				
				
				String sql = "insert into bg_scheduler values("+num+",?,(select m_name from mountain where m_id=?),(select bg_name from big_group_list where u_id=?),(select c_level from course where c_id=?),?,?)";
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
			public ArrayList<GSDto> bg_Schedule_check(final int bgs_id, final String title) {
				String sql = "select * from bg_scheduler where bgs_id=? and bgs_title=?";
				return (ArrayList<GSDto>) template.query(sql, new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setInt(1, bgs_id);
						ps.setString(2, title);
					}				
				}, new BeanPropertyRowMapper<GSDto>(GSDto.class));
			}



			public void schedule_update(final String m_name, final String c_name, final String title, final String content, final String date,
					final int bgs_id) {
				String sql="update bg_scheduler set bgs_title=?,m_name=?,c_name=?,content=?,bgs_date=? where bgs_id=?"; 
				this.template.update(sql, new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						// TODO Auto-generated method stub
						ps.setString(1, title);
						ps.setString(2, m_name);
						ps.setString(3, c_name);
						ps.setString(4, content);
						ps.setString(5, date);
						ps.setInt(6, bgs_id);
					}
					
				});
			
			}


			//일정 삭제시
			public void bg_schedule_delete(final int bgs_id) {
				String sql="delete from bg_scheduler where bgs_id=?";
				this.template.update(sql, new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setInt(1, bgs_id);
						
					}
					
				});
				
			}


			//동호회멤버 강퇴시
			public void bg_member_out(final int bg_id, final String u_id) {
				String sql="delete from big_group_member where bg_id=? and u_id=?";
				this.template.update(sql, new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setInt(1, bg_id);
						ps.setString(2, u_id);
					}
					
				});
			}


			//동호회장 판별하기 
			public boolean nav_check(String u_id) {
				String sql = "select count(u_id) as u_id from big_group_list where u_id=?";

				
				try {
					Connection connection = dataSource.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1,u_id);
					ResultSet rs = preparedStatement.executeQuery();
					
					rs.next();	
					
					
					if(!(rs.getString("u_id").equals("0"))) {
						return true;
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				return false;
			}


			//1인1동호회 가입/생성 가능
			public boolean Create_bg_check(String u_id) {
				String sql = "select u_id from big_group_member where u_id=?";

				
				try {
					Connection connection = dataSource.getConnection();
					
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1,u_id);
					ResultSet rs = preparedStatement.executeQuery();
					
					rs.next();				
					if(u_id.equals(rs.getString("u_id"))) {
						return false;
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				return true;
			}



			public boolean check(String bg_name, String u_id) {
				String sql="select u_id from big_group_list where bg_id in (select bg_id from big_group_list where bg_name =?) and u_id=? ";
				try {
					Connection connection = dataSource.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1,bg_name);
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



			public boolean small_nav_check(String u_id) {
				String sql = "select count(u_id) as u_id from small_group_list where u_id=?";
				try {
					Connection connection = dataSource.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1,u_id);
					ResultSet rs = preparedStatement.executeQuery();
					
					rs.next();	
					if(!(rs.getString("u_id").equals("0"))) {
						return true;
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				return false;
			}



			public ArrayList search(final String search) {
				String sql="select bg_id, bg_name, u_id,bg_experience,"
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
						+ " end as bg_level, bg_intro, bg_date, bg_rank from (select bg_id, bg_name, u_id,bg_experience, bg_level, bg_intro, bg_date, row_number() over (order by bg_experience desc) as bg_rank from big_group_list)a where bg_name like ? ";

				return (ArrayList<GDto>) template.query(sql,new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						// TODO Auto-generated method stub
						ps.setString(1,"%"+search+"%");
					}
					
				}, new BeanPropertyRowMapper<GDto>(GDto.class));
			}





			/////////////////////////////////////활동내역/////////////////////////////////

		
		//활동내역 저장
		public void bg_active_save(final int m_id, final int bg_id, final int c_id, final float bg_experience, final int climb) {
			
			
			int num;
			String sql0="select max(ba_id)as bgs_id from bg_active";//동호회리스트의 max값을 찾는 sql을 쓰고

			if(template.queryForObject(sql0,Integer.class) != null) {//그 값이 null이 아니라면 찾은 값에 +1을 해주고
				num=template.queryForObject(sql0,Integer.class)+1;
		      }
		      else {//null이라면 그 값을 1로 바꿔줘라
		         num = 1;
		      }

			
			String sql = "insert into bg_active values("+num+",?,?,?,?,?)";
			
			this.template.update(sql, new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, bg_id);
					ps.setInt(2, m_id);
					ps.setInt(3, c_id);
					ps.setFloat(4, bg_experience);
					ps.setInt(5, climb);
					
				}
				
			});
			
			bg_update(bg_id);
			
		}

		//활동내역 추가되면 바로 동호회 경험치 업뎃
		private void bg_update(final int bg_id) {
			
			String sql="update big_group_list,(select sum(bg_experience) as bg_experiences from bg_active )b set bg_experience=b.bg_experiences where bg_id=?";
			this.template.update(sql,new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, bg_id);					
				}
				
			});

			
		
		}
		//활동내역 리스트 보여줌 -> 이름으로 보여줘야됨 ㅋ 이건 생각좀 ....
		public ArrayList<BG_ADto> bg_active(final String u_id) {
			String sql="select c.m_name,d.bg_name,e.c_level,b.bg_experience \r\n"
					+ "from big_group_member a , bg_active b, mountain c, big_group_list d, course e\r\n"
					+ "where a.bg_id=b.bg_id \r\n"
					+ "and b.m_id=c.m_id \r\n"
					+ "and a.bg_id=d.bg_id \r\n"
					+ "and b.c_id=e.c_id \r\n"
					+ "and a.u_id=?";
			return (ArrayList<BG_ADto>) template.query(sql, new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, u_id);
					
				}
				
			}, new BeanPropertyRowMapper<BG_ADto>(BG_ADto.class) );
			
		
		}
			
	



		public int climb(final String u_id) {
			
			int climb=0;
			
			String sql="select count(*) as climb from bg_active a, big_group_member b where a.bg_id=b.bg_id and b.u_id=?";
			
			climb=template.query(sql, new PreparedStatementSetter() { 

		         @Override
		      public void setValues(PreparedStatement pstmt) throws SQLException {


		            pstmt.setString(1, u_id);
		            
		         }
		      }, new  SingleColumnRowMapper<Integer>(Integer.class)).get(0);
		        
		        
		   
		        
		        return climb;
		}



		public int count() {
			int count=0;
			String query = "select count(*) as count from big_group_list";//as count 컬럼 명 변경해줌
			return template.queryForObject(query, Integer.class);//답변을 Integer로 바꿔서 리턴해줌 기본타입과 레퍼타입은 서로 자유롭게 섞어 쓸 수 있다/낮은 버전에서는 안됨
		}


		//이름 있는지 확인
		public boolean bg_nameCheck(final String bg_name) {
			String sql= "select bg_name from big_group_list where bg_name =?";
			ArrayList<GDto> bg_nameCheck = (ArrayList<GDto>) template.query(sql,new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, bg_name);
					
				}
				
			},new BeanPropertyRowMapper<GDto>(GDto.class));
			
		
			for(int i=0;i<bg_nameCheck.size();i++) {
				String name=bg_nameCheck.get(i).getBg_name();
				
				if(name.trim().contains(bg_name)) {
					return false;
				}
		
		}
			return true;
		}



		public ArrayList<GDto> bg_rank2(int page, int limit) {
			final int startrow=(page-1)*10; //읽기 시작할 row 번호.
		    final int endrow=startrow+limit; //읽을 마지막 row 번호.
			
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
					+ " end as bg_level, bg_intro, bg_date, row_number() over (order by bg_experience desc) as bg_rank from big_group_list LIMIT "+startrow+","+endrow ;

			return (ArrayList<GDto>) template.query(sql, new BeanPropertyRowMapper<GDto>(GDto.class));
		}
		}



















	//이건 나중에.....

	//		//big_group_active테이블이 추가?업데이트? 됬을 때, big_group_list의 경험치와 레벨도 함께 업데이트 되야한다.
	//		public void bg_update (final int bgj_id,final int bg_id,final String m_id,final String c_id,final String bga_title,final float bg_experience,final int bg_level) {
	//			String sql="insert into big_group_active values(?,?,?,?,?,?,?)";
	//			this.template.update(sql, new PreparedStatementSetter() {
	//
	//				@Override
	//				public void setValues(PreparedStatement ps) throws SQLException {
	//					// TODO Auto-generated method stub
	//						ps.setInt(1, bgj_id);
	//						ps.setInt(2, bg_id);
	//						ps.setString(3, m_id);
	//						ps.setString(4, c_id);
	//						ps.setString(5, bga_title);
	//						ps.setFloat(6, bg_experience);
	//						ps.setInt(7, bg_level);
	//				}				
	//			});
	//			
	//			String sql1="update big_group_list set bg_experience=(select a.bg_experience from (select bg_experience + ? as bg_experience  from big_group_list)a) bg_level=? where  =?";
	//			
	//			
	//		}











