package com.ust.model;

public class Vendor {

	//variable declaration//
	private Integer vId;//vendor id
	private String vName;//vendor name
	private String vAddr;//vendor address
	private String vLoc;//vendor location
	private String vSer;//services 
	private Double vPin;//pincode
	private String isActive;
	
	//constructor//
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vendor(Integer vId, String vName, String vAddr, String vLoc, String vSer, Double vPin, String isActive) {
		super();
		this.vId = vId;
		this.vName = vName;
		this.vAddr = vAddr;
		this.vLoc = vLoc;
		this.vSer = vSer;
		this.vPin = vPin;
		this.isActive = isActive;
	}

	//Getters & Setters//
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

	@Override
	public String toString() {
		return "Vendor [vId=" + vId + ", vName=" + vName + ", vAddr=" + vAddr + ", vLoc=" + vLoc + ", vSer=" + vSer
				+ ", vPin=" + vPin + ", isActive=" + isActive + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
