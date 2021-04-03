package main.java.databaseutil;

import com.mongodb.DB;

import java.sql.*;

public class DBUtility {

    public static ResultSet SelectQueryResult(String sql) throws SQLException {
       Connection con = DBManager.getInstance().getConnection();
       Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        return rs;
    }
}
