package com.app.sys.vo;

import org.apache.poi.hssf.record.cf.IconMultiStateFormatting;
import org.springframework.web.multipart.MultipartFile;
public class addNewVO {
	private String User_ID;
	private String Hostname;
	private String Housename;
	private String Address_state;
	private String Type;
	private String Rent;
	private String Rent_or_rm;
	private String Notes;
	private String Address_spec;
	private String Address_city;
	private String Address;
	private String Pic_one;
	private String Pic_two;
	private String Pic_three;
	private MultipartFile Pic_one_file;
	private MultipartFile Pic_two_file;
	private MultipartFile Pic_three_file;
	public String getHostname() {
		return Hostname;
	}
	public void setHostname(String hostname) {
		Hostname = hostname;
	}
	public String getHousename() {
		return Housename;
	}
	public void setHousename(String housename) {
		Housename = housename;
	}
	public String getAddress_state() {
		return Address_state;
	}
	public void setAddress_state(String address_state) {
		Address_state = address_state;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getRent() {
		return Rent;
	}
	public void setRent(String rent) {
		Rent = rent;
	}
	public String getRent_or_rm() {
		return Rent_or_rm;
	}
	public void setRent_or_rm(String rent_or_rm) {
		Rent_or_rm = rent_or_rm;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public String getAddress_city() {
		return Address_city;
	}
	public void setAddress_city(String address_city) {
		Address_city = address_city;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPic_one() {
		return Pic_one;
	}
	public void setPic_one(String pic_one) {
		Pic_one = pic_one;
	}
	public String getPic_two() {
		return Pic_two;
	}
	public void setPic_two(String pic_two) {
		Pic_two = pic_two;
	}
	public String getPic_three() {
		return Pic_three;
	}
	public void setPic_three(String pic_three) {
		Pic_three = pic_three;
	}
	public String getAddress_spec() {
		return Address_spec;
	}
	public void setAddress_spec(String address_spec) {
		Address_spec = address_spec;
	}
	public String getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(String user_ID) {
		User_ID = user_ID;
	}
	public MultipartFile getPic_one_file() {
		return Pic_one_file;
	}
	public void setPic_one_file(MultipartFile pic_one_file) {
		Pic_one_file = pic_one_file;
	}
	public MultipartFile getPic_two_file() {
		return Pic_two_file;
	}
	public void setPic_two_file(MultipartFile pic_two_file) {
		Pic_two_file = pic_two_file;
	}
	public MultipartFile getPic_three_file() {
		return Pic_three_file;
	}
	public void setPic_three_file(MultipartFile pic_three_file) {
		Pic_three_file = pic_three_file;
	}

	
	
}