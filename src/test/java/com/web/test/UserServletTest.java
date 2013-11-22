package com.web.test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.web.servlet.intefaces.TheUserInterface;
import com.web.servlet.intefacesImpl.TheUserIntefacesImpl;
import com.web.servlet.service.TheUserServiceImplementation;

public class UserServletTest {
	TheUserServiceImplementation implementation = new TheUserServiceImplementation();
	TheUserInterface userinter = new TheUserIntefacesImpl();
	List<String > list = new ArrayList<String>();
	@Test
	public void servletUserName_test(){
		
		implementation.selectUsernameServlet("jsk");
	}

	
	@Test
	public void addtuser_test(){
		Object[] objects={"tony","123123","male",24,"country","WUHAN"};
		String sql ="insert into user (username,password,sex,age,country,address)  values(?,?,?,?,?,?)";
		System.out.println(userinter.insertUserResult(sql, objects));
	}
	
	@Test
	public void selectCountry_test(){
		list = implementation.selectAllCountry();
		System.out.println(list.size());
		}
	
	@Test
	public void selectCountryToAddress_test(){
		Object[] objects ={"CHINA"};
		list = implementation.selectCountryToAddress(objects);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void validationCode_test(){
		String a =implementation.intNumber();
		System.out.print(a);
	}
	
	@Test
	public void sys_test(){
		System.out.println("asdf");
	}
}
