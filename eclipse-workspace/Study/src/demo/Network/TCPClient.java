package demo.Network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
1.java.net.Socket:实现客户端套接字。
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
*/
public class TCPClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("127.0.0.1", 8088);
		OutputStream ops = client.getOutputStream();
		InputStream ips = client.getInputStream();
		ops.write("你好".getBytes());
		
		byte[] bs = new byte[1024];
		int len = ips.read(bs);
		System.out.println(new String(bs, 0, len));
		
		ops.close();
		ips.close();
		client.close();
	}
}
