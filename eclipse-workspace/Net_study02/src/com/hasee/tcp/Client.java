package com.hasee.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 创建客户端
 * 1.使用Socket创建客户端，创建时指明IP地址和端口
 * 2.操作：输入输出流操作
 * 3.释放资源
 * @author HASEE
 *
 */

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.println("-----客户端-----");
		
		Socket client = new Socket("localhost", 8888);
		
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF("Hello");
		dos.flush();
		
		dos.close();
		client.close();
	}
}
