package demo.File;

import java.io.File;

/**
 * File类
 * 1.获取功能
 * 		- public String getAsolutePath()
 * 		- public String getPath()
 * 		- public String getName()
 * 		- public long length() :返回由此File表示的文件的长度
 * 3.创建删除功能
 * 		- public boolean createNewFile() :当且仅当具有该名称的文件上不存在时，创建一个新的空的文件夹
 * 		- public boolean delete() ：删除由此File表示的文件或文件夹
 * 		- public boolean mkdir() ：创建由此File表示的目录
 * 		- public boolean mkdirs() ：创建由此File表示的目录，单级或者多级目录
 * 3.判断功能
 * 		- public boolean exists()
 * 		- public boolean isFile()
 * 		- public boolean isDirectory()
 * 4.遍历功能
 * 		- public String[] list()
 * 		- public File[] listFiles()
 * 	注意：
 * 		两个方法遍历的是构造方法提供的目录
 * 		如果构造方法中给出的目录不存在或者不是目录，会抛出控制针异常
 * 		
 * @author HASEE
 *
 */

public class Demo01 {
	public static void main(String[] args) {
	}
}	
