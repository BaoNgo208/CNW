package model.bo;

import model.bean.PhongTro;
import model.bean.User;
import model.dao.CheckLoginDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CheckLoginBO {
	CheckLoginDAO checkLoginDAO = new CheckLoginDAO();
	public CheckLoginBO() {
		// TODO Auto-generated constructor stub
	}
	public boolean isValidUser(String userName,String password) throws ClassNotFoundException, SQLException {
		 return checkLoginDAO.isExistUser(userName,password);
	}
	

	
	public ArrayList<PhongTro> getPhongTroList() throws ClassNotFoundException, SQLException {
		 return checkLoginDAO.getPhongTroList();
	}
	
	public ArrayList<User> getUserList() throws ClassNotFoundException, SQLException {
		ArrayList<PhongTro> phongTros= getPhongTroList();
		 return checkLoginDAO.getUsers(phongTros);
	}
	
	public User getUser(String username,String password) throws ClassNotFoundException, SQLException {
			User user = checkLoginDAO.getUser(username, password);
			return user;
	}
	public PhongTro addPhongTro(PhongTro phongTro) throws ClassNotFoundException, SQLException {
		  phongTro = checkLoginDAO.addPhongTro(phongTro);
		  return phongTro;
	}
	
	public void Duyet(PhongTro phongTro) { checkLoginDAO.DuyetPhongTro(phongTro);}

	public PhongTro GetPhongTroByID(int id ) throws SQLException, ClassNotFoundException {return checkLoginDAO.getPhongTroById(id);}
	public ArrayList<User> GetAllUser() {return checkLoginDAO.GetAllUser();}
	public ArrayList<PhongTro> GetAllPost() throws SQLException, ClassNotFoundException {return checkLoginDAO.GetAllPost();}
	public String GetUsernameByID(int id) {return  checkLoginDAO.GetUsernameByID(id);}
	public void RemovePost(int id) {checkLoginDAO.RemovePost(id);}
}
