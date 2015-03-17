package com.caco.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
/**
 *
 * @author andreiy
 */
public class BDManager {
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String JDBC_URL =
    "jdbc:postgresql://localhost/test_dac2";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "postgres";
    private static Driver driver = null;
    
    public static synchronized Connection getConnection() throws SQLException{
        if (driver == null){
            try{
                Class jdbcDriverClass = Class.forName( JDBC_DRIVER );
                driver = (Driver) jdbcDriverClass.newInstance();
                DriverManager.registerDriver( driver );
            }
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){
                System.out.println( "Failed to initialise JDBC driver" );
            }
        }
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
    }
    
    public static void close(Connection conn){
        try {
            if (conn != null) conn.close();
        }
        catch (SQLException sqle){
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            if (stmt != null) stmt.close();
        }
        catch (SQLException sqle){
        }
    }
    
    public static void close(ResultSet rs){
        try {
            if (rs != null) rs.close();
        }
        catch (SQLException sqle){
        }
    }
}
