package com.app.sys.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.sys.model.Sysuserinfo;
import com.app.sys.model.addnewModle;
import com.app.sys.service.SysUserAddNewSerivice;
import com.app.sys.vo.addNewVO;
import com.app.sys.vo.loginVO;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;
import com.sun.tools.corba.se.idl.constExpr.NotEqual;
@Controller
@RequestMapping("/houseSubmit")
public class addNewController {
	//
	@Autowired
	private SysUserAddNewSerivice SysUserAddNewSerivice;
	@RequestMapping("/addNew")
	public void addNew(HttpServletRequest request, HttpServletResponse response, addNewVO addNewVO) {
		int flag = SysUserAddNewSerivice.addNew(addNewVO);
		// 将返回值list转成json型
		String json = "";
		if (flag == 1){
			json = JsonUtil.createOperaStr(true, "发布成功");
		}else{
			json = JsonUtil.createOperaStr(false, "发布失败");
		}
//		loginVO aLoginVO = new loginVO();
//		aLoginVO.getGender()
		// 将最终结果打印给前台
		WebUtil.out(response, json);

	}
	@RequestMapping("/queryHouse")
	public void queryHouse(HttpServletRequest request, HttpServletResponse response, addNewVO addNewVO){
		
		List<addnewModle> list = SysUserAddNewSerivice.queryHouse(addNewVO);
		// 将返回值list转成json型
		String json = "";
		if (list != null&&list.size()>0){
			json = JsonUtil.toJsonStr(list,true,"");
		}else{
			json = JsonUtil.toJsonStr(list,false,"searchfail");
		}
		
		System.out.println(json);
		// 将最终结果打印给前台
		WebUtil.out(response, json);

	}
public void findtype(HttpServletRequest request, HttpServletResponse response, addNewVO addNewVO){
		
		List<addnewModle> list = SysUserAddNewSerivice.findtype(addNewVO);
		// 将返回值list转成json型
		String json = "";
		if (list != null&&list.size()>0){
			json = JsonUtil.toJsonStr(list,true,"");
		}else{
			json = JsonUtil.toJsonStr(list,false,"searchfail");
		}
		
		System.out.println(json);
		// 将最终结果打印给前台
		WebUtil.out(response, json);

	}
	}
	

