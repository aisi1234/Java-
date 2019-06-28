package demo.IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

/**
 * public class Properties extends Hashtable<Object,Object>Properties 类
 * 表示了一个持久的属性集。Properties 可保存在流中或从流中加载。属性列表中每个键及其对应值都是一个字符串。
 * Properties是一个双列集合，key个value默认是字符串
 * @author HASEE
 *
 */

public class Demo04 {
	public static void main(String[] args) throws IOException {
		//show01();
		//show02();
		show03();
	}
	
	/*
	 * 可以使用Properties集合中的load方法，把硬盘中的数据（键值对）读取到集合中使用
	 * - void load(InputStream inStream) 从输入流中读取属性列表（键和元素对）。 
 	 * - void load(Reader reader) 按简单的面向行的格式从输入字符流中读取属性列表（键和元素对）。 
 	 * 参数：
 	 * 		InputStream inStream：字节输入流，不能读入包含中文的键值对
 	 * 		Reader reader：字符输入流，可以读取包含中文的键值对
 	 * 使用步骤：
 	 * 		1.创建Properties对象
 	 * 		2.调用Properties集合对象的load方法读取保存键值对的文件
 	 * 		3.遍历Properties集合
 	 * 注意：
 	 * 		1.存储键值对的文件中，键与值默认的连接符号可以使用+，空格（其他符号）
 	 * 		2.存储键值对的文件中，可以使用#进行注释，被注释的键值对不能再被读取
 	 * 		3.存储键值对的文件中，键与值默认都是字符串，不用再加引号
	 */
	public static void show03() throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileReader("prop.txt"));
		
		Set<String> set = properties.stringPropertyNames();
		for(String key : set) {
			System.out.println(key+":"+properties.getProperty(key));
		}
		
	}
	
	/*
	 * 可以使用Properties集合中的store方法，把集合中的临时数据持久化的写入到硬盘中
	 * - void store(OutputStream out, String comments) 以适合使用 load(InputStream) 方法加载到 Properties 表中的格式，将此 Properties 表中的属性列表（键和元素对）写入输出流。 
 	 * - void store(Writer writer, String comments) 以适合使用 load(Reader) 方法的格式，将此 Properties 表中的属性列表（键和元素对）写入输出字符。 
 	 * 参数：
 	 * 		OutputStream out：字节输出流，不能写入中文
 	 * 		Writer writer：字符输入流，可以写入中文
 	 * 		String comments：注释，用来解释说明保存的文件是做什么用的
 	 * 			不能使用中文，会产生乱码，默认是Unicode编码，一般使用空字符串
 	 * 使用步骤：
 	 * 		1.创建Properties集合对象，添加数据
 	 * 		2.创建字节输出流/字符输出流对象，构造方法绑定到要输出的目的地
 	 * 		3.使用Properties集合中的方法store，把集合中的临时数据持久化写入到硬盘中存储
 	 * 		4.释放资源
	 */
	public static void show02() throws IOException {
		Properties properties = new Properties();
		properties.setProperty("Tom", "123");
		properties.setProperty("Alice", "aaa");
		properties.setProperty("Sufei", "1a3");
		
		FileWriter fw = new FileWriter("prop.txt");
		
		properties.store(fw, "save data");
		
		fw.close();
	}
	
	/*
	 * 使用Properties集合存储数据，遍历取出Properties集合中的数据
	 * Properties集合有一些操作字符串的特有方法
	 * - Object setProperty(String key, String value) 调用 Hashtable 的方法 put。 
	 * - String getProperty(String key) 用指定的键在此属性列表中搜索属性。 
	 * - Set<String> stringPropertyNames() 返回此属性列表中的键集，其中该键及其对应值是字符串，如果在主属性列表中未找到同名的键，则还包括默认属性列表中不同的键。相当于Map中的keySet方法 
	 */
	public static void show01() {
		Properties properties = new Properties();
		properties.setProperty("Tom", "123");
		properties.setProperty("Alice", "aaa");
		properties.setProperty("Sufei", "1a3");
		
		Set<String> set = properties.stringPropertyNames();
		for(String key:set) {
			System.out.println(key+":"+properties.getProperty(key));
		}
		
	}
}
