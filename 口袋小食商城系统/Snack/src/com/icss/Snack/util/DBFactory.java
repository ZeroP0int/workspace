package com.icss.Snack.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBFactory {
	private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	//�������ݿ�
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
	
	//�ر�����
	public static void closeConnection() throws Exception {
		Connection connection = DBFactory.openConnection() ;
		if(connection!=null && !connection.isClosed()) {
			tl.set(null);
		}
	}
	
	//�ֶ���������
	public static void beginTransaction() throws Exception {
		Connection connection = DBFactory.openConnection() ;
		connection.setAutoCommit(false);//�����޸�Ϊ�ֶ�����
	}
	

	//�����ύ
	public static void commit() throws Exception {
		Connection connection = DBFactory.openConnection() ;
		connection.commit();
		
	}
	
	//����ع�
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


