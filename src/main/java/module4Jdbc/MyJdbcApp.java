package module4Jdbc;

import java.sql.*;

public class MyJdbcApp {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/?useSSL=false";
    static final String USER = "user01";
    static final String PASS = "user01";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating database...");
            stmt = conn.createStatement();

            stmt.executeUpdate("CREATE DATABASE students5");
            System.out.println("Database created successfully...");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students5?useSSL=false", USER, PASS);
            stmt = conn.createStatement();

            stmt.executeUpdate("CREATE TABLE Users" +
                    "(id INTEGER not NULL, " +
                    " name VARCHAR(255), " +
                    " surname VARCHAR(255), " +
                    " birthdate DATETIME(6), " +
                    " PRIMARY KEY ( id ))");
            stmt.executeUpdate("CREATE TABLE Friendships" +
                    "(userId1 INTEGER not NULL, " +
                    " userId2 INTEGER not NULL, " +
                    " timestamp DATETIME(6))");
            stmt.executeUpdate("CREATE TABLE Posts" +
                    "(id INTEGER not NULL, " +
                    " userId INTEGER not NULL, " +
                    " text VARCHAR(255), " +
                    " timestamp DATETIME(6))");
            stmt.executeUpdate("CREATE TABLE Likes" +
                    "(postId INTEGER not NULL, " +
                    " userId INTEGER not NULL, " +
                    " timestamp DATETIME(6))");
            System.out.println("Tables were created");

        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
