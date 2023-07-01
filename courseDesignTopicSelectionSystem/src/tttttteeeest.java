import Utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class tttttteeeest {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtil.getConnection();
//        String sql = "select subtime from sselect";
//        PreparedStatement statement = connection.prepareStatement(sql);
//      //  statement.executeQuery();
//        ResultSet resultSet = statement.executeQuery();
//        while (resultSet.next()){
//            Object subtime = resultSet.getObject("subtime");
//            System.out.println(subtime);

            String sql = "select grade from sselect where sno=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1,"42109210504");
            //  statement.executeQuery();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String subtime = resultSet.getString("grade");
                System.out.println(subtime);
        }
    }
}
