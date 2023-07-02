package net;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPTest2 {
    @Test
    public void client() throws IOException {
        InetAddress address = InetAddress.getByName("172.24");
        int port = 1234;
        //1.创建Socket
        Socket socket = new Socket(address,port);
        //2.创建File实例和FileInputStream的实例
        File file = new File("pic.JPG");
        FileInputStream fis = new FileInputStream(file);
        //通过socket获取输出流
        OutputStream ops = socket.getOutputStream();
        //4.读写数据
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer))!=-1){
            ops.write(buffer,0,len);
        }

        //5.关闭
        ops.close();
        fis.close();
        socket.close();


    }

    @Test
    public void serve() throws IOException {
        int port = 1234;
        //1.创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(port);
        //2.接收来自服务端的serverSocket.accept()
        Socket socket = serverSocket.accept();
        //3.通过socket.getInputStream()获取一个输入流
        InputStream is = socket.getInputStream();
        //4.创建File和FileOutputStream的实例
        File file = new File("pic1.jpg");
        FileOutputStream fos = new FileOutputStream(file);
        int len;
        byte[] buffer = new byte[1024];
        //5.读写数据
        while ((len = is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        //6.关闭
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
