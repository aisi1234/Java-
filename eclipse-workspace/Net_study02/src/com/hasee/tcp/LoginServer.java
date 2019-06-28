package com.hasee.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟用户登录服务器
 * 创建服务器
 * 1.指定端口，使用ServerSocket创建服务器
 * 2.阻塞式等待连接 accept()
 * 3.操作：输入输出流操作
 * 4.释放资源
 * @author HASEE
 *
 */

public class LoginServer {
	public static void main(String[] args) throws IOException {
		
		System.out.println("-----服务端-----");
		
		//创建对象
		ServerSocket socket = new ServerSocket(8888);
		//获取连接
		Socket client = socket.accept();
		System.out.println("一个客户端连接");
		//流操作
		DataInputStream dis = new DataInputStream(client.getInputStream());
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		String[] mStrings = dis.readUTF().split("&");
		for(String str : mStrings) {
			String[] msg = str.split("=");
			System.out.println(msg[0]+"-->"+msg[1]);
		}
		if(mStrings[0].substring(mStrings[0].indexOf("=")+1).equals("admin")
				&&mStrings[1].substring(mStrings[1].indexOf("=")+1).equals("123456")) {
			dos.writeUTF("登录成功！欢迎回来！");
		}else {
			dos.writeUTF("用户名或密码错误！");
		}
		dos.flush();
		
		dos.close();
		dis.close();
		client.close();
		socket.close();
	}
}
