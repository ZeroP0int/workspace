package com.icss.Snack.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBFactory {
	private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	//连接数据库
	public static Connection openConnection() throws Exception{
		Connection connection = tl.get();
		if(connection==null||connection.isClosed()) {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_stacks",
					"root","123456");
			tl.set(connection);
		}
		
		return connection;
	}
	
	//关闭连接
	public static void closeConnection() throws Exception {
		Connection connection = DBFactory.openConnection() ;
		if(connection!=null && !connection.isClosed()) {
			tl.set(null);
		}
	}
	
	//手动控制事物
	public static void beginTransaction() throws Exception {
		Connection connection = DBFactory.openConnection() ;
		connection.setAutoCommit(false);//事物修改为手动控制
	}
	

	//事物提交
	public static void commit() throws Exception {
		Connection connection = DBFactory.openConnection() ;
		connection.commit();
		
	}
	
	//事务回滚
	public static void rollback() throws Exception {
		Connection connection = DBFactory.openConnection() ;
		connection.rollback();
	}
	
/*	public static void main(String[] args) {
		try {
			Connection connection = DBFactory.openConnection() ;
		
		}
	}
*/	
}


