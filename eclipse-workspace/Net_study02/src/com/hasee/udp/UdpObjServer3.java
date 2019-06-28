package com.hasee.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

/**
 * 引用类型：接收端
 * 1.使用DatagramSocket 指定端口 创建接受端
 * 2.准备容器 封装成DatagramPacket包裹
 * 3.阻塞式接受包裹receive(DatagramPacket p)
 * 4.分析数据 将字节数组还原为对应类型对象 
 * 		byte[] getDate() 
 * 		getLength()
 * 5.释放资源
 * @author HASEE
 *
 */

public class UdpObjServer3 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("接收端启动中。。。");

		//1.使用DatagramSocket 指定端口 创建接受端
		DatagramSocket server = new DatagramSocket(9999);
		
		//2.准备容器 封装成DatagramPacket包裹
		byte[] container = new byte[1024];
		DatagramPacket packet = new DatagramPacket(container, 0, container.length);
		
		//3.阻塞式接受包裹receive(DatagramPacket p) 
		server.receive(packet);
		
		//4.分析数据 将字节数组还原为对应类型对象 
		//byte[] getDate() 
		//getLength()
		byte[] datas = packet.getData();
		System.out.println(new String(datas,0,datas.length));
		
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		//顺序与写出一致
//		oos.writeUTF("编程辛酸泪");
//		oos.writeInt(18);
//		oos.writeBoolean(true);
//		oos.writeDouble(12.1);
//		//对象
//		oos.writeObject("谁解其中味");
//		oos.writeObject(new Date());
//		oos.writeObject(new Person("张三",123));
		String str = ois.readUTF();
		System.out.println(str);
		int x = ois.readInt();
		System.out.println(x);
		boolean flag = ois.readBoolean();
		System.out.println(flag);
		double d = ois.readDouble();
		System.out.println(d);
		
		Object str1 = ois.readObject();
		Object date = ois.readObject();
		Object person = ois.readObject();
		
		if(str1 instanceof String) {
			str1 = (String)str1;
			System.out.println(str1);
		}
		if(date instanceof Date) {
			date = (Date)date;
			System.err.println(date);
		}
		if(person instanceof Person) {
			person = (Person)person;
			System.out.println(((Person) person).name);
		}
		
		//5.释放资源
		server.close();
		ois.close();
	}
}
