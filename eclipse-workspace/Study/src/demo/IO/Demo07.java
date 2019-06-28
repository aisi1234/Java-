package demo.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *	对象序列化和反序列化，对象必须实现Serializable接口
 *	java.io.ObjectOutputStream:对象序列化流
 *	作用：把对象以流的方式写入到文件中保存
 *	特有的成员方法：
 *		- void writeObject(Object obj) 将指定的对象写入ObjectOutputStream流
 *	java.io.ObjectInputStream:对象反序列化流
 *		反序列化前提：
 *			1.对象必须实现 Serializable 接口
 *			2.必须存在该类的class文件
 *		
 *	static关键字：静态关键字
 *		静态优先于非静态加载到内存中（静态优先于对象进入到内存中）
 *		被static修饰的成员变量不能被序列化，序列化的都是对象
 *
 *	transient关键字：瞬态关键字
 *		被transient修饰的成员变量不能被序列化	
 * @author HASEE
 *
 */

public class Demo07 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"));
		oos.writeObject(new Person("Tom",123));
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"));
		Person mPerson = (Person) ois.readObject();
		System.out.println(mPerson.getName()+":"+mPerson.getAge());
		ois.close();
	}
}
