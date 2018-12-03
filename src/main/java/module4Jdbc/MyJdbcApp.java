package module4Jdbc;

import java.sql.*;

public class MyJdbcApp {

    static final String DB_NAME = "students3";
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String URL_PARAMETERS = "?useSSL=false";
    static final String USER = "user01";
    static final String PASS = "user01";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL + URL_PARAMETERS, USER, PASS);

            System.out.println("Creating database...");
            stmt = conn.createStatement();

            stmt.executeUpdate("CREATE DATABASE " + DB_NAME);
            System.out.println("Database created successfully...");

            conn = DriverManager.getConnection(DB_URL + DB_NAME + URL_PARAMETERS, USER, PASS);
            stmt = conn.createStatement();

            stmt.executeUpdate("CREATE TABLE Users" +
                    "(id INTEGER not NULL, " +
                    " name VARCHAR(255), " +
                    " surname VARCHAR(255), " +
                    " date DATE)");
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

            stmt.executeUpdate("INSERT INTO Users (id,name,surname,date) VALUES (" +
                    "1,\"Warren\",\"Rosales\",\"19-05-16\"),(" +
                    "2,\"Clarke\",\"Mckay\",\"19-06-28\"),(" +
                    "3,\"Michael\",\"Hansen\",\"18-01-30\"),(" +
                    "4,\"Naomi\",\"Morin\",\"18-03-16\"),(" +
                    "5,\"Bruce\",\"Barlow\",\"18-12-01\"),(" +
                    "6,\"Deirdre\",\"Gonzalez\",\"18-05-07\"),(" +
                    "7,\"Lael\",\"Barnes\",\"18-09-20\"),(" +
                    "8,\"Theodore\",\"Lynn\",\"18-02-17\"),(" +
                    "9,\"Hayfa\",\"Suarez\",\"19-06-21\"),(" +
                    "10,\"Orla\",\"Bradford\",\"19-01-16\");");
            System.out.println("Tables were filled in with data");

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
