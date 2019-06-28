package com.hasee.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 模拟用户登录
 * 登录客户端
 * 1.使用Socket创建客户端，创建时指明IP地址和端口
 * 2.操作：输入输出流操作
 * 3.释放资源
 * @author HASEE
 *
 */

public class LoginClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.println("-----客户端-----");
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		//创建客户端
		Socket client = new Socket("localhost", 8888);
		//流操作
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		DataInputStream dis = new DataInputStream(client.getInputStream());
		
		System.out.print("请输入用户名：");
		String uname = console.readLine();
		System.out.print("请输入密码：");
		String upsd = console.readLine();
		dos.writeUTF("uname="+uname+"&upsd="+upsd);
		dos.flush();
		
		String result = dis.readUTF();
		System.out.println(result);
		
		//释放资源
		dis.close();
		dos.close();
		client.close();
	}
}
