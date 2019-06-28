package com.hasee.udp.onlineChat;

public class TalkStudent {
	public static void main(String[] args) {
		new Thread(new TalkSendThread(7777, "localhost", 9999, "Student_Tom")).start(); //发送
		new Thread(new TalkReciveThread(8888)).start(); //接收
	}
}
