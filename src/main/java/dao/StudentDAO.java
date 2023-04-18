package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.DeleteBean;
import beans.LoginBean;
import beans.RegisterBean;
import beans.SetIdBean;
import beans.UpdateBean;
import beans.ViewBean;

public class StudentDAO {
	
	public boolean loginverify(LoginBean lb) {
		boolean flag =false;
		System.out.println("Login Verify........");
		try {
		   Connection conn =DBConnection.getConnection();
		   System.out.println("Conn.  Succcess ......"+conn);
		   PreparedStatement ps = conn.prepareStatement("select * from student_login where username=? and password=?");
		   ps.setString(1,lb.getUsername());
		   ps.setString(2,lb.getPassword());
		   ResultSet rs = ps.executeQuery();
		   if(rs.next()) {
			   System.out.println("if .."+rs.getString("username"));
			   System.out.println("if .."+rs.getString("password"));
			   flag = true;
			   ps.close();
			   return flag;
		   }
			
		} catch (Exception e) {
		   e.printStackTrace();
		}
		return flag;
	}
    // Register..................................
	
	public boolean studentRegister(RegisterBean rb) {
		boolean flag =false;
		int x=0;
		System.out.println("Reg Verify........");
		try {
		   Connection conn =DBConnection.getConnection();
		   System.out.println("Conn.  Succcess ......"+conn);
		   PreparedStatement ps = conn.prepareStatement("insert into student_reg values(?,?,?,?,?,?,?,?)");
		   ps.setInt(1, rb.getId());
		   ps.setString(2,rb.getName());
		   ps.setString(3,rb.getEmail());
		   ps.setString(4,rb.getAddress());
		   ps.setString(5,rb.getDob());
		   ps.setString(6,rb.getGender());
		   ps.setLong(7, rb.getMobno());
		   ps.setInt(8, rb.getMarks());
		   x = ps.executeUpdate();
		   ps.close();
		   if(x != 0) {
			   PreparedStatement ps1 = conn.prepareStatement("insert into student_login values(?,?,?)");
			   ps1.setInt(1, rb.getId());
			   ps1.setString(2,rb.getUsername());
			   ps1.setString(3,rb.getPassword());
			   int x1 = ps1.executeUpdate();
			   if(x1 != 0)
			   { flag = true;
			     System.out.println("Insert into Success ");
				   return flag;
			   }
			    
		   }
			
		} catch (Exception e) {
		   e.printStackTrace();
		}
		return flag;
	}
   // Get Records By Id 
	
   public  RegisterBean getById(SetIdBean sid) {
	   
	   RegisterBean rb = null;
	   System.out.println("Get By id .......");
		try {
		   Connection conn =DBConnection.getConnection();
		   System.out.println("Conn.  Succcess ......"+conn);
		   PreparedStatement ps = conn.prepareStatement("select * from student_reg where id=?");
		   ps.setInt(1,sid.getUserid());
		   ResultSet rs = ps.executeQuery();
		   if(rs.next()) {
			  rb= new RegisterBean();
			  rb.setId(rs.getInt(1));
			  rb.setName(rs.getString(2));
			  rb.setEmail(rs.getString(3));
			  rb.setAddress(rs.getString(4));
			  rb.setDob(rs.getString(5));
			  rb.setGender(rs.getString(6));
			  rb.setMobno(rs.getLong(7));
			  rb.setMarks(rs.getInt(8));
			  
			  System.out.println("The value is seted in Bean class success........ ");
			  return rb;
		  
		   }
			
		} catch (Exception e) {
		   e.printStackTrace();
		}
	   
	   
	   return rb;
   }
   
   //Update ............
   public boolean studentUpdate(UpdateBean rb) {
		boolean flag =false;
		int x=0;
		System.out.println("student Update ........");
		try {
		   Connection conn =DBConnection.getConnection();
		   System.out.println("Conn.  Succcess ......"+conn);
		   PreparedStatement ps = conn.prepareStatement("update student_reg set name=?,email=?,address=?,dob=?,gender=?,mob=?,marks=? where id=?");
	       ps.setString(1,rb.getName());
		   ps.setString(2,rb.getEmail());
		   ps.setString(3,rb.getAddress());
		   ps.setString(4,rb.getDob());
		   ps.setString(5,rb.getGender());
		   ps.setLong(6, rb.getMobno());
		   ps.setInt(7, rb.getMarks());
		   ps.setInt(8, rb.getId());
		   x = ps.executeUpdate();
		   ps.close();
		   if(x != 0) {
			   
			   flag = true;
			   System.out.println("Update Success........... ");
			   return flag;
			}
			
		} catch (Exception e) {
		   e.printStackTrace();
		}
		return flag;
	}
   //Delete   By Id  ............................
   public boolean deleteStudentRecords(DeleteBean delid) {
		boolean flag =false;
		System.out.println("Login Verify........");
		try {
		   Connection conn =DBConnection.getConnection();
		   System.out.println("Conn.  Succcess ......"+conn);
		   PreparedStatement ps = conn.prepareStatement("delete from student_reg where id=?");
		   ps.setInt(1,delid.getUserid());
		   int x =  ps.executeUpdate();
		   ps.close();
		   if(x!=0) {
			   flag = true;
			   System.out.println("Del success .................");
			   return flag;
		   }
			
		} catch (Exception e) {
		   e.printStackTrace();
		}
		return flag;
	}
	
   public List<ViewBean> getAllRecords() {
		List<ViewBean> al= new ArrayList<ViewBean>();
		System.out.println("Get all Records ........");
		try {
		   Connection conn =DBConnection.getConnection();
		   System.out.println("Conn.  Succcess ......"+conn);
		   PreparedStatement ps = conn.prepareStatement("select * from student_reg");
		   ResultSet rs =  ps.executeQuery();
		   
		   while(rs.next()) {
			 ViewBean vb = new ViewBean(); 
			 vb.setId(rs.getInt(1));
			 vb.setName(rs.getString(2));
			 vb.setEmail(rs.getString(3));
			 vb.setAddress(rs.getString(4));
			 vb.setDob(rs.getString(5));
			 vb.setGender(rs.getString(6));
			 vb.setMobno(rs.getLong(7));
			 vb.setMarks(rs.getInt(8));
			 al.add(vb);
		   }
		   System.out.println("Success.......... ");
		   
			
		} catch (Exception e) {
		   e.printStackTrace();
		}
		
		return al;
	}
	
	
}
