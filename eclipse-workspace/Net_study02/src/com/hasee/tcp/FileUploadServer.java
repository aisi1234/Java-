package com.hasee.tcp;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟用户登录服务器
 * 创建服务器
 * 1.指定端口，使用ServerSocket创建服务器
 * 2.阻塞式等待连接 accept()
 * 3.操作：输入输出流操作
 * 4.释放资源
 * @author HASEE
 *
 */

public class FileUploadServer {
	public static void main(String[] args) throws IOException {
		
		System.out.println("-----服务端-----");
		//将由客户端上传的文件保存到当前目录下
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.jpg"));
		
		//创建对象
		ServerSocket socket = new ServerSocket(8888);
		//获取连接
		Socket client = socket.accept();
		System.out.println("一个客户端连接");
		//流操作
		DataInputStream dis = new DataInputStream(client.getInputStream());
		byte[] datas = new byte[1024*60];
		int len = -1;
		while((len = dis.read(datas)) != -1) {
			bos.write(datas, 0, len);
		}

		//释放资源
		dis.close();
		client.close();
		socket.close();
		bos.close();
	}
}
