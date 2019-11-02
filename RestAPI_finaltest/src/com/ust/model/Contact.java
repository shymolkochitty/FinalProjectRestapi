package com.ust.model;

public class Contact {
	//variable declaration//
	
	private Integer cId ;
	private String cName ;
	private String cDept;
	private String cEmail;
	private Long cPhone ;
	private Integer vId ;
	
	//constructors//
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(Integer cId, String cName, String cDept, String cEmail, Long cPhone, Integer vId) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cDept = cDept;
		this.cEmail = cEmail;
		this.cPhone = cPhone;
		this.vId = vId;
	}

	
	//Getters and Setters//
	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcDept() {
		return cDept;
	}

	public void setcDept(String cDept) {
		this.cDept = cDept;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public Long getcPhone() {
		return cPhone;
	}

	public void setcPhone(Long cPhone) {
		this.cPhone = cPhone;
	}

	public Integer getvId() {
		return vId;
	}

	public void setvId(Integer vId) {
		this.vId = vId;
	}

	@Override
	public String toString() {
		return "Contact [cId=" + cId + ", cName=" + cName + ", cDept=" + cDept + ", cEmail=" + cEmail + ", cPhone="
				+ cPhone + ", vId=" + vId + "]";
	}
	
	
	
	

}
