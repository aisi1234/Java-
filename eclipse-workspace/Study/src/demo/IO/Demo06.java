package demo.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
 * @author HASEE
 *
 */
public class Demo06 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//renameFile();
		changeFileChaset("a.txt", "b.txt", "utf-8", "gbk");
	}
	
	/*
	 * 转换文件编码
	 */
	public static void changeFileChaset(String oldPathname,String newPathname, String oldCharset, String newCharset) throws IOException, FileNotFoundException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream(oldPathname),oldCharset);
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(newPathname), newCharset);
		
		int len=0;
		while((len = isr.read()) != -1) {
			osw.write(len);
		}
		
		isr.close();
		osw.close();
	}
	
	/*
	 * 修改文件名称
	 */
	public static void renameFile() {
		File oldFile = new File("a.txt");
		oldFile.renameTo(new File("c.txt"));
	}
}
