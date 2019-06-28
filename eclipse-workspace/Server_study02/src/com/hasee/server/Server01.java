package com.hasee.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用ServerSocket建立与浏览器的连接，获取请求协议
 * @author HASEE
 *
 */

public class Server01 {
	private ServerSocket serverSocket;
	public static void main(String[] args) {
		Server01 server = new Server01();
		server.start();
		server.receive();
	}
	
	//启动服务
	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
		} catch (IOException e) {
			System.err.println("服务器启动失败...");
		}
	}
	
	//接收连接
	public void receive() {
		try {
			Socket client = serverSocket.accept();
			System.out.println("一个客户端建立了连接...");
			InputStream is = client.getInputStream();
			byte[] datas = new byte[1024*1024];
			int len = is.read(datas);
			String requestInfo = new String(datas, 0, len);
			System.out.println(requestInfo);
		} catch (IOException e) {
			System.err.println("客户端连接失败...");
		}
	}
	
	//停止服务
	public void stop() {
		
	}
}
