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

    private ConnectionFactory() {}

    public static ConnectionFactory instance() {
        return instance;
    }

    public Connection connect(String tipo) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
        if(this.conn!=null) {
            this.disconnect();
        }
        else {
            if(tipo.equals(DERBY)) {
                try {
                    try {
                        Class.forName("org.apache.derby.jdbc.EmbeddedDriver").getDeclaredConstructor().newInstance();
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                    this.conn= DriverManager.getConnection("jdbc:derby:MyDerbyDB;create=true");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(tipo.equals(MYSQL)) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                    this.conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/exampleDB", "root", "password");
                } catch (SQLException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return conn;
    }

    public void disconnect() {
        if(conn!=null) {
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
