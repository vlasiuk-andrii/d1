package module4Jdbc;

import java.sql.*;

public class MyJdbcApp {

    static final String DB_NAME = "students13";
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
                    " timestamp DATETIME(0))");
            stmt.executeUpdate("CREATE TABLE Posts" +
                    "(id INTEGER not NULL, " +
                    " userId INTEGER not NULL, " +
                    " text VARCHAR(255), " +
                    " timestamp DATETIME(0))");
            stmt.executeUpdate("CREATE TABLE Likes" +
                    "(postId INTEGER not NULL, " +
                    " userId INTEGER not NULL, " +
                    " timestamp DATETIME(0))");
            System.out.println("Tables were created");

            stmt.executeUpdate("INSERT INTO Users (id,name,surname,date) VALUES (" +
                    "1,\"Warren\",\"Rosales\",\"2019-05-16\"),(" +
                    "2,\"Clarke\",\"Mckay\",\"2019-06-28\"),(" +
                    "3,\"Michael\",\"Hansen\",\"2018-01-30\"),(" +
                    "4,\"Naomi\",\"Morin\",\"2018-03-16\"),(" +
                    "5,\"Bruce\",\"Barlow\",\"2018-12-01\"),(" +
                    "6,\"Deirdre\",\"Gonzalez\",\"2018-05-07\"),(" +
                    "7,\"Lael\",\"Barnes\",\"2018-09-20\"),(" +
                    "8,\"Theodore\",\"Lynn\",\"2018-02-17\"),(" +
                    "9,\"Hayfa\",\"Suarez\",\"2019-06-21\"),(" +
                    "10,\"Orla\",\"Bradford\",\"2019-01-16\");");

            stmt.executeUpdate("INSERT INTO Friendships (userId1,userId2,timestamp) VALUES (" +
                    "1,2,\"2018-09-08 17:45:04\"),(" +
                    "1,3,\"2018-08-11 18:51:10\"),(" +
                    "1,4,\"2018-08-11 18:51:10\"),(" +
                    "4,5,\"2018-08-11 18:51:10\"),(" +
                    "6,7,\"2018-08-11 18:51:10\"),(" +
                    "8,9,\"2018-10-07 22:00:00\");");

            stmt.executeUpdate("INSERT INTO Posts (id,userId,text,timestamp) VALUES (" +
                    "102,1,\"Text of some post with id=102\",\"2018-10-04 17:45:04\"),(" +
                    "699,2,\"Text of some post with id=699\",\"2018-02-15 18:51:10\"),(" +
                    "437,4,\"Text of some post with id=437\",\"2018-04-18 22:00:00\");");

            stmt.executeUpdate("INSERT INTO Likes (postId,userId,timestamp) VALUES (" +
                    "102,1, \"2017-03-04 17:45:04\"),(" +
                    "699,1, \"2017-03-15 18:51:10\"),(" +
                    "102,1, \"2017-03-06 17:45:04\"),(" +
                    "699,10,\"2017-03-15 18:51:10\"),(" +
                    "437,10,\"2017-04-18 22:00:00\");");
            System.out.println("Tables were filled in with data");

            stmt.execute("SELECT userId, COUNT(userId) as 'correctLikes'\n" +
                    "FROM Likes\n" +
                    "WHERE timestamp LIKE '2017-03%'\n" +
                    "GROUP BY userId");

            System.out.println("SELECT RESULT = ");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                System.out.println(id + "\t" + name + "\t");
            }

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
