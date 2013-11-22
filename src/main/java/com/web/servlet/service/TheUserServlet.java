package com.web.servlet.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.servlet.common.BaseAction;

/**
 * Servlet implementation class TheUserServlet
 */
public class TheUserServlet extends HttpServlet {
	TheUserServiceImplementation userServiceImplementation = new TheUserServiceImplementation();
	List<String> list = new ArrayList<String>();
	BaseAction baseAction = new BaseAction();
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  HttpSession session = request.getSession();
		  PrintWriter pw = response.getWriter();
		  String getUrl = request.getRequestURI();
		  String url = getUrl.substring(getUrl.lastIndexOf("/"),
				getUrl.lastIndexOf("."));
		  System.out.println(url);
		if (url.equals("/Login")) {//登录处理
			String username = request.getParameter("userName");
			String passWord = request.getParameter("passWord");
			Object[] objects = { username, passWord };
			boolean mark = userServiceImplementation
					.selectUserIdAndPassword(objects);
			if (mark) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("userPage/userPage.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/error.jsp");
				dispatcher.forward(request, response);
				}
		}else if(url.equals("/AddUser")){//添加user
			String userName = request.getParameter("userName");
			String passWord = request.getParameter("passWord");
			String sex = request.getParameter("sex");
			int age = Integer.parseInt(request.getParameter("age"));
			String country = request.getParameter("Cty");
			String address = request.getParameter("address");
			Object[] objects = {userName,passWord,sex,age,country,address};
			if(userServiceImplementation.addUserService(objects)){
				RequestDispatcher dispatcher = request.getRequestDispatcher("userPage/userLogin.jsp");
				dispatcher.forward(request, response);
			}
		}else if(url.equals("/SelectCountry")){//查询所有的国家
			//request.getSession().invalidate();
			request.removeAttribute("name");
			list = userServiceImplementation.selectAllCountry();
			request.setAttribute("intNumber", userServiceImplementation.intNumber());
			request.setAttribute("countryList", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("userPage/addUserPage.jsp");
			dispatcher.forward(request, response);
		}else if(url.equals("/ValidationuserName")){//验证username是否唯一
			String username = request.getParameter("name");
			String sex = request.getParameter("sex");
			System.out.println(sex);
			if(username.length()<=0){
				pw.write("用户名不能为空！a");
			}else{
			boolean mark = userServiceImplementation.selectUsernameServlet(username);
				if(mark==true){//用户名不唯一。
					  response.getWriter().write("false");
				}else{
					  response.getWriter().write("true");
				}
			}
		}else if(url.equals("/ValidationUserPassWord")){//验证密码合法
			String passWord1 = request.getParameter("pw1");
			if(passWord1.length()<=4|| passWord1.length()>16){
				response.getWriter().write("false");
			}else{
				response.getWriter().write("true");
			}
		}else if(url.equals("/ValidationSecondPassWord")){//验证重复密码
			String secondPd = request.getParameter("secondPd");
			String passWord = request.getParameter("passWord");
			System.out.println(secondPd+"1111111111"+passWord);
				if(secondPd.equals(passWord)){
					response.getWriter().write("true");
				}else
				response.getWriter().write("NoSame");
		}else if(url.equals("/ValidationAge")){//验证年龄合法性。
			 try{	
				 	String age = request.getParameter("age");
				 	int age1 = Integer.parseInt(request.getParameter("age"));
				 	Integer.parseInt(age);//判断是否是数字字符。
				 	if(age1>0 && age1<=120){
						response.getWriter().write("true");
					}else
						response.getWriter().write("false");
				  }catch(NumberFormatException e){
					  response.getWriter().write("false");
				  	}
			}else if(url.equals("/ValidaValidation")){
				String valida = request.getParameter("getValida");
				System.out.println(valida);
				String getSessionValida = (String)session.getAttribute("RANDOMVALIDATECODEKEY");
				if(valida.equals(getSessionValida)){
					response.getWriter().write("true");
				}else
					response.getWriter().write("false");
				
			}
		}
	}
