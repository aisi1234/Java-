package com.hasee.tcp;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 模拟用户登录
 * 登录客户端
 * 1.使用Socket创建客户端，创建时指明IP地址和端口
 * 2.操作：输入输出流操作
 * 3.释放资源
 * @author HASEE
 *
 */

public class FileUploadClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.println("-----客户端-----");
		//获取C:\\Users\\HASEE\\Pictures\\桌面壁纸 下的图片
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\HASEE\\Pictures\\桌面壁纸\\saber-005.jpg"));
		//创建客户端
		Socket client = new Socket("localhost", 8888);
		//流操作
		OutputStream os = client.getOutputStream();
		byte[] datas = new byte[1024*60];
		int len=-1;
		while((len = bis.read(datas)) != -1) {
			os.write(datas, 0, len);
		}
		//释放资源
		os.close();
		bis.close();
		client.close();
	}
}
