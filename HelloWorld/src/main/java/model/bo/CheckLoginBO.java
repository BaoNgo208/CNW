package model.bo;
import model.bean.*;
import model.dao.*;

import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.jasper.runtime.HttpJspBase;
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
	public PhongTro getPhongTroById(Integer id)throws ClassNotFoundException, SQLException {
		 return checkLoginDAO.getPhongTroById(id);
	}
	public User getUserByPhongTroIdUser(Integer id) throws ClassNotFoundException, SQLException {
		 return checkLoginDAO.getUserByPhongTroIdUser(id);
	}
	public ArrayList<PhongTro>getPhongTrosByIdUse(Integer IdUser) throws ClassNotFoundException, SQLException {
		 return checkLoginDAO.getPhongTrosByIdUser(IdUser);
	}
	public Integer DeletePhongTroById(Integer id) throws ClassNotFoundException, SQLException {
		return checkLoginDAO.DeletePhongTroById(id);
	}
	public PhongTro editPhongTro(PhongTro phongTro) throws SQLException, ClassNotFoundException {
		 return checkLoginDAO.editPhongTro(phongTro);
	}
	public ArrayList<PhongTro> getPhongTroBySearchBar(String searchResult) throws SQLException, ClassNotFoundException {
		return checkLoginDAO.getPhongTroBySearchBar(searchResult);
	}

}
