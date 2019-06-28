package com.hasee.udp.onlineChat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReciveThread implements Runnable {
	
	private DatagramSocket server; //服务器
	//private int port; //服务器用接受数据的端口号
	
	public TalkReciveThread(int port) {
		super();
		//this.port = port;
		try {
			//创建接收端对象
			server = new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}


	@Override
	public void run() {
		try {
			while(true) {
				//准备容器
				//封装成DatagamPacket包裹
				byte[] container = new byte[1024*60];
				DatagramPacket packet = new DatagramPacket(container, 0, container.length);
				//阻塞式接受
				server.receive(packet);
				//处理数据
				byte[] datas = packet.getData();
				int len = packet.getLength();
				String string = new String(datas, 0, len);
				System.out.println(string);
				if(string.equals("byte")) {
					break;
				}
			}
			//关闭资源
			server.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
