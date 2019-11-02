package com.ust.model;

public class VendorContact {
	//variable declaration//
	private Integer vId;//vendor id
	private String vName;//vendor name
	private String vAddr;//vendor address
	private String vLoc;//vendor location
	private String vSer;//services 
	private Double vPin; //pincode
	private String isActive;
	private Integer cId ;//contact id
	private String cName ;//contact person name
	private String cDept;//person's dept
	private String cEmail;//person's email id
	private Long cPhone ;//person's phone no
	
	//Constructors//
	public VendorContact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VendorContact(Integer vId, String vName, String vAddr, String vLoc, String vSer, Double vPin,
			String isActive, Integer cId, String cName, String cDept, String cEmail, Long cPhone) {
		super();
		this.vId = vId;
		this.vName = vName;
		this.vAddr = vAddr;
		this.vLoc = vLoc;
		this.vSer = vSer;
		this.vPin = vPin;
		this.isActive = isActive;
		this.cId = cId;
		this.cName = cName;
		this.cDept = cDept;
		this.cEmail = cEmail;
		this.cPhone = cPhone;
	}

	public Integer getvId() {
		return vId;
	}

	public void setvId(Integer vId) {
		this.vId = vId;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

	public String getvAddr() {
		return vAddr;
	}

	public void setvAddr(String vAddr) {
		this.vAddr = vAddr;
	}

	public String getvLoc() {
		return vLoc;
	}

	public void setvLoc(String vLoc) {
		this.vLoc = vLoc;
	}

	public String getvSer() {
		return vSer;
	}

	public void setvSer(String vSer) {
		this.vSer = vSer;
	}

	public Double getvPin() {
		return vPin;
	}

	public void setvPin(Double vPin) {
		this.vPin = vPin;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

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

	@Override
	public String toString() {
		return "VendorContact [vId=" + vId + ", vName=" + vName + ", vAddr=" + vAddr + ", vLoc=" + vLoc + ", vSer="
				+ vSer + ", vPin=" + vPin + ", isActive=" + isActive + ", cId=" + cId + ", cName=" + cName
				+ ", cDept=" + cDept + ", cEmail=" + cEmail + ", cPhone=" + cPhone + "]";
	}
	
	
	
	
	

}
