package com.web.servlet.intefacesImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

import com.web.servlet.common.Dbhelp;
import com.web.servlet.intefaces.TheUserInterface;

public class TheUserIntefacesImpl implements TheUserInterface {
	public static Result result = null;
	public static ResultSet resultSet = null;
	public static PreparedStatement pst = null;
	public static Connection conn = null;

	public Result servletUserALl(String sql) {

		try {
			// �õ�һ�����ӣ�
			conn = Dbhelp.getConnection();
			// ���preparedStatement����
			pst = conn.prepareStatement(sql);
			// ִ��sql���
			resultSet = pst.executeQuery();
			// ��resutlSet����ת����result���������
			result = ResultSupport.toResult(resultSet);
			// ���ؽ����
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public Result servletUserAll(String sql, Object[] object) {

		try {
			conn = Dbhelp.getConnection();
			pst = conn.prepareStatement(sql);
			for (int i = 0; i < object.length; i++) {
				pst.setObject(i + 1, object[i]);
			}

			resultSet = pst.executeQuery();
			result = ResultSupport.toResult(resultSet);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public int deleteUser(String sql, Object[] objects) {
		conn = Dbhelp.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				pst.setObject(i + 1, objects[i]);
			}
			int updateCount = pst.executeUpdate();
			return updateCount;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}

	public boolean insertUserResult(String sql, Object[] objects) {
		conn = Dbhelp.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				pst.setObject(i + 1, objects[i]);
			}
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
			return true;
	}

	public boolean updateUserIdOrName(String sql, Object[] objects) {
		conn = Dbhelp.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				pst.setObject(i + 1, objects[i]);
			}

			if (pst.executeUpdate() > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

}
