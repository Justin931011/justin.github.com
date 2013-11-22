package com.web.servlet.common;

import java.util.Map;


import com.opensymphony.xwork2.ActionContext;

public class BaseAction {
		//获得request
	public Map<String, Object> getRequest(){
		return (Map) ActionContext.getContext().get("request");
	}
	
	//获得session 
	public Map<String, Object> getSession(){
		 return (Map)ActionContext.getContext().getSession();
	}
	
	//获得aplication
	public Map<String, Object> getApplication(){
		return (Map)ActionContext.getContext().getApplication();
	}

	}
	
