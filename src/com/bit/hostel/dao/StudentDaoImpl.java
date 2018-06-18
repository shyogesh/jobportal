package com.bit.hostel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bit.hostel.common.CommonSql;
import com.bit.hostel.model.Student;

public class StudentDaoImpl extends CommonDao<Student>{

	

	@Override
	public List<Student> get() {
		List<Student> list= new ArrayList<Student>();
		Connection con = getConnection();
		try{
			PreparedStatement stmt = con.prepareStatement(CommonSql. STUDENT_SQL);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				int columnCounter =1;
				student.setSID(rs.getInt(columnCounter++));
				student.setFirstName(rs.getString(columnCounter++));
				student.setLastName(rs.getString(columnCounter++));
				student.setsBranch(rs.getString(columnCounter++));
				student.setsMobile(rs.getString(columnCounter++));
				student.setsGender(rs.getString(columnCounter++));
				student.setsRollNo(rs.getString(columnCounter++));
				student.setsEmail(rs.getString(columnCounter++));
				student.setsAddressP(rs.getString(columnCounter++));
				student.setsAddressP(rs.getString(columnCounter++));
				student.setsCity(rs.getString(columnCounter++));
				student.setsState(rs.getString(columnCounter++));
				student.setsDOB(rs.getDate(columnCounter++));
				student.setS10Th(rs.getString(columnCounter++));
				student.setS12Th(rs.getString(columnCounter++));
				student.setsDeploma(rs.getString(columnCounter++));
				student.setsPercent(rs.getString(columnCounter++));
				student.setsJee(rs.getString(columnCounter++));
				student.setsDirect(rs.getString(columnCounter++));
				student.setFatherName(rs.getString(columnCounter++));
				student.setMotherName(rs.getString(columnCounter++));
				student.setFatherContact(rs.getString(columnCounter++));
				student.setMotherContact(rs.getString(columnCounter++));
				student.setsYear(rs.getString(columnCounter++));
				student.setsEnum(rs.getString(columnCounter++));
				student.setUpdatedOn(rs.getDate(columnCounter++));
				student.setUpdatedBy(rs.getString(columnCounter++));
				
				list.add(student);
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
	public Student get(int id) {
		Student student = null;
		Connection con = getConnection();
		try{
			PreparedStatement stmt = con.prepareStatement(CommonSql. STUDENT_ID_SQL);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				student = new Student();
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
		return student;
	}

	@Override
	public void saveOrUpdate(Student student) {
		
		Connection con = getConnection();
		try{
			PreparedStatement stmt = null;
			if(student.getSID() == null || student.getSID() == 0){
				stmt = con.prepareStatement(CommonSql. STUDENT_SAVE_SQL);
			} else {
				stmt = con.prepareStatement(CommonSql. STUDENT_UPDATE_SQL);
				
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
			PreparedStatement stmt = con.prepareStatement(CommonSql. STUDENT_DELETE_SQL);
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
	public int delete(Student obj) {
		// TODO Auto-generated method stub
		return 0;
	}}
