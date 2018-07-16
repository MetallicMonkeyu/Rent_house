package com.app.sys.vo;

import org.apache.poi.hssf.record.cf.IconMultiStateFormatting;

import java.util.HashMap;
/**
注册
 */
public class RegVO {

	private String User_ID;
	private String Username;
	private String User_password;
	private String Real_Name;
	private int Age;
	private String Gender;
	private String Email;
	private String Portrait;
	
	
	public String getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(String user_ID) {
		User_ID = user_ID;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getUser_password() {
		return User_password;
	}
	public void setUser_password(String user_password) {
		User_password = user_password;
	}
	public String getReal_Name() {
		return Real_Name;
	}
	public void setReal_Name(String real_Name) {
		Real_Name = real_Name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPortrait() {
		return Portrait;
	}
	public void setPortrait(String portrait) {
		Portrait = portrait;
	}
	

}