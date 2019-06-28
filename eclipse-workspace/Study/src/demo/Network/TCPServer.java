package demo.Network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ServerSocket:创建服务端类
 * @author HASEE
 *
 */

public class TCPServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8088);
		Socket socket = server.accept();
		
		InputStream ips = socket.getInputStream();
		OutputStream ops = socket.getOutputStream();
		
		byte[] bs = new byte[1024];
		int len = ips.read(bs);
		System.out.println(new String(bs,0,len));
		
		ops.write("收到，谢谢".getBytes());
		
		ops.close();
		ips.close();
		socket.close();
		server.close();
	}
}
