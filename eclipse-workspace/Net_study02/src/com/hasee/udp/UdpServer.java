package com.hasee.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收端
 * 1.使用DatagramSocket 指定端口 创建接受端
 * 2.准备容器 封装成DatagramPacket包裹
 * 3.阻塞式接受包裹receive(DatagramPacket p)
 * 4.分析数据 
 * 		byte[] getDate() 
 * 		getLength()
 * 5.释放资源
 * @author HASEE
 *
 */

public class UdpServer {
	public static void main(String[] args) throws IOException {
		System.out.println("接收端启动中。。。");
		
		//1.使用DatagramSocket 指定端口 创建接受端
		DatagramSocket server = new DatagramSocket(9999); 
		
		//2.准备容器 封装成DatagramPacket包裹
		byte[] container = new byte[1024];
		DatagramPacket packet = new DatagramPacket(container, 0, container.length);
		
		//3.阻塞式接受包裹receive(DatagramPacket p)
		server.receive(packet);
		
		//4.分析数据 
		//byte[] getDate() 
		//getLength()
		byte[] datas = packet.getData();
		System.out.println(new String(datas,0,datas.length));
		
		//5.释放资源
		server.close();
	}
}
