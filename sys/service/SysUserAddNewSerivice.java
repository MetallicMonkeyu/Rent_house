package com.app.sys.service;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.sys.dao.addNewDao;
import com.app.sys.model.addnewModle;
import com.app.sys.vo.addNewVO;
import com.app.util.date.DateUtil;
import com.app.util.picconvert.test;
@Service
public class SysUserAddNewSerivice {
	@Autowired
	private addNewDao addNewDao;
	
	public int addNew(addNewVO addNewVO) {//后面修改，加查询方法是否有重复，再添加
		test test  = new test();
		String ip = "http://192.168.70.107:8080/app/img/";
		String datevar = DateUtil.dateToString(new Date(), "yyyyMMddHHmmss");

		try {
		
			boolean url_one = test.GenerateImage(addNewVO.getPic_one_file().getBytes(),"D:\\appanddatabase\\app\\eclipse4.6\\workspace\\app\\src\\main\\webapp\\img\\",addNewVO.getUser_ID(),"\\"+datevar,"\\House_one.jpg");
			if (url_one){
				addNewVO.setPic_one(ip+addNewVO.getUser_ID()+"/"+datevar+"/House_one.jpg");
			}else{
				addNewVO.setPic_one("");
			}
			if (addNewVO.getPic_two_file() != null) {
				boolean url_two = test.GenerateImage(addNewVO.getPic_two_file().getBytes(),"D:\\appanddatabase\\app\\eclipse4.6\\workspace\\app\\src\\main\\webapp\\img\\",addNewVO.getUser_ID(),"\\"+datevar,"\\House_two.jpg");
				if (url_two){
					addNewVO.setPic_two(ip+addNewVO.getUser_ID()+"/"+datevar+"/House_two.jpg");
				}else{
					addNewVO.setPic_two("");
				}
			}
			if (addNewVO.getPic_three_file() != null) {
			boolean url_three = test.GenerateImage(addNewVO.getPic_three_file().getBytes(),"D:\\appanddatabase\\app\\eclipse4.6\\workspace\\app\\src\\main\\webapp\\img\\",addNewVO.getUser_ID(),"\\"+datevar,"\\House_three.jpg");
			if (url_three){
				addNewVO.setPic_three(ip+addNewVO.getUser_ID()+"/"+datevar+"/House_three.jpg");
			}else {
				addNewVO.setPic_three("");
			}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addNewDao.addNew(addNewVO);
	}
	public List<addnewModle> queryHouse(addNewVO addNewVO) {
			return addNewDao.queryHousedao(addNewVO);
		
	}
	public List<addnewModle> findtype(addNewVO addNewVO) {
		return addNewDao.findtypedao(addNewVO);
	
}
	

}
