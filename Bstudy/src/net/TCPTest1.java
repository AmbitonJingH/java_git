package net;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPTest1 {
//172.24.132.78
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        Scanner input = new Scanner(System.in);
        try {
            InetAddress address = InetAddress.getByName("172.24");
            int port = 6666;
            socket = new Socket(address,port);
            os = socket.getOutputStream();
            String text = input.nextLine();
            os.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(os!=null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void serve() {
        int post = 6666;
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            serverSocket = new ServerSocket(post);
            socket = serverSocket.accept();
            System.out.println("服务端开启");
            System.out.println("收到来自"+ socket.getInetAddress().getHostAddress()+"的信息");
            System.out.println("正在接收...");
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] a = new byte[10];
            int len;
            while((len = is.read(a))!=-1){

                baos.write(a,0,len);
            }
            System.out.println(baos.toString());
            System.out.println("数据传输完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(baos!=null)
                    baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(is!=null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(serverSocket!=null)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
