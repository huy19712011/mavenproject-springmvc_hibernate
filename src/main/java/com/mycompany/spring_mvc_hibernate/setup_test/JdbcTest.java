/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_hibernate.setup_test;

import java.sql.*;

/**
 *
 * @author huynq
 */
public class JdbcTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {

            // get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_customer_tracker", "admin", "123456");
            System.out.println("Database connection successful!");

            // create a statement
            myStmt = myConn.createStatement();

            // execute sql query
            myRs = myStmt.executeQuery("select * from customer");

            // process the resultset
            while (myRs.next()) {
                System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (myRs != null) try {
                myRs.close();
            } catch (SQLException ignore) {
            }
            if (myStmt != null) try {
                myStmt.close();
            } catch (SQLException ignore) {
            }
            if (myConn != null) try {
                myConn.close();
            } catch (SQLException ignore) {
            }
        }
    }

}
