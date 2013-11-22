package com.web.servlet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.jsp.jstl.sql.Result;

import com.web.servlet.common.UserApiServlet;
import com.web.servlet.entity.User;
import com.web.servlet.intefaces.TheUserInterface;
import com.web.servlet.intefacesImpl.TheUserIntefacesImpl;

public class TheUserServiceImplementation {
	TheUserInterface userIntefaces = new TheUserIntefacesImpl();
	List list  = new ArrayList();
	UserApiServlet userApiServlet = new UserApiServlet();

	//�����C
	public boolean selectUserIdAndPassword(Object[] objects) {
		String sql = "select * from user where username=? and password = ?";
		Result result = userIntefaces.servletUserAll(sql, objects);
		if (result.getRowCount() == 1) {
			return true;
		}
		return false;
	}
	
	//����Ñ���
	public boolean addUserService(Object[] objects){
		String sql = "insert into user (username,password,sex,age,country,address) values(?,?,?,?,?,?)";
		return userIntefaces.insertUserResult(sql, objects);
	}
	
	//�]���У��Ñ���Ψһ��C��
	public boolean selectUsernameServlet(String userName){
		//��ԃ���е�username ����ŵ�list�����У���
		String sql = "select username from user";
		Result result = userIntefaces.servletUserALl(sql);
		list = userApiServlet.ResuleToList(result,"username");
			//��vlist ���ϱ��^username �Ƿ���ͬ
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).equals(userName)){
					return true;
				}
			}
			return false;
		}
		
	
	//��ԃ���е�country
	public List<String> selectAllCountry(){
		String sql = "select *,count(distinct country) from user group by country";
		Result result = userIntefaces.servletUserALl(sql);
		if(result.getRowCount()>0){
			Map[] rows = result.getRows();
			for (Map row : rows) {
				User user = new User();
				String country = row.get("country").toString();
				user.setCountry(country);
				list.add(user);
			}
		}
		return list;
	}
	
	//����country ��ԃ ��ַ��
	public List<String> selectCountryToAddress(Object[] objects){
		String sql = "select DISTINCT address from user where country =?";
		Result result = userIntefaces.servletUserAll(sql, objects);
		return userApiServlet.ResuleToList(result, "address");
	}
	
	//�����ĸ������
	public String intNumber(){
		
		Random rd = new Random();
		int[] intNum = new int[4];
		String[] strNum = new String[4];
		for (int i = 0; i < intNum.length; i++) {
			 strNum[i] = String.valueOf(rd.nextInt(9));
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < strNum.length; i++){
		 sb. append(strNum[i]);
		}
		String strVali =sb.toString();
		return strVali;
	}
}
