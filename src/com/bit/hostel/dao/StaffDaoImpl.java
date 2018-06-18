package com.bit.hostel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit.hostel.common.CommonSql;
import com.bit.hostel.model.Staff;

public class StaffDaoImpl extends CommonDao<Staff>{

	@Override
	public List<Staff> get() {
		List<Staff> list= new ArrayList<Staff>();
		Connection con = getConnection();
		try{
			PreparedStatement stmt = con.prepareStatement(CommonSql.STAFF_SQL);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Staff staff = new Staff();
				staff.setStaffId(rs.getInt(1));
				staff.setStaffname(rs.getString(2));
				staff.setContact(rs.getString(3));
				staff.setEmail(rs.getString(4));
				staff.setGender(rs.getString(5));
				staff.setDepartment(rs.getString(6));
				staff.setStafftype(rs.getString(7));
				staff.setDateofbirth(rs.getDate(8));
				staff.setUpdatedOn(rs.getDate(9));
				staff.setUpdatedby(rs.getString(10));				
				staff.setStatusenum(rs.getString(11));
				list.add(staff);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();	
		}finally{
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return list;
	}

	@Override
	public Staff get(int id) {
		Staff staff = null;
		Connection con = getConnection();
		try{
			PreparedStatement stmt = con.prepareStatement(CommonSql.STAFF_ID_SQL);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				staff = new Staff();
				staff.setStaffId(rs.getInt(1));
				staff.setStaffname(rs.getString(2));
				staff.setContact(rs.getString(3));
				staff.setEmail(rs.getString(4));
				staff.setGender(rs.getString(5));
				staff.setDepartment(rs.getString(6));
				staff.setStafftype(rs.getString(7));
				staff.setDateofbirth(rs.getDate(8));
				staff.setUpdatedOn(rs.getDate(9));
				staff.setUpdatedby(rs.getString(10));				
				staff.setStatusenum(rs.getString(11));
			}
			
		}catch(Exception ex){
			ex.printStackTrace();	
		}finally{
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return staff;
	}

	@Override
	public void saveOrUpdate(Staff staff) {

		Connection con = getConnection();
		try{
			PreparedStatement stmt = null;
			if(staff.getStaffId() == null || staff.getStaffId() == 0){
				stmt = con.prepareStatement(CommonSql.STAFF_SAVE_SQL);
				stmt.setString(1, staff.getStaffname());
				stmt.setString(2, staff.getContact());
				stmt.setString(3, staff.getEmail());
				stmt.setString(4, staff.getGender());
				stmt.setString(5, staff.getDepartment());
				stmt.setString(6, staff.getStafftype());
				stmt.setDate(7, new Date(new java.util.Date().getTime()));
				stmt.setString(8, staff.getUpdatedby());
				stmt.setString(9, staff.getStatusenum());
			} else {
				stmt = con.prepareStatement(CommonSql.STAFF_UPDATE_SQL);
				stmt.setString(1, staff.getStaffname());
				stmt.setString(2, staff.getContact());
				stmt.setString(3, staff.getEmail());
				stmt.setString(4, staff.getGender());
				stmt.setString(5, staff.getDepartment());
				stmt.setString(6, staff.getStafftype());
				stmt.setDate(7, new Date(new java.util.Date().getTime()));
				stmt.setString(8, staff.getUpdatedby());
				stmt.setString(9, staff.getStatusenum());
				stmt.setInt(10, staff.getStaffId());
			}
			
			stmt.executeUpdate();
			
		}catch(Exception ex){
			ex.printStackTrace();	
		}finally{
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}

	@Override
	public int delete(int id) {
		Connection con = getConnection();
		try{
			PreparedStatement stmt = con.prepareStatement(CommonSql.STAFF_DELETE_SQL);
			stmt.setInt(1, id);
			return stmt.executeUpdate();
			
		}catch(Exception ex){
			ex.printStackTrace();	
		}finally{
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return 0;
	}

	@Override
	public int delete(Staff obj) {
		// TODO Auto-generated method stub
		return 0;
	}}
