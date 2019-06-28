package com.hasee.udp.onlineChat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;


public class TalkSendThread implements Runnable {
	
	private DatagramSocket client; //客户端
	BufferedReader br; //输入缓冲流
	
	//private int port; //发送端口
	private String toIP; //服务端IP地址
	private int toPort; //服务端接受端口号
	private String name; //客户端姓名
	
	public TalkSendThread() {}
	
	public TalkSendThread(int port, String toIP, int toPort, String name) {
		super();
		//this.port = port;
		this.toIP = toIP;
		this.toPort = toPort;
		this.name = name;
		
		
		try {
			//创建发送端
			client = new DatagramSocket(port);
			//创建控制台的输入流
			br = new BufferedReader(new InputStreamReader(System.in));
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public void run() {
		try {
			while(true) {
				//读取数据
				String data =name+"说:"+br.readLine();
				//转换为字节数组
				byte[] datas = data.getBytes();
				//将转换后的字节数组封装为DatagramSocket包裹，指定了目的地IP地址和端口号
				DatagramPacket packet = new DatagramPacket(datas, datas.length, new InetSocketAddress(toIP, toPort));
				//发送数据
				client.send(packet);
				
				if(data.equals("bye")) break;
			}
			//关闭资源
			br.close();
			client.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
