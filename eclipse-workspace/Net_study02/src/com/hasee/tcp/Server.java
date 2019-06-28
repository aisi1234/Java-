package com.hasee.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器
 * 1.指定端口，使用ServerSocket创建服务器
 * 2.阻塞式等待连接 accept()
 * 3.操作：输入输出流操作
 * 4.释放资源
 * @author HASEE
 *
 */

public class Server {
	public static void main(String[] args) throws IOException {
		
		System.out.println("-----服务端-----");
		
		ServerSocket socket = new ServerSocket(8888);
		Socket client = socket.accept();
		System.out.println("一个客户端连接");
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		System.out.println(dis.readUTF());
		
		dis.close();
		client.close();
		socket.close();
	}
}
