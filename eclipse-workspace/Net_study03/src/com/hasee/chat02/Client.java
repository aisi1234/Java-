package com.hasee.chat02;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 群聊，客户端
 * @author HASEE
 *
 */

public class Client {
	public static void main(String[] args) {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		try {
//			System.out.println("*****客户端*****");
//			Socket client = new Socket("localhost", 8888);
//			
//			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
//			DataInputStream dis = new DataInputStream(client.getInputStream());
//			String string;
//			while((string = br.readLine()) != null) {
//				dos.writeUTF(string);
//				dos.flush();
//				
//				System.out.println(dis.readUTF());
//			}
//			
//			dis.close();
//			dos.close();
//			client.close();
//			br.close();
//		} catch (IOException e) {
//			System.err.println("客户端创建失败");
//			//e.printStackTrace();
//		}
		
		System.out.println("*****客户端*****");
		Socket client;
		try {
			client = new Socket("localhost", 8888);
			new Thread(new Send(client)).start();
			new Thread(new Receive(client)).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
