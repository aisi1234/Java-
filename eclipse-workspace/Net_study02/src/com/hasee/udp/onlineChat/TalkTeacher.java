package com.hasee.udp.onlineChat;

public class TalkTeacher {
	public static void main(String[] args) {
		new Thread(new TalkReciveThread(9999)).start(); //接受
		new Thread(new TalkSendThread(5555,"localhost",8888,"Theacher_Alice")).start(); //发送
	}
}
