package demo.File;

import java.io.File;

/**
 * 遍历文件夹
 * @author HASEE
 *
 */

public class Demo02 {
	public static void main(String[] args) {
		printFiles(new File("F:\\ACM"));
	}
	
	public static void printFiles(File f) {
		//File f = new File(path);
		if(f.isDirectory()) {
			File[] files = f.listFiles();
			for(File file: files) {
				printFiles(file);
				//System.out.println();
			}
		}else {
			if(f.toString().endsWith(".cpp")) System.out.println(f);
		}
	}
}
