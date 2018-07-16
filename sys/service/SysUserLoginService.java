package com.app.sys.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.app.sys.dao.SysUserLoginDao;
import com.app.sys.model.SysLogin;
import com.app.sys.model.SysUserLogin;
import com.app.sys.model.Sysuserinfo;
import com.app.sys.vo.loginVO;
import com.app.util.picconvert.test;

import Decoder.BASE64Decoder;

@Service
public class SysUserLoginService {
	@Autowired
	private SysUserLoginDao sysUserLoginDao;
	/**
	 * 登录校验
	 */
	public List<Sysuserinfo> checkLogin(loginVO loginVO) {
		return sysUserLoginDao.checkLogindao(loginVO);
	}
	/**
	 * 注册
	 */
	public int add(Sysuserinfo sysuserinfo) {//后面修改，加查询方法是否有重复，再添加
		return sysUserLoginDao.add(sysuserinfo);
	}
	public int update(Sysuserinfo sysuserinfo) {
		int flag = sysUserLoginDao.update(sysuserinfo);
		return flag;
	}
	public int updateHead(Sysuserinfo sysuserinfo) {
		BASE64Decoder decoder = new BASE64Decoder(); 
		
		boolean portrait = false;
		try {
			portrait = test.GenerateImage(decoder.decodeBuffer(sysuserinfo.getPortrait()),"D:\\appanddatabase\\app\\eclipse4.6\\workspace\\app\\src\\main\\webapp\\img\\",sysuserinfo.getUser_ID(),"\\portrait\\","portrait.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (portrait){
			sysuserinfo.setPortrait("http://192.168.70.107/app/img/"+sysuserinfo.getUser_ID()+"/portrait/portrait.png");
		}else{
			sysuserinfo.setPortrait("");
		}
		int flag = sysUserLoginDao.updateHead(sysuserinfo);
		return flag;
	}
	
	/**
	 * 取得最后登录信息
	 * @param user_id
	 * @return
	 */
	public SysUserLogin getLastLogin(int user_id) {
		return sysUserLoginDao.getLastLogin(user_id);
	}

	public List<SysUserLogin> list(int user_id, int pageIndex, int pageSize) {
		return sysUserLoginDao.list(user_id, pageIndex, pageSize);
	}

	/**
	 * 查询用户登录总数
	 * 
	 * @param sysUserSearchVO
	 * @return
	 */
	public int listCount(int user_id) {
		return sysUserLoginDao.listCount(user_id);
	}

}
