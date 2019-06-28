package com.hasee.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用线程实现多用户登录
 * 模拟用户登录服务器
 * 创建服务器
 * 1.指定端口，使用ServerSocket创建服务器
 * 2.阻塞式等待连接 accept()
 * 3.操作：输入输出流操作
 * 4.释放资源
 * @author HASEE
 *
 */

public class LoginMutiServer {
	public static void main(String[] args) throws IOException {
		
		System.out.println("-----服务端-----");
		
		//创建对象
		ServerSocket socket = new ServerSocket(8888);
		//获取连接
		boolean isRuning = true;
		Socket client = null;
		while(isRuning) {
			client = socket.accept();
			
			new Thread(new Channel(client)).start();
			System.out.println("一个客户端连接");
		}
		client.close();
		socket.close();
//		//流操作
//		DataInputStream dis = new DataInputStream(client.getInputStream());
//		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
//		
//		String[] mStrings = dis.readUTF().split("&");
//		for(String str : mStrings) {
//			String[] msg = str.split("=");
//			System.out.println(msg[0]+"-->"+msg[1]);
//		}
//		
//		if(mStrings[0].substring(mStrings[0].indexOf("=")).equals("admin")
//				&&mStrings[1].substring(mStrings[1].indexOf("=")).equals("123456")) {
//			dos.writeUTF("用户名或密码错误！");
//		}else {
//			dos.writeUTF("登录成功！欢迎回来！");
//		}
//		dos.flush();
//		
//		dos.close();
//		dis.close();
//		client.close();
//		socket.close();
	}
}

class Channel implements Runnable{

	private Socket client;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	//String[] mStrings;
	
	public Channel() {}
	
	public Channel(Socket client){
		this.client = client;
		try {
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		try {
			String string = receive();
			send(string);
			release();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//接收
	private String receive() throws IOException {
		String string = dis.readUTF();
		String[] mStrings = string.split("&");
		for(String str : mStrings) {
			String[] msg = str.split("=");
			System.out.println(msg[0]+"-->"+msg[1]);
		}
		return string;
	}
	
	//发送
	private void send(String string) throws IOException {
		String[] mStrings = string.split("&");
		if(mStrings[0].substring(mStrings[0].indexOf("=")+1).equals("admin")
				&& mStrings[1].substring(mStrings[1].indexOf("=")+1).equals("123456")) {
			dos.writeUTF("登录成功！欢迎回来！");
		}else {
			dos.writeUTF("用户名或密码错误！");
		}
		dos.flush();
	}
	
	
	//释放资源
	private void release() throws IOException {
		if(null != dos) dos.close();
		if(null != dis) dis.close();
		//if(null != client) client.close();
	}
}
