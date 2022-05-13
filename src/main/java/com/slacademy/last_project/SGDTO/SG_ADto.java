package com.slacademy.last_project.SGDTO;

public class SG_ADto {
	 private int sa_id ; 
	 private int sg_id ;
	 private int m_id ;
	 private  int c_id ;
	 private int climb ;
	 private String sg_name ;
	 private String m_name ;
	 private String c_level ;
	 
	 
	
	public String getSg_name() {
		return sg_name;
	}
	public void setSg_name(String sg_name) {
		this.sg_name = sg_name;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}


	public String getC_level() {
		return c_level;
	}
	public void setC_level(String c_level) {
		this.c_level = c_level;
	}
	public int getSa_id() {
		return sa_id;
	}
	public void setSa_id(int sa_id) {
		this.sa_id = sa_id;
	}
	public int getSg_id() {
		return sg_id;
	}
	public void setSg_id(int sg_id) {
		this.sg_id = sg_id;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public int getClimb() {
		return climb;
	}
	public void setClimb(int climb) {
		this.climb = climb;
	}
	 
	 
}
