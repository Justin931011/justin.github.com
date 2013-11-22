package com.web.servlet.intefaces;


import javax.servlet.jsp.jstl.sql.Result;

public interface TheUserInterface {

	public Result servletUserALl(String sql);

	public Result servletUserAll(String sql, Object[] object);

	public int deleteUser(String sql, Object[] objects);

	public boolean insertUserResult(String sql, Object[] objects);

	public boolean updateUserIdOrName(String sql, Object[] objects);
}
