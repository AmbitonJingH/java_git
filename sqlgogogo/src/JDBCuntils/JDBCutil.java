package JDBCuntils;

import java.sql.*;

public class JDBCutil {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/library?serverTimezone=GMT%2B8";
    String user = "root";
    String password = "123456";
    String host = "localhost";
    String port = "3306";
    String database = "library";
    private Connection conn=null;

    public Connection connection(){
        try{
        Class.forName(this.driver);
        this.conn = DriverManager.getConnection(this.url,this.user,this.password);

        }catch (ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
        return this.conn;
    }
    public static void close(Connection con, Statement sta, ResultSet res) throws SQLException {
        if(con!=null&&!con.isClosed())
            con.close();
        if(sta!=null&&!sta.isClosed())
            sta.close();
        if(res!=null&&!res.isClosed())
            res.close();

    }
    public static void main(String[] args) {
        JDBCutil jdbCutil = new JDBCutil();
        jdbCutil.connection();
    }
}
