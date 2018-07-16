package com.app.sys.vo;

import org.apache.poi.hssf.record.cf.IconMultiStateFormatting;

import com.mysql.jdbc.PingTarget;

/**
 * 前台登录
 */
public class loginVO {

//	private String Username;
//	private String User_ID;
//	private String User_password;
//	private String Email;
//	public String getUsername() {
//		return Username;
//	}
//	public void setUsername(String username) {
//		Username = username;
//	}
//	public String getUser_password() {
//		return User_password;
//	}
//	public void setUser_password(String user_password) {
//		User_password = user_password;
//	}
//	public String getEmail() {
//		return Email;
//	}
//	public void setEmail(String email) {
//		Email = email;
//	}
//	public String getUser_ID() {
//		return User_ID;
//	}
//	public void setUser_ID(String user_ID) {
//		User_ID = user_ID;
//	}

	private static String User_ID;
	private String Username;
	private String User_password;
	private String Email;
	private String Gender;
	private String Wechat_ID;
	private String Classof;
	private String Phone_number;
	private String Portrait;

	public  String getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(String user_ID) {
		User_ID = user_ID;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getWechat_ID() {
		return Wechat_ID;
	}
	public void setWechat_ID(String wechat_ID) {
		Wechat_ID = wechat_ID;
	}
	public String getClassof() {
		return Classof;
	}
	public void setClassof(String classof) {
		Classof = classof;
	}
	public String getPhone_number() {
		return Phone_number;
	}
	public void setPhone_number(String phone_number) {
		Phone_number = phone_number;
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