package database;

import java.sql.*;
import java.util.Optional;

public class MySqlConnection {

    private static Connection con;
    private String url;
    private String user;
    private String password;

    public MySqlConnection(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        con = null;

        connect();
    }

    public static Connection getCon() {
        return con;
    }

    private void connect(){
        if (con == null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(
                        this.url,
                        this.user,
                        this.password);

            }catch(SQLException | ClassNotFoundException e){
                System.out.println(e);
            }
        }
    }

    public static void closeConnection() {
        try {
            con.close();
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public Optional<ResultSet> ExecuteReq(String req){

        try{
            Statement stmt= con.createStatement();

            return Optional.of(stmt.executeQuery(req));
        }catch(Exception e){
            System.out.println(e);
            return Optional.empty();
        }
    }

    public int ExecuteReqDataManip(String req){
        try{
            Statement stmt= con.createStatement();
            return stmt.executeUpdate(req);
        }catch(Exception e){
            System.out.println(e);
            return 0;
        }
    }

    public int ExecutePreparedReqDataManip(PreparedStatement preparedStmt){
        try{
            return preparedStmt.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
            return 0;
        }
    }

}