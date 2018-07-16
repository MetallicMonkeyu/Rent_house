package com.app.sys.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.app.sys.model.SysLogin;
import com.app.sys.model.Sysuserinfo;
import com.app.sys.model.addnewModle;
import com.app.sys.model.SysUserLogin;
import com.app.sys.vo.addNewVO;
import com.app.sys.vo.loginVO;
import com.app.util.page.PageUtil;
import com.app.util.string.StringUtil;

import ch.qos.logback.classic.spi.LoggingEventVO;

import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class addNewDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<addnewModle> queryHousedao(addNewVO addNewVO) {
			String sql = "select * from addnew where User_ID=:User_ID ";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(addNewVO);
		
		return namedParameterJdbcTemplate.query(sql, parameterSource,  new BeanPropertyRowMapper(addnewModle.class));
		
	}
	public List<addnewModle> findtypedao(addNewVO addNewVO) {
	
	String sql = "select * from addnew where Rent_or_rm=:Rent_or_rm ";
	NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(addNewVO);
	
	return namedParameterJdbcTemplate.query(sql, parameterSource,  new BeanPropertyRowMapper(addnewModle.class));
	
}
	public int addNew(addNewVO addNewVO) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into addnew(Hostname, Housename, Address_state, Type, Rent,Rent_or_rm, Notes, Address_city, Address_spec,User_ID,Pic_one,Pic_two,Pic_three)";
		sql += " values(:Hostname, :Housename, :Address_state, :Type, :Rent,:Rent_or_rm, :Notes, :Address_city, :Address,:User_ID,:Pic_one,:Pic_two,:Pic_three)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(addNewVO);
		
			return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	public String sql(addNewVO addNewVO) {
		String sql = "";
		if(StringUtil.isNotNullOrEmpty(addNewVO.getHostname())){
			sql += " and Hostname = :Hostname ";
		}
		if(StringUtil.isNotNullOrEmpty(addNewVO.getHousename())){
			sql += " and Housename = :Housename ";
		}
		if(StringUtil.isNotNullOrEmpty(addNewVO.getAddress_state())){
			sql += " and Address_state = :Address_state ";
		}
		if(StringUtil.isNotNullOrEmpty(addNewVO.getType())){
			sql += " and Type = :Type ";
		}
		if(StringUtil.isNotNullOrEmpty(addNewVO.getRent())){
			sql += " and Rent = :Rent ";
		}
		if(StringUtil.isNotNullOrEmpty(addNewVO.getRent_or_rm())){
			sql += " and Rent_or_rm = :Rent_or_rm ";
		}
		if(StringUtil.isNotNullOrEmpty(addNewVO.getAddress_city())){
			sql += " and Address_city = :Address_city ";
		}
		if(StringUtil.isNotNullOrEmpty(addNewVO.getAddress_spec())){
			sql += " and Address_spec = :Address_spec ";
		}
		if(StringUtil.isNotNullOrEmpty(addNewVO.getUser_ID())){
			sql += " and User_ID = :User_ID ";
		}
		sql = " and Notes = :Notes" +" and Pic_one = :Pic_one"+" and Pic_two = :Pic_two"+ " and Pic_three = :Pic_three";
		return sql;
	}
	
}
