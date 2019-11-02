package com.ust.dao;

import java.util.List;

import com.ust.model.Login;

public interface ILoginDao {

	//select operation//
	public abstract List<Login>getAllDetails();
	public abstract Login searchUserDetails(String username,String password);
	public abstract Login getUserById(int id);
	
//insert op//	
	
	public abstract int insertUserDetails(Login login);
	
	
//update op//	
	public abstract int updateUserDetails(Login login);

//delete op//	

		//public abstract int disableUser(int id);


	
	
	
	
	
}
