package com.app.sys.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.config.listener.OnLineListener;
import com.app.sys.model.SysDw;
import com.app.sys.model.SysLogin;
import com.app.sys.model.Sysuserinfo;
import com.app.sys.model.SysUserLogin;
import com.app.sys.model.Sysuserinfo;
import com.app.sys.service.SysDwService;
import com.app.sys.service.SysUserAddNewSerivice;
import com.app.sys.service.SysUserLoginService;
import com.app.sys.service.SysUserService;
import com.app.sys.vo.RegVO;
import com.app.sys.vo.loginVO;
import com.app.util.date.DateUtil;
import com.app.util.json.JsonUtil;
import com.app.util.session.SessionUtil;
import com.app.util.session.UserSession;
import com.app.util.string.StringUtil;
import com.app.util.web.WebUtil;

@RequestMapping("/")
@Controller
public class SysLoginController {

	@Autowired
	private SysUserLoginService sysUserLoginService;

	/**
	 * 登录校验
	 * 
	 * @param request
	 * @param response
	 * @param username
	 * @param password
	 */
	// 方法体的标识
	@RequestMapping("/checkLogin")
	// loginvo 装载前台参数数组用
	public void checkLogin(HttpServletRequest request, HttpServletResponse response, loginVO loginVO) {
		// 调取sysUserLoginService业务处理类的checkLogin方法
		// 返回值list
		List<Sysuserinfo> list = sysUserLoginService.checkLogin(loginVO);
		// 将返回值list转成json型
		String json = "";
		if (list != null&&list.size()==1){
			json = JsonUtil.toJsonStr(list,true,"");
		}else{
			json = JsonUtil.toJsonStr(list,false,"");
		}
		
		System.out.println(json);
		// 将最终结果打印给前台
		WebUtil.out(response, json);
	}

	/**
	 * 注册
	 * 
	 * @param request
	 * @param response
	 * @param sysUser
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response,  Sysuserinfo sysuserinfo) {
		int flag = sysUserLoginService.add(sysuserinfo);
		// 将返回值list转成json型
		String json = JsonUtil.toStr(flag);
		// 将最终结果打印给前台
		WebUtil.out(response, json);

	}
	@RequestMapping("/update")
	public void update(HttpServletRequest request, HttpServletResponse response, Sysuserinfo sysuserinfo) {
		int flag = sysUserLoginService.update(sysuserinfo);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "保存失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "保存成功"));
	}
	@RequestMapping("/updatehead")
	public void updateHead(HttpServletRequest request, HttpServletResponse response, Sysuserinfo sysuserinfo) {
		int flag = sysUserLoginService.updateHead(sysuserinfo);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "保存失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "保存成功"));
	}
//注册校验
	@RequestMapping("/checkRegName")
	public void checkRegName(HttpServletRequest request, HttpServletResponse response, loginVO loginVO) {
		// 调取sysUserLoginService业务处理类的checkLogin方法
		// 返回值list
		List<Sysuserinfo> list = sysUserLoginService.checkLogin(loginVO);
		// 将返回值list转成json型
		String json = "";
		
		if (list != null&&list.size()==1){
			json = JsonUtil.toJsonStr(list,false,"");
		}else{
			json = JsonUtil.toJsonStr(list,true,"");
		}
		// 将最终结果打印给前台
		WebUtil.out(response, json);
	}
	
	
}
