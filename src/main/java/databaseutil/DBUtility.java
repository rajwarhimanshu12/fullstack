package main.java.databaseutil;

import java.sql.*;

public class DBUtility {

    static Connection con = DBManager.getInstance().getConnection();

    public static Statement runquery() throws SQLException {
        return con.createStatement();
    }

    public static ResultSet SelectQueryResult(String sql) throws SQLException {
        return runquery().executeQuery(sql);
    }
}
