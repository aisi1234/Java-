package demo.Network;

/**
 * TCP通信程序
 * Java中，提供了两个类用于实现TCP通信程序
 * 	1.java.net.Socket:实现客户端套接字。
 * 	构造方法：
 * 		- Socket(String host, int port) 创建流套接字并将其连接到指定主机上的指定端口号。 
 * 		参数：
 * 			String host：服务器主机地址/服务器IP地址
 * 			int port：服务器端口号
 * 	成员方法：
 * 		- OutputStream getOutputStream() 返回此套接字的输出流。  
 * 		- InputStream getInputStream() 返回此套接字的输入流。  
 * 		- void close() 关闭此套接字。 
 * 
 * 	注意：
 * 		1.客户端和服务端通信，必须使用Socket中提供的网络流，不能自己创建流对象
 * 		2.当我们创建客户端对象Socket的时候，就会去请求服务器，和服务器经过3次握手建立连接
 * 			这是如果服务器没启动，会抛出异常
 * @author HASEE
 *
 */

public class Demo02 {
	public static void main(String[] args) {
		
	}
}



