package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.IVendorContact;

import com.ust.model.VendorContact;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class VendorContactController {

	@Autowired
	private IVendorContact dao;

	// ............select(to view all details of vendor and contact).....//

	@RequestMapping(value = "/vcdetails", method = RequestMethod.GET)
	public List getVCDetails() {
		List list;
		System.out.println("get all details of vendor and contact person");
		list = dao.getAllDetails();

		return list;

	}

	// ..............get details by id......................//

	@RequestMapping(value = "/vcbyid/{vId}", method = RequestMethod.GET)
	public VendorContact getVById(@PathVariable("vId") int vId) {
		VendorContact vendorContact = dao.getVById(vId);
		return vendorContact;
	}

	// .......To disable vendor....................//

	@RequestMapping(value = "/disablev/{vId}", method = RequestMethod.PUT)
	void disableVendor(@PathVariable("vId") int vId) {
		dao.disableVendor(vId);
	}

	// ........insert........//

	@RequestMapping(value = "/insertvdetails", method = RequestMethod.POST)
	public void insertVendorContactDetails(@RequestBody VendorContact vendorContact) {
		dao.insertVCDetails(vendorContact);
	}

	// ......update.......//

	@RequestMapping(value = "/updatevdetails/{vId}", method = RequestMethod.PUT)
	public void updateDetails(@RequestBody VendorContact vendorContact) {

		dao.updateVCDetails(vendorContact);
	}
	// ....search......//

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/vdetails/{searchString}", method = RequestMethod.GET)
	public List getVendorDetails(@PathVariable("searchString") String searchString) {
		List list;
		if (searchString.equals("null")) {
			list = dao.getAllDetails();
		} else {
			list = dao.searchVDetails(searchString);
		}
		return list;
	}

}
