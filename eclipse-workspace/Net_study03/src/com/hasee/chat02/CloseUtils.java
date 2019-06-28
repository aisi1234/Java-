package com.hasee.chat02;

import java.io.Closeable;
import java.io.IOException;

/**
 * 工具类，释放资源
 * @author HASEE
 *
 */

public class CloseUtils {
	
	public static void close(Closeable...closeables ) {
		for(Closeable closeable : closeables) {
			if(null != closeable) {
				try {
					closeable.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
