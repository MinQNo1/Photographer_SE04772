/**
 * DBContext.java
 * All Rights Reserved.
 * Copyright(c) by quyennvse04772
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DBContext.<br>
 *
 * <pre>
 * Class handling with data in database
 * In this class, it handle the process below.
 *
 * .getConnection
 * .closeConnection
 *
 * </pre>
 *
 * @author AM
 * @version 1.0
 */
public class DBContext {

    /**
     * get connection
     * <pre>
     *method get connection to databasee
     * In this class, it handle the process below.
     *
     * processing order:
     *      1.1 in case method return connection
     *          1.1.1 return a object connection to get data from databasee
     *      1.2 in case method has exception
     *          1.2.1 throw exception
     *
     * handing exception:
     *      show exception in console
     * </pre>
     *
     * @return 
     * @throws Exception
     */
    
    private final String serverName = "DESKTOP-LG088B4\\SQLEXPRESS";
    private final String dbName = "photographer";
    private final String portNumber = "1433";
    private final String username = "sa";
    private final String password = "123456";
    
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, username, password);
    }
    
    public void closeConnection(ResultSet rs, PreparedStatement ps, Connection con) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
}
