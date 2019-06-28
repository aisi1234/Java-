package com.hasee.loc;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * UPI:Universal Resource Identifier,统一资源标识符符，用来表示抽象或物理资源的一个紧凑字符串
 * UPL：Universal Resource Locator, 统一资源定位符，一种定位资源的只要访问机制的字符串，一个标准的URL应该包括：
 * 	   protocol、host、port、path、parameter、anchor
 *
 */

public class UPLTest01 {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://www.baidu.com:80/index.html?uname=shsxt&&age=18#a");
		
		System.out.println("协议："+url.getProtocol()); //获取协议
		System.out.println("域名|ip："+url.getHost());
		System.out.println("端口："+url.getPort());
		System.out.println("请求资源："+url.getFile());
		System.out.println("请求资源："+url.getPath());
		
		//参数
		System.out.println("参数："+url.getQuery());
		//锚点
		System.out.println("锚点："+url.getRef());
	}
}
