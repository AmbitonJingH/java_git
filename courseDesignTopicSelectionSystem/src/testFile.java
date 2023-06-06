import Utils.JDBCUtil;

import java.io.*;
import java.sql.*;

public class testFile {

    private static void getFile() throws SQLException, IOException {

        Connection connection = JDBCUtil.getConnection();
        String sql = "select image from images where id ='10'";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            Blob blob = resultSet.getBlob(1);
            InputStream ism = blob.getBinaryStream();
            int len = -1;
            byte[] buf = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while((len=ism.read(buf))!=-1){
                baos.write(buf,0,len);
            }
            ism.close();
            baos.close();
            byte[] bytes = baos.toByteArray();
            File file = new File("D:\\pictureTest1\\laile.doc");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.close();
        }

    }

    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = JDBCUtil.getConnection();
        File file = new File("C:\\Users\\Lenovo\\Desktop\\ALL\\zuoye.doc");
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = -1;
        byte[] buf = new byte[1024];
        while((len = fis.read(buf))!=-1){
            baos.write(buf,0,len);
        }
        baos.close();
        fis.close();
        byte[] bytes = baos.toByteArray();
        Blob blob = connection.createBlob();
        blob.setBytes(1,bytes);
        String sql = "insert into images(image) values(?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1,blob);
        statement.execute();
        statement.close();

        getFile();
        connection.close();

    }
}
