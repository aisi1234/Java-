package demo.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * 练习：集合序列化
 * 		当我们需要保存多个对象是，可以将对象保存到集合中
 * 		然后对集合进行序列化和反序列化
 * @author HASEE
 *
 */

public class Demo08 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		//write();
		read();
	}
	
	public static void write() throws FileNotFoundException, IOException {
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("张三",123));
		list.add(new Person("李四",12));
		list.add(new Person("王五",56));
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"));
		oos.writeObject(list);
		oos.close();
	}
	
	public static void read() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"));
		ArrayList<Person> list = (ArrayList<Person>) ois.readObject();
		for(Person mPerson : list) {
			System.out.println(mPerson.getName()+":"+mPerson.getAge());
		}
		ois.close();
	}
}
