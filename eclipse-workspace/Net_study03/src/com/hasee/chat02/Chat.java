package com.hasee.chat02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 群聊，服务端
 * 
 * @author HASEE
 *
 */

public class Chat {
	//容器，存储多个客户端连接
	private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<>();
	public static void main(String[] args) {
		System.out.println("*****服务端*****");
		//指定端口，使用ServiceSocket创建服务端
		try {
			ServerSocket server = new ServerSocket(8888);
			//获取连接
			while(true) {
				Socket client = server.accept();
				System.out.println("一个客户端建立了连接");
				Channel channel = new Channel(client);
				all.add(channel);
				new Thread(channel).start();
			}
		} catch (IOException e) {
			System.err.println("创建客户端失败");
			//e.printStackTrace();
		}
	}
	
	
	//内部类，连接通道
	static class Channel implements Runnable{
		
		private Socket client;
		private DataInputStream dis; //输入流
		private DataOutputStream dos;//输出流
		
		private boolean isRunning = false;
		
		private String uname;
		
		/*
		 * 初始化，获取客户端实例和客户端的IO流
		 */
		public Channel(Socket client) {
			this.client = client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				
				isRunning = true;
				
			} catch (IOException e) {
				System.out.println("获取流失败");
				release();
				//e.printStackTrace();
			}
		}
		
		public String getUname() { return uname; }
		
		@Override
		public void run() {
			while(isRunning) {
				String mString  = receive(); //接收
				
				System.out.println("服务器收到消息mString:"+mString);
				
				if(mString.indexOf("=") != -1) {
					uname = mString.substring(mString.indexOf("=")+1);
					send("欢迎你的到来");
					sendOthers(uname+"加入群聊");
				}
				else if(mString.charAt(0) == '@') {
					sendPrivate(uname+"对你说:"+mString.substring(mString.indexOf(":")+1),mString.substring(1, mString.indexOf(":")));
				}
				else {
					if(mString != "") sendOthers(uname+"对大家说："+mString);
				}
			}
		}
		
		//接收消息
		private String receive() {
			String mString = "";
			try {
				mString = dis.readUTF();
			} catch (IOException e) {
				System.err.println("服务器接收消息失败");
				release();
				//e.printStackTrace();
			}
			return mString;
		}
		
		//发送消息
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				System.err.println("发送消息失败");
				//e.printStackTrace();
			}
		}
		
		//群发消息
		private void sendOthers(String msg) {
			for(Channel other : all) {
				if(other == this) continue;
				other.send(msg);
			}
		}
		
		//私发消息
		private void sendPrivate(String msg, String toname) {
			System.out.println("服务器收到私发消息-->"+msg+"-->"+toname);
			for(Channel other : all) {
				if(other.getUname().equals(toname)) {
					other.send(msg);
					break;
				}
			}
		}
		
		//释放资源
		public void release() {
			CloseUtils.close(dos,dis,client);
			isRunning = false;
		}
		
	}
	
}


