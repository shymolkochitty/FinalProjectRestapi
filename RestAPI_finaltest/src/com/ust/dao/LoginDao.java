package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.model.Login;



public class LoginDao implements ILoginDao{
//setting jdbc template
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template){
		this.template=template;
	}
	
	//.............select................//
	
	public List<Login>getAllDetails(){
		return template.query("select id,username,password,roleid from tbl_login order by id desc",
				new RowMapper<Login>(){
			    public Login mapRow(ResultSet rs,int row) throws SQLException{
			    	Login login=new Login();
			    	login.setId(rs.getLong(1));
			    	login.setUsername(rs.getString(2));
			    	login.setPassword(rs.getString(3));
			    	login.setRoleid(rs.getLong(4));
			    	
			    	return login;
			    }
		});
		
	}
		
		///.....select(get) by name///
		
		public Login searchUserDetails(String username,String password){
			
			String sql="select id,username,password,roleid  from tbl_login where username=? and password=?";
					return template.queryForObject(sql, new Object[]{username,password},
							new BeanPropertyRowMapper<Login>(Login.class));
				}
			
		///......select by id...//
	public Login getUserById(int id){
		String sql="select id,username,password,roleid  from tbl_login  where id=?";
		return template.queryForObject(sql, new Object[]{id },
					new BeanPropertyRowMapper<Login>(Login.class));
			
	}		
		
		//insert...//
	public int insertUserDetails(Login login){
		String sqlOne="insert into tbl_login(username,password,roleid )values('"+login.getUsername()+"','"+login.getPassword()+"',"+login.getRoleid()+")";
		return template.update(sqlOne);
		
		
	}
	
	
	
	//update//
	public  int updateUserDetails(Login login){
		
		String sqlOne="update  tbl_login set username='"+login.getUsername()+"',password= ' "+login.getPassword()+" ',roleid= "+login.getRoleid()+" where id=?";
		return template.update(sqlOne,new Object[]{login.getId() });
		
	}
	
//	//delete//
//	public int disableUser(int id){
//		String sql="update  tbl_user set isActive='no' where uId=?";
//		return template.update(sql,new Object[]{uId});
//		
		
		
	}
	
	
	
	
	
	
	
	
	
		
			
			
			
			
	
	
	

