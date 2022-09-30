package com.epidata.prueba.domain;

public class ComplementInfo {
	
	private int id;
	private float temp;
	private String orgCode;
	
	public ComplementInfo(int id, float temp, String orgCode) {
		super();
		this.id = id;
		this.temp = temp;
		this.orgCode = orgCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

}
