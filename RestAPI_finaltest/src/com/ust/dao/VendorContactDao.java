package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.model.VendorContact;

public class VendorContactDao implements IVendorContact{
	
//....................SETTING JDBC TEMPLATE...............................//
			JdbcTemplate template;
			public void setTemplate(JdbcTemplate template) {
			this.template = template;
			}
	
//...............INSERT VENDOR AND CONTACT DETAILS........................//
	
	@Override
	public int insertVCDetails(VendorContact vendorContact) {
			
		//........inserting into vendor table..........// 
		
		String sql="insert into vendor(vName,vAddr,vLoc,vSer, "
				+ "vPin,isActive) values('"+
				vendorContact.getvName()+"','"+
				vendorContact.getvAddr()+"','"+
				vendorContact.getvLoc()+"','"+
				vendorContact.getvSer()+"',"+
				vendorContact.getvPin()+",'y') ";
		template.update(sql);
		
		
		//........get maximum of vid from vendor table............//
		Integer maxVId=getMaxOfVendorId();
			System.out.println(maxVId);
		
	
		//..........inserting into contact table..........//
	
	String sqlOne="insert into contact(cName,cDept,cEmail,cPhone,vId) "
			+ "values('"+vendorContact.getcName()+"','"+
			vendorContact.getcDept()+"','"+
			vendorContact.getcEmail()+"','"+
			vendorContact.getcPhone()+"',? )";
	return template.update(sqlOne,new Object[] {maxVId});		
		
	
	

	}

//to get the maximum value of vendor id from vendor table
		private Integer getMaxOfVendorId() {
			
			String sql = "select MAX(vId)from vendor";
			Integer id = template.queryForObject(sql, new Object[] {}, Integer.class);
			return id;
		}


	
//........................ TO VIEW BOTH VENDOR AND CONTACT DETAILS.....................................// 
	@Override
	public List<VendorContact> getAllDetails() {
		return template.query("select v.vId,v.vName,v.vLoc,v.vSer,c.cName,"
    			+ "c.cDept,c.cPhone from Vendor v join Contact c"
    			+ " on(v.vId=c.vId) where isActive='y' order by v.vId desc",
						new RowMapper<VendorContact>() {
							public VendorContact mapRow(ResultSet rs, int row)
									throws SQLException {
								VendorContact vendorContact = new VendorContact();
								vendorContact.setvId(rs.getInt(1));
								vendorContact.setvName(rs.getString(2));
								vendorContact.setvLoc(rs.getString(3));
								vendorContact.setvSer(rs.getString(4));
								vendorContact.setcName(rs.getString(5));
								vendorContact.setcDept(rs.getString(6));
								vendorContact.setcPhone(rs.getLong(7));
								System.out.println("details"+vendorContact);
								return vendorContact;
							}
						});
	}
	
	
	
	

//............................TO DISABLE VENDOR...........................//
	@Override
	public int disableVendor(int vId) {
		String sql = "update Vendor set isActive='n' where vId=?";
		return template.update(sql,new Object[] { vId });
	}

//.............................UPDATE BOTH VENDOR AND CONTACT.............//
	
	@Override
	public int updateVCDetails(VendorContact vendorContact) {
		//update vendor//
    	String sql="update Vendor set vName='"+vendorContact.getvName()
    			      +"',vAddr='"+vendorContact.getvAddr()+"',vLoc='"
    			      +vendorContact.getvLoc()+"',vSer='"
    			      +vendorContact.getvSer()+"',vPin="+
    			      vendorContact.getvPin()+" where vId=?";
    	template.update(sql,new Object[] {vendorContact.getvId()});
    	//update contact//
    	String sqlc="update Contact set cName='"+vendorContact.getcName()
	      +"',cDept='"+vendorContact.getcDept()
	      +"',cEmail='"+vendorContact.getcEmail()+"',cPhone='"
	      +vendorContact.getcPhone()+"' where vId=?";

    	return template.update(sqlc,new Object[] {vendorContact.getvId()});
    	
    	
    	
	}
	
	//...............to view after search based on name, location,services...............//

	@Override
	public List<VendorContact> searchVDetails(String searchString) {
		return template.query("select v.vId,v.vName,v.vLoc,v.vSer,c.cName,"
    			+ "c.cDept,c.cPhone from vendor v join contact c"
    			+ " on(v.vId=c.vId) where isActive='y' and v.vName='"+searchString
    			+"' or v.vLoc='"+searchString+"' or v.vSer='"+searchString+"'",
						new RowMapper<VendorContact>() {
							public VendorContact mapRow(ResultSet rs, int row)
									throws SQLException {
								VendorContact  vendorContact = new VendorContact();
								vendorContact.setvId(rs.getInt(1));
								vendorContact.setvName(rs.getString(2));
								vendorContact.setvLoc(rs.getString(3));
								vendorContact.setvSer(rs.getString(4));
								vendorContact.setcName(rs.getString(5));
								vendorContact.setcDept(rs.getString(6));
								vendorContact.setcPhone(rs.getLong(7));
								return vendorContact;
							}
						});
	}

	
//..............................TO GET DETAILS..............................//	
	@Override
	public VendorContact getVById(int vId) {
		String sql = "select v.vId,v.vName,v.vLoc,v.vSer,v.vAddr,v.vPin,c.cId,c.cName,"
				+ "c.cDept,c.cPhone,c.cEmail from Vendor v join Contact c"
				+ " on(v.vId=c.vId) where isActive='y' and v.vId=?";
		return template.queryForObject(sql, new Object[] {vId},
				new BeanPropertyRowMapper<VendorContact>(VendorContact.class));
	
	}

	
	
	
	
}
