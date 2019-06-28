package com.hasee.loc;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPTest {
	public static void main(String[] args) throws UnknownHostException {
		 //使用getLocalHost方法创建InetAddress对象 本机
		 InetAddress addr = InetAddress.getLocalHost();
		 System.out.println(addr.getHostAddress()); //返回主机地址
		 System.err.println(addr.getHostName()); //返回主机名
		 
		 //根据域名得到InetAddress对象
		 addr = InetAddress.getByName("www.baidu.com");
		 System.out.println(addr.getHostAddress());
		 System.out.println(addr.getHostName());
		 
		 //根据IP得到InetAddress对象
		 addr = InetAddress.getByName("180.97.33.107");
		 System.out.println(addr.getHostAddress());
		 System.out.println(addr.getHostName());
	}
}
