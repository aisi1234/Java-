package com.hasee.chat02;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 发送消息线程
 * @author HASEE
 *
 */

public class Send implements Runnable {

	private Socket client;
	private DataOutputStream dos;
	private BufferedReader br;
	
	private boolean isRunning = false;
	
	private String uname;
	
	public Send(Socket client) {
		this.client = client;
		try {
			dos = new DataOutputStream(client.getOutputStream());
			br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("请输入用户名：");
			uname = br.readLine();
			
			isRunning = true;
		} catch (IOException e) {
			System.err.println("发送线程获取输出流失败");
			release();
			//e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			dos.writeUTF("uname="+uname);
			dos.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String string = "";
		while(isRunning) {
			try {
				string = br.readLine();
				dos.writeUTF(string);
				dos.flush();
				
				if(string.equals("bye")) release();
				
			} catch (IOException e) {
				System.out.println("发送线程发送消息失败");
				release();
				//e.printStackTrace();
			}
			
		}
	}
	
	private void release() {
		CloseUtils.close(br,dos,client);
		isRunning = false;
	}
	
}
