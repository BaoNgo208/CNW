package model.dao;

import model.bean.PhongTro;
import model.bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class CheckLoginDAO {

	public CheckLoginDAO() {
		
	}
	

	
	public User getUser(String username , String password) throws ClassNotFoundException, SQLException {
		 User user = null ; 
			
		 Class.forName("com.mysql.jdbc.Driver");
			
		 String sql= "SELECT * FROM sinhvien WHERE name='" +username+"' AND id='" +password+"'";
		 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/dulieu", "root", "");
		 java.sql.Statement st = connection.createStatement();
		 ResultSet resultSet = st.executeQuery(sql);
		 while(resultSet.next()) {
			  user = new User (resultSet.getInt("ID"),resultSet.getString("name"));
		 }
		
		 
		 return user; 
	}
	public boolean isExistUser(String userName,String password) throws ClassNotFoundException, SQLException {
		//Database works
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String sql= "SELECT * FROM sinhvien WHERE name='" +userName+"' AND id='" +password+"'";
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/dulieu", "root", "");
	
			
		
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
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/dulieu", "root", "");
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
        			 resultSet.getInt("IdUser"),
					 resultSet.getInt("Status")
        	  );
        	  
        	  result.add(phongTro);
         }
			
		 
		 return result;
	}
	
	public ArrayList<User> getUsers(ArrayList<PhongTro> phongTros)throws ClassNotFoundException, SQLException{
		ArrayList<User> users = new ArrayList<User>();
		 Class.forName("com.mysql.jdbc.Driver");
			
		 String sql= "SELECT * FROM sinhvien "; 
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/dulieu", "root", "");
         java.sql.Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(sql);
		 ArrayList<User> matchUsers = new ArrayList<User>();
         
         while(resultSet.next()) {
        	 User user = new User(resultSet.getInt("ID"),resultSet.getString("name"));
        	  
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
			 
			 
	         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/dulieu?useUnicode=true&characterEncoding=UTF-8", "root", "");
	         java.sql.Statement statement = connection.createStatement();
	         statement.executeUpdate(sql);
		   
		   return phongTro;
	}
	
	public PhongTro getPhongTroById(Integer id) throws SQLException, ClassNotFoundException {
		  PhongTro phongTro = null;
		  ArrayList<PhongTro> phongTros = getPhongTroList();
		  for (PhongTro phongTro1 : phongTros)
		  {
			  if(Objects.equals(phongTro1.getId(), id))
			  {
				  return phongTro1;
			  }
		  }
		  return phongTro;
	}

	public void DuyetPhongTro(PhongTro phongtro)
	{
		try
		{
//            String url = "jdbc:mysql://localhost:3307/dulieu";
//            Connection con = DriverManager.getConnection(url, "root", "");
//            Statement stmt = con.createStatement();
//            String sql = "UPDATE admin SET ID='"+account.get_ID()+"', username='"+account.get_username()+"',password='"+account.get_password()+"'  WHERE id ='"+account.get_ID()+"'";
//            stmt.executeUpdate(sql);
//            stmt.close();
			String url = "jdbc:mysql://localhost:3307/dulieu";
			Connection con = DriverManager.getConnection(url, "root", "");
			PreparedStatement stmt = con.prepareStatement("UPDATE phongtro SET status = 1 WHERE id = ?");
			stmt.setString(1, String.valueOf(phongtro.getId()));

			stmt.executeUpdate();
			stmt.close();
		}
		catch(Exception f)
		{
			System.out.println("Error "+ f);
		}
	}

	public ArrayList<User> GetAllUser()
	{
		ArrayList<User> users = new ArrayList<>();
		try
		{
			String url = "jdbc:mysql://localhost:3307/dulieu";
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM admin";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String username = rs.getString("username");
				User user = new User(id,username);
				users.add(user);
			}
			rs.close();
//            stmt.executeUpdate(sql);
			stmt.close();
		}
		catch(Exception f)
		{
			System.out.println("Error "+ f);
		}
		return users;
	}


	public ArrayList<PhongTro> GetAllPost() throws ClassNotFoundException, SQLException {
		ArrayList<PhongTro> result = new ArrayList<PhongTro>();


		Class.forName("com.mysql.jdbc.Driver");

		String sql= "SELECT * FROM phongtro ";
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/dulieu", "root", "");
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
					resultSet.getInt("IdUser"),
					resultSet.getInt("Status")
			);
			if(phongTro.getState() == 1) {
				result.add(phongTro);
			}
		}

		return result;
	}

	public String GetUsernameByID(int id ){
		String name ="";
		ArrayList<User> users = GetAllUser();
		for(User user : users)
		{
			if(user.getId() == id)
			{
				return user.getName();
			}
		}
		return  name;
	}

	public void RemovePost(int id)
	{
		try
		{
			String url = "jdbc:mysql://localhost:3307/dulieu";
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement stmt = con.createStatement();
			String sql = "DELETE FROM phongtro WHERE Id = '"+id+"'";
			stmt.executeUpdate(sql);
			stmt.close();
		}
		catch(Exception f)
		{
			System.out.println("Error "+ f);
		}
	}
}
