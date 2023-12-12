package model.bean;

import java.security.KeyStore.PrivateKeyEntry;

public class PhongTro {
	private String Img;
	private Integer Id;
	private String TieuDe;
	private Integer DienTich;
	private Integer Gia;
	private String Quan;
	private String DiaChi;
	private String MoTa;
	private Integer IdUser;

	public String getMoTa() {
		return MoTa;
	}

	public void setMoTa(String moTa) {
		MoTa = moTa;
	}

	public PhongTro( Integer id ,String img, String tieuDe, Integer dienTich, Integer gia,  String diaChi, String quan, String moTa,
			Integer idUser) {
		super();
		Img = img;
		Id = id;
		TieuDe = tieuDe;
		DienTich = dienTich;
		Gia = gia;
		Quan = quan;
		DiaChi = diaChi;
		MoTa = moTa;
		IdUser = idUser;
	}

	public PhongTro(String img, String tieuDe, Integer dienTich, Integer gia, String diaChi,String quan,String moTa) {
		super();
		Img = img;
		TieuDe = tieuDe;
		DienTich = dienTich;
		Gia = gia;
		DiaChi = diaChi;
		Quan = quan;
		MoTa = moTa;
	}

	public PhongTro(String img, String tieuDe, Integer dienTich, Integer gia,  String diaChi, String quan,String moTa,
			Integer idUser) {
		super();
		Img = img;
	
		TieuDe = tieuDe;
		DienTich = dienTich;
		Gia = gia;
		Quan = quan;
		DiaChi = diaChi;
		IdUser = idUser;
		MoTa = moTa;
	}

	public Integer getIdUser() {
		return IdUser;
	}

	public void setIdUser(Integer idUser) {
		IdUser = idUser;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getImg() {
		return Img;
	}

	public void setImg(String img) {
		Img = img;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getTieuDe() {
		return TieuDe;
	}

	public void setTieuDe(String tieuDe) {
		TieuDe = tieuDe;
	}

	public Integer getDienTich() {
		return DienTich;
	}

	public void setDienTich(Integer dienTich) {
		DienTich = dienTich;
	}

	public Integer getGia() {
		return Gia;
	}

	public void setGia(Integer gia) {
		Gia = gia;
	}

	public String getQuan() {
		return Quan;
	}

	public void setQuan(String quan) {
		Quan = quan;
	}

	public PhongTro() {
		// TODO Auto-generated constructor stub
	}

}
