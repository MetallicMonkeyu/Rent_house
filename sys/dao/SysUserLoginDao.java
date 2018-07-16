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
import com.app.sys.model.SysUser;
import com.app.sys.model.SysUserLogin;
import com.app.sys.model.Sysuserinfo;
import com.app.sys.vo.loginVO;
import com.app.util.page.PageUtil;
import com.app.util.string.StringUtil;

import ch.qos.logback.classic.spi.LoggingEventVO;
//login, register database control
@Repository
public class SysUserLoginDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int add(Sysuserinfo sysuserinfo) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into t_sys_user(Username, User_password, Email)";
		sql += " values(:Username,:User_password,:Email)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(sysuserinfo);
		
			return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	public int update(Sysuserinfo sysuserinfo) {
		String sql = "update t_sys_user set Wechat_ID=:Wechat_ID,Gender=:Gender,Classof=:Classof,Phone_number=:Phone_number where User_ID=:User_ID";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(sysuserinfo);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	public int updateHead(Sysuserinfo sysuserinfo) {
		String sql = "update t_sys_user set Portrait=:Portrait where User_ID=:User_ID";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(sysuserinfo);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	public List<Sysuserinfo> checkLogindao(loginVO loginVO) {
		String sql = "select * from t_sys_user where 1=1";
		sql += sql(loginVO);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(loginVO);
		
		return namedParameterJdbcTemplate.query(sql, parameterSource,  new BeanPropertyRowMapper(Sysuserinfo.class));
	}
	

	public String  sql(loginVO loginVO) {
		String sql = "";
		if(StringUtil.isNotNullOrEmpty(loginVO.getUsername())){
			sql += " and Username = :Username ";
		}
		if(StringUtil.isNotNullOrEmpty(loginVO.getUser_password())){
			sql += " and User_password = :User_password ";
		}
		if (StringUtil.isNotNullOrEmpty(loginVO.getUser_ID())){
			sql += " and User_ID = :User_ID ";
		}
		
		return sql;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * 取得最后登录信息
	 * @param user_id
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SysUserLogin getLastLogin(int user_id) {
		String sql = "select * from t_sys_userlogin where user_id=?";
		Object[] params = new Object[] { user_id };
		List<SysUserLogin> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(SysUserLogin.class));
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SysUserLogin> list(int user_id, int pageIndex, int pageSize) {
		String sql = "select * from t_sys_userlogin where user_id=? order by login_date desc ";
		sql = PageUtil.createOraclePageSQL(sql, pageIndex, pageSize);
		Object[] params = new Object[] { user_id };
		List<SysUserLogin> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(SysUserLogin.class));
		return list;
	}

	/**
	 * 查询用户登录总数
	 * 
	 * @param sysUserSearchVO
	 * @return
	 */
	public int listCount(int user_id) {
		String sql = "select count(*) from t_sys_userlogin where user_id=? order by login_date desc ";
		Object[] params = new Object[] { user_id };
		return jdbcTemplate.queryForObject(sql, params, Integer.class);
	}

}
