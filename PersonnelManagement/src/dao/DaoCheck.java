package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


import java.sql.SQLException;








import service.DepartmentServiceImpl;
import model.Employee;



public class DaoCheck{
	protected static String dbClassName = "com.mysql.jdbc.Driver";
	protected static String dbUrl = "jdbc:mysql://localhost:3306/company";
	protected static String dbUser = "root";
	protected static String dbPwd = "root";
	private static Connection conn = null;
	static DepartmentServiceImpl dsi=new DepartmentServiceImpl();
	private DaoCheck() {
		try {
			if (conn == null) {
				Class.forName(dbClassName).newInstance();
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
			}
			else
				return;
		} catch (Exception ee) {
			ee.printStackTrace();
		}//����

	}
	private static ResultSet executeQuery(String sql) {
		try {
			if(conn==null)
			new DaoCheck();
			return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}
	
	
	
private static int executeUpdate(String sql) {
		
		try {
			if(conn==null)
				new DaoCheck();
			return conn.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			//if(e.getMessage().equals("[Microsoft][SQLServer 2000 Driver for JDBC][SQLServer]DELETE ����� COLUMN REFERENCE Լ�� 'FK_TB_BORRO_REFERENCE_TB_BOOKI' ��ͻ���ó�ͻ��������ݿ� 'db_library'���� 'tb_borrow', column 'bookISBN'��"))
				
			return -1;
		} finally {
		}
	}
	
	public static void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn = null;
		}
	}
public static Employee check(String name, String password) {
	int i = 0;
	Employee employee=new Employee();
	String sql = "select *  from Employee where name='" + name
			+ "' and password='" + password + "'and power=1";
	ResultSet rs = DaoCheck.executeQuery(sql);
	try {
		while (rs.next()) {
			String names = rs.getString(1);
			employee.setId(rs.getInt("id"));
			employee.setName(rs.getString("name"));
			employee.setPower(rs.getInt("Power"));
			employee.setPassword(rs.getString("id"));
			if (names != null) {
				i = 1;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	DaoCheck.close();
	return employee;
	
}
}