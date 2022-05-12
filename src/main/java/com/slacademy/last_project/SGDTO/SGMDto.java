package com.slacademy.last_project.SGDTO;

import java.sql.Timestamp;

public class SGMDto {

	private int sgm_id;
	private int sg_id;
	private String sg_name;
	private String u_id;
	private Timestamp sgm_date;
	public int getSgm_id() {
		return sgm_id;
	}
	public void setSgm_id(int sgm_id) {
		this.sgm_id = sgm_id;
	}
	public int getSg_id() {
		return sg_id;
	}
	public void setSg_id(int sg_id) {
		this.sg_id = sg_id;
	}
	public String getSg_name() {
		return sg_name;
	}
	public void setSg_name(String sg_name) {
		this.sg_name = sg_name;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public Timestamp getSgm_date() {
		return sgm_date;
	}
	public void setSgm_date(Timestamp sgm_date) {
		this.sgm_date = sgm_date;
	}
	
	
}
