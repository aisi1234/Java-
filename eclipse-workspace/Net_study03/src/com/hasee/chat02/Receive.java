package com.hasee.chat02;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 多线程，接收消息
 * @author HASEE
 *
 */

public class Receive implements Runnable {
 
	private Socket client;
	private DataInputStream dis;
	
	private boolean isRunning = false;
	
	public Receive(Socket client) {
		this.client = client;
		try {
			dis = new DataInputStream(client.getInputStream());
			isRunning = true;
		} catch (IOException e) {
			System.out.println("接收线程获取输入流失败");
			release();
			//e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		String string = "";
		while(isRunning) {
			try {
				string = dis.readUTF();
				System.out.println(string);
			} catch (IOException e) {
				System.out.println("接收线程接收消息失败");
				release();
				//e.printStackTrace();
			}
		}
	}
	
	private void release() {
		CloseUtils.close(dis,client);
		isRunning = false;
	}
}
