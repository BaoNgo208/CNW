package model.bean;

public class User {
	private Integer Id;
	private String name;
	public User(Integer id, String name) {
		super();
		this.Id = id;
		this.name = name;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}

}
