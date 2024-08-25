package org.integrador.Util;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static final String MYSQL= "mysql";
    public static final String DERBY= "derby";

    public static ConnectionFactory instance= new ConnectionFactory();
    private Connection conn;
    public boolean conexion;

    private ConnectionFactory() {
    	this.conexion=false;
    }

    public static ConnectionFactory instance() {
        return instance;
    }

	public Connection connect(String tipo) {
		if (this.conn != null){
			this.disconnect();
		}
		else {
			if (tipo.equals(DERBY)) {
				try {
					Class.forName("org.apache.derby.jdbc.EmbeddedDriver").getDeclaredConstructor().newInstance();
					this.conn = DriverManager.getConnection("jdbc:derby:MyDerbyDB;create=true");
					this.conexion=true;
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
						 | NoSuchMethodException | SecurityException | ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
			if (tipo.equals(MYSQL)) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
					this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/integrador1", "root", "password");
					conn.setAutoCommit(false);
					this.conexion=true;
				} catch (SQLException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return this.conn;
	}


	public void disconnect() {
        if(conn!=null) {
            try {
                this.conn.close();
                this.conexion=false;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
