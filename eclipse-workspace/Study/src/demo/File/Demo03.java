package demo.File;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 文件过滤器 FileFilter、FilenameFilter
 * File类中的两个方法
 * - File[] listFiles(FileFilter filter)
 * 		FileFilter：接口，用于抽象路径名的过滤器
 * 		作用：用来过滤文件（File对象）
 * 		抽象方法：用来过滤文件的方法
 * 			boolean accept(File pathname) 测试指定抽象路径名是否应该包含在某个路径名列表中
 * 			参数：
 * 				File pathname：使用listFiles方法遍历目录，得到的每一个文件对象 
 * - File[] listFiles(FilenameFilter filter)
 * 		FilenameFileter：接口，实现此接口的实例可用于过滤器文件名
 * 			作用：用于过滤文件名称
 * 			抽象方法：用来过滤文件的方法
 * 				boolean accept(File dir,String name) 测试指定文件是否包含应该包含在某一文件列表中
 * 				参数：
 * 					File dir:构造方法中传递的被遍历的目录
 * 					String name:使用listFiles方法遍历目录，获取的每一个文件/文件夹
 * @author HASEE
 *
 */

public class Demo03 {
	public static void main(String[] args) {
		printFiles(new File("F:\\ACM"));
	}
	
	public static void printFiles(File f) {
		//File[] files = f.listFiles(new FileFilterImpl());
		
		//使用FileNameFileter的匿名内部类
//		File[] files = f.listFiles(new FilenameFilter() {
//			
//			@Override
//			public boolean accept(File dir, String name) {
//				return new File(dir,name).isDirectory() || name.endsWith(".cpp");
//			}
//		});
		
		//使用Lambda表达式
		File[] files = f.listFiles((dir,name)->new File(dir, name).isDirectory() || name.endsWith(".cpp"));
		
		for(File file:files) {
			if(file.isDirectory()) {
				printFiles(file);
			}else {
				System.out.println(file);
			}
		}
	}
}
