package demo.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Demo05 {
	public static void main(String[] args) throws IOException {
		//write_utf_8();
		//write_gbk();
		//read_utf_8();
		read_gbk();
	}
	
	/*
	 * 使用OutputStream写指定格式的文件，不指定时默认是utf-8
	 */
	public static void write_utf_8() throws IOException {
		//OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("a.txt")); //不指定市默认为uft-8
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("a.txt"), "utf-8");
		osw.write("你好");
		osw.flush();
		osw.close();
	}
	public static void write_gbk() throws IOException {
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("b.txt"), "gbk");
		osw.write("你好");
		osw.flush();
		osw.close();
	}
	/*
	 * 使用InputStreamReader读指定格式的文件，不指定市默认为utf-8
	 */
	public static void read_utf_8() throws IOException, FileNotFoundException {		
		//InputStreamReader isr = new InputStreamReader("a.txt"); //不指定市默认为uft-8
		InputStreamReader isr = new InputStreamReader(new FileInputStream("a.txt"),"utf-8");
		
		int len=0;
		while((len = isr.read())!=-1) {
			System.out.println((char)len);
		}
		
		isr.close();
	}
	public static void read_gbk() throws IOException, FileNotFoundException {		
		//InputStreamReader isr = new InputStreamReader("a.txt"); //不指定市默认为uft-8
		InputStreamReader isr = new InputStreamReader(new FileInputStream("b.txt"),"gbk");
		
		int len=0;
		while((len = isr.read())!=-1) {
			System.out.println((char)len);
		}
		
		isr.close();
	}
}
