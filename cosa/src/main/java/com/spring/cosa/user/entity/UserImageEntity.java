package com.spring.cosa.user.entity;

public class UserImageEntity {
	private int i_image;
	private String file_type;
	private String file_name;
	private byte[] file_data;
	private String r_dt;
	private int i_user;
	
	public int getI_image() {
		return i_image;
	}
	public void setI_image(int i_image) {
		this.i_image = i_image;
	}
	public String getFile_type() {
		return file_type;
	}
	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public byte[] getFile_data() {
		return file_data;
	}
	public void setFile_data(byte[] file_data) {
		this.file_data = file_data;
	}
	public String getR_dt() {
		return r_dt;
	}
	public void setR_dt(String r_dt) {
		this.r_dt = r_dt;
	}
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	
	
}
