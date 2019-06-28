package com.hasee.udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;

/**
 * 引用类型：发送端
 * 1.使用DatagramSocket 指定端口 创建发送端
 * 2.准备数据 将对象转换为字节数组
 * 3.封装成DatagramPacket包裹，需要指定目的地
 * 4.发送包裹send(DatagramPacket p)
 * 5.释放资源
 * @author HASEE
 *
 */
public class UdpObjClient3 {
	public static void main(String[] args) throws IOException {
		System.out.println("发送方启动中。。。");
		
		//1.使用DatagramSocket 指定端口 创建发送端
		DatagramSocket client = new DatagramSocket(8888);
		
		//2.准备数据 将对象转换为字节数组
		//写出
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
		oos.writeUTF("编程辛酸泪");
		
		oos.writeInt(18);
		oos.writeBoolean(true);
		oos.writeDouble(12.1);
		//对象
		oos.writeObject("谁解其中味");
		oos.writeObject(new Date());
		oos.writeObject(new Person("张三",123));
		oos.flush();
		
		byte[] datas = baos.toByteArray();
		
		//3.封装成DatagramPacket包裹，需要指定目的地
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, 
				new InetSocketAddress("localhost", 9999));
		
		//4.发送包裹send(DatagramPacket p)
		client.send(packet);
		
		//5.释放资源
		client.close();
		baos.close();
		oos.close();
	}
}
