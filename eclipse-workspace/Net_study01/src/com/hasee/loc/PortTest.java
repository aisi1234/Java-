package com.hasee.loc;

/**
 * dos命令(可用来查看端口冲突)：
 * 		1.查看所有端口：netstat -ano
 * 		2.查看指定端口：netstat -ano|findstr "端口号"
 * 		3.查看指定进程：tasklist|findstr "端口号"
 * 		4.查看具体程序：使用任务管理器查看PID
 *
 *	IntelSocketAddress类：包含端口，用于socket通信
 *		1.构造器：
 *			- InetSocketAddress(String hostname, int port) 从主机名和端口号创建套接字地址。 
 *		2.方法：
 *			- InetAddress getAddress() 获得 InetAddress。
 *			- int getPort() 获取端口号。    
 *			- String getHostName() 获得 hostname。  
 */
public class PortTest {
	
	public static void main(String[] args) {
		
	}
}
