package com.hasee.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 目标：返回响应协议
 * 
 * @author HASEE
 *
 */

public class Server02 {
	private ServerSocket serverSocket;

	public static void main(String[] args) {
		Server02 server = new Server02();
		server.start();
		server.receive();
	}

	// 启动服务
	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
		} catch (IOException e) {
			System.err.println("服务器启动失败...");
		}
	}

	// 接收连接
	public void receive() {
		try {
			Socket client = serverSocket.accept();
			System.out.println("一个客户端建立了连接...");
			InputStream is = client.getInputStream();
			byte[] datas = new byte[1024 * 1024];
			int len = is.read(datas);
			String requestInfo = new String(datas, 0, len);
			System.out.println(requestInfo);

			StringBuilder content = new StringBuilder();
			content.append("<html>");
			content.append("<head>");
			content.append("<title>");
			content.append("服务器响应成功");
			content.append("</title>");
			content.append("</head>");
			content.append("<body>");
			content.append("这是服务器对你做出的响应，你好");
			content.append("</body>");
			content.append("</html>");
			int size = content.toString().getBytes().length;
			//返回响应
			StringBuilder responseInfo = new StringBuilder();
			String blank = " ";
			String CRLF = "\r\n";
			//1.响应状态行
			responseInfo.append("HTTP/1.1").append(blank);
			responseInfo.append(200).append(blank);
			responseInfo.append("OK").append(CRLF);
			//2.响应头（最后一行存在空行）
			responseInfo.append("Date:").append(new Date()).append(CRLF);
			responseInfo.append("Server:").append("hasee Server/0.0.1;charset=GBK").append(CRLF);
			responseInfo.append("Content-type:text/html").append(CRLF);
			responseInfo.append("Content-length:").append(size).append(CRLF);
			responseInfo.append(CRLF);
			//3.正文
			responseInfo.append(content.toString());

			/*
			 * Server: nginx Date: Tue, 11 Jun 2019 02:45:16 GMT Content-Type: text/html
			 * Content-Length: 914 Connection: close Expires: Mon, 31 Dec 2001 23:59:59 GMT
			 * Pragma: no-cache Cache-Control: no-store, no-cache, pre-check=0, post-check=0
			 * X-Content-Type-Options: nosniff
			 * 
			 * 
			 * StringBuilder responseInfo = new StringBuilder(); String blank = " "; String
			 * CRLF = "\r\n"; responseInfo.append("Server: nginx").append(CRLF);
			 * responseInfo.append("Date: ").append(new Date()).append(CRLF);
			 * responseInfo.append("Content-Length: ").append(size).append(CRLF);
			 * responseInfo.append("Connection: close").append(CRLF);
			 * responseInfo.append("Expires: Mon, 31 Dec 2001 23:59:59 GMT").append(CRLF);
			 * responseInfo.append("Pragma: no-cache").append(CRLF); responseInfo.
			 * append("Cache-Control: no-store, no-cache, pre-check=0, post-check=0").append
			 * (CRLF); responseInfo.append("X-Content-Type-Options: nosniff").append(CRLF);
			 */

			// 写出到客户端
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(requestInfo);
			bw.flush();

		} catch (IOException e) {
			System.err.println("客户端连接失败...");
		}
	}

	// 停止服务
	public void stop() {

	}
}
