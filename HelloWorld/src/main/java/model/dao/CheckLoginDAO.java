package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

import model.bean.*;
import model.dao.*;

public class CheckLoginDAO {

	public CheckLoginDAO() {
		
	}
	

	
	public User getUser(String username , String password) throws ClassNotFoundException, SQLException {
		 User user = null ; 
			
		 Class.forName("com.mysql.jdbc.Driver");
			
		 String sql= "SELECT * FROM SINHVIEN WHERE name='" +username+"' AND id='" +password+"'"; 
		 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu", "root", "");
		 java.sql.Statement st = connection.createStatement();
		 ResultSet resultSet = st.executeQuery(sql);
		 while(resultSet.next()) {
			  user = new User (resultSet.getInt("id"),resultSet.getString("name"));
		 }
		
		 
		 return user; 
	}
	public boolean isExistUser(String userName,String password) throws ClassNotFoundException, SQLException {
		//Database works
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String sql= "SELECT * FROM SINHVIEN WHERE name='" +userName+"' AND id='" +password+"'"; 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu", "root", "");
	
			
		
		    java.sql.Statement st = connection.createStatement();
		    ResultSet resultSet = st.executeQuery(sql);
		    if(resultSet.next()) {
		    	 return true;
		    }
		    else {
		    	 return false;
		    }
		
	
	
	}
	public ArrayList<PhongTro>getPhongTroList() throws ClassNotFoundException, SQLException {
		 ArrayList<PhongTro> result = new ArrayList<PhongTro>();
		 
			
	     Class.forName("com.mysql.jdbc.Driver");
		
		 String sql= "SELECT * FROM phongtro "; 
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HoTroTimTro", "root", "");
         java.sql.Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(sql);
         
         while(resultSet.next()) {
        	  PhongTro phongTro = new PhongTro(
        			 resultSet.getInt("Id"),
        			 resultSet.getString("Img"),
        			 resultSet.getString("TieuDe"),
        			 resultSet.getInt("DienTich"),
        			 resultSet.getInt("Gia"),
        			 resultSet.getString("DiaChi"),
        			 resultSet.getString("Quan"),
        			 resultSet.getInt("IdUser")
        	  );
        	  
        	  result.add(phongTro);
         }
			
		 
		 return result;
	}
	
	public ArrayList<User> getUsers(ArrayList<PhongTro> phongTros)throws ClassNotFoundException, SQLException{
		ArrayList<User> users = new ArrayList<User>();
		 Class.forName("com.mysql.jdbc.Driver");
			
		 String sql= "SELECT * FROM sinhvien "; 
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu", "root", "");
         java.sql.Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(sql);
		 ArrayList<User> matchUsers = new ArrayList<User>();
         
         while(resultSet.next()) {
        	 User user = new User(resultSet.getInt("Id"),resultSet.getString("name"));
        	  
        	  users.add(user);
         }
			
		
		for(int i = 0 ;i<phongTros.size();i++) {
			for(int j = 0  ; j <users.size();j ++) {
				 if(phongTros.get(i).getIdUser() == users.get(j).getId() ) {
					   	matchUsers.add(users.get(j));
				  }
			}
			 
		}
		
		return matchUsers;
	}
	
	
	public PhongTro addPhongTro(PhongTro phongTro) throws ClassNotFoundException, SQLException{
		 
		   
			
		     Class.forName("com.mysql.jdbc.Driver");
		 	
	
			 String sql= "INSERT INTO phongtro (Img, TieuDe,DienTich,Gia,DiaChi,Quan,IdUser) VALUES ('"+phongTro.getImg()+"'"
			 		+ ", '"+phongTro.getTieuDe()+"'"
			 				+ ", '"+phongTro.getDienTich()+"', '"+phongTro.getGia()+"',"
			 						+ " '"+phongTro.getDiaChi()+"' , '"+phongTro.getQuan()+"', '"+phongTro.getIdUser()+"' ) "; 
			 
			 
	         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HoTroTimTro", "root", "");
	         java.sql.Statement statement = connection.createStatement();
	         statement.executeUpdate(sql);
		   
		   return phongTro;
	}
	
	public PhongTro getPhongTroById(Integer id) {
		  PhongTro phongTro = null;
		  
		  return phongTro;
	}

}
