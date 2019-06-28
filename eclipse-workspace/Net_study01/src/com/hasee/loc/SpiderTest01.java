package com.hasee.loc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



/**
 * 网络爬虫原理
 * @author HASEE
 *
 */
public class SpiderTest01 {
	public static void main(String[] args) throws IOException {
		//获取URL
//		URL url = new URL("https://www.jd.com");
//		InputStream is = url.openStream();
		URL url = new URL("https://www.dianping.com/");//直接访问会被拒绝访问 
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");
		//下载资源
		
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
		String msg = null;
		while(null != (msg = br.readLine())) {
			System.out.println(msg);
		}
		//分析
		//处理
	}
}
