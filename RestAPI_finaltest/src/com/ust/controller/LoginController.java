package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.ILoginDao;
import com.ust.model.Login;

@CrossOrigin
@RestController
@RequestMapping("/api")

public class LoginController {
	@Autowired
	private ILoginDao dao;

	// ............select.........//

	// get all users///

	@RequestMapping(value = "/userdetails", method = RequestMethod.GET)
	public List getUserDetails() {
		List list;
		System.out.println("get all details");
		list = dao.getAllDetails();
		return list;

	}

	// get by Name//

	@RequestMapping(value = "/userdetails/{username}/{password}", method = RequestMethod.GET)
	public Login getUserDetails(@PathVariable(value = "username") String username,
			@PathVariable(value = "password") String password) {
		System.out.println("get a single user details");
		Login login = (Login) dao.searchUserDetails(username, password);
		return login;

	}

	// get by id//
	@RequestMapping(value = "/userbyid/{id}", method = RequestMethod.GET)
	public Login getUserById(@PathVariable("id") int id) {

		Login login = dao.getUserById(id);
		return login;

	}

	// insert///

	@RequestMapping(value = "/insertuser", method = RequestMethod.POST)
	public void insertDetails(@RequestBody Login login) {
		dao.insertUserDetails(login);
	}

	// update//

	@RequestMapping(value = "/updateuser", method = RequestMethod.PUT)
	public void updateDetails(@RequestBody Login login) {
		dao.updateUserDetails(login);

	}

	// //delete//
	// //disabling not deleting
	// @RequestMapping(value="/disableuser/{uId}" ,method=RequestMethod.PUT)
	// public void disableUser(@PathVariable("uId") int uId){
	// dao.disableUser(uId);
	//
	// }

}
