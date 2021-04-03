package main.java.databaseutil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBManager {

    private static Connection con;

    private DBManager(){}

    private static DBManager  dbmanager;

    public static DBManager getInstance(){
        if (dbmanager == null){
            synchronized(DBManager.class){
                if (dbmanager == null){
                    dbmanager = new DBManager();//instance will be created at request time
                }
            }
        }
        return dbmanager;
    }

    public static Connection getConnection(){

        if(con==null){
            try {
                String host = "jdbc:mysql://localhost:3306/business";
                String username = "root";
                String password = "root";
                con = DriverManager.getConnection( host, username, password );
            } catch (SQLException ex) {
            }
        }
        return con;
    }

    public static void closeConnection() throws SQLException {
            try {
                con.close();
                System.out.println("Database Connection Closed Successfully");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Connection NOT closed");
            }
    }
}
