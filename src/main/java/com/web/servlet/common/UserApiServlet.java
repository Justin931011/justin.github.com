package com.web.servlet.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

public class UserApiServlet {
	
	//�Ѳ�ԃ����result�Y�����D����list���ϣ�
	List<String> list  = new ArrayList<String>();
	public List<String> ResuleToList(Result result,String field){
		String country = null;
	if(result.getRowCount()>0){
		Map[] rows = result.getRows();
		for (Map row : rows) {
			 country = row.get(field).toString();
			list.add(country);
		}
	}
	return list;
	}
}
