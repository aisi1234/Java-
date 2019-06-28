package demo.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * java.io.InputStream类
 * 成员方法：
 * - int read():读取第一字节并返回该字节的编码值，读到文件末尾返回-1
 * - int read(byte[] b):读取一定数量的字节，保存到b数组中，并返回读取的字节的个数，读到文件末尾是返回-1
 * @author HASEE
 *
 */

public class Demo02 {
	public static void main(String[] args) throws IOException {
		copyPicture();
	}
	
	/*
	 * 文件复制
	 */
	public static void copyPicture() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\HASEE\\Pictures\\桌面壁纸\\saber-002.jpg");
		FileOutputStream fos = new FileOutputStream("copy.jpg");
		byte[] bs = new byte[1024];
		int len=0;
		while((len=fis.read(bs)) != -1) {
			fos.write(bs);
		}
		fis.close();
		fos.close();
	}
}
