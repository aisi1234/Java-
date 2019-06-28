package demo.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ****************************************
 * 		*	输入流		*	输出流		  *
 * 字节流	*	InputStream	*	OutputStream  *
 * 字符流	*	Reader		*	Writer		  *
 * ****************************************
 * @author HASEE
 *
 */

/**
 * java.io.OutputStream:字节输出流
 * 成员方法：
 * - void close()  关闭此输出流并释放与此流有关的所有系统资源。 
 * - void flush() 刷新此输出流并强制写出所有缓冲的输出字节。 
 * - void write(byte[] b) 将 b.length 个字节从指定的 byte 数组写入此输出流。 
 *		注意：如果写的第一个数是正数（0-127），那么显示的时候会查询ASCII码表
 *			***如果写的第一个数是负数，那么第一个字节会和第二个字节一起组成一个中文显示，查询系统默认码表（gbk）***
 * - void write(byte[] b, int off, int len) 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。 
 * - abstract  void write(int b)    将指定的字节写入此输出流。 
 * @author HASEE
 *
 *	换行符：windows \r\n
 *		 Linux /n
 *		 mac /r
 */

public class Demo01 {
	public static void main(String[] args) throws IOException {
//		FileOutputStream fos = new FileOutputStream("a.txt");
//		byte[] bs = {-65,-66,-67,68,69}; //烤紻E
//		fos.write(bs);
//		fos.close();
		
		FileInputStream fis = new FileInputStream("a.txt");
		int len;
		while((len=fis.read()) != -1) {
			System.out.println((char)len);
		}
		fis.close();
	}
}
