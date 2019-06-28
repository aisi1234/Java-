package demo.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * JDK7新特性
 * 在try的后边可以增加一个()，在括号中可以定义流对象，那么流对象的作用域只在try块中
 * try块中的代码执行完毕，自动释放资源，不用谢finally
 * 格式：
 * 		try(定义流对象){
 * 			可能产生异常的代码
 * 		}catch(异常类型 变量){
 * 			  		
 * 		}
 * 
 * JDK9新特性
 * try的前边可以定义流对象
 * 在try后边的()中可以直接引用流对象的名次（变量名）
 * 在try块中的代码执行完毕后，流对象自动释放，不用书写finally
 * 格式:
 * 		A a = new A();
 * 		B b = new B();
 * 		try(a,b){
 * 			可能产生异常的代码
 * 		}catch{
 * 
 * 		}
 * @author HASEE
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		
	}
	
	public static void testJDK7() {
		try(
			FileInputStream fis = new FileInputStream("C:\\Users\\HASEE\\Pictures\\桌面壁纸\\saber-002.jpg");
			FileOutputStream fos = new FileOutputStream("copy.jpg");
			){
			byte[] bs = new byte[1024];
			int len=0;
			while((len=fis.read(bs)) != -1) {
				fos.write(bs);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
//	public static void testJDK9() {
//		FileInputStream fis = new FileInputStream("C:\\Users\\HASEE\\Pictures\\桌面壁纸\\saber-002.jpg");
//		FileOutputStream fos = new FileOutputStream("copy.jpg");
//		try(fis;fos){
//			byte[] bs = new byte[1024];
//			int len=0;
//			while((len=fis.read(bs)) != -1) {
//				fos.write(bs);
//			}
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
}
