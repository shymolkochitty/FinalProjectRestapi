package com.ust.dao;

import java.util.List;

import com.ust.model.VendorContact;

public interface IVendorContact {
	//INSERT//
	public abstract int insertVCDetails(VendorContact vendorContact);
	//VIEW//
	public abstract List<VendorContact> getAllDetails();
	//DISABLE//
	public abstract int disableVendor(int vId);
	//UPATE//
	public abstract int updateVCDetails(VendorContact vendorContact);
	//TO SEARCH//
	public abstract List<VendorContact> searchVDetails(String searchString);
	//FOR EDIT//
	public abstract VendorContact getVById(int vId);
	
	
	
	
}
