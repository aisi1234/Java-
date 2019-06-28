package demo01.Lambda;

import java.util.Arrays;

public class Demo01Lambda {
	public static void main(String[] args) {
		//使用Lambda实现多线程
		//new Thread(()-> System.out.println(Thread.currentThread().getName()+"新线程创建了 ")).start();
		
		Person[]  arr = {
			new Person("person1",35),
			new Person("person2",20),
			new Person("person3",23)
		};
		
//		Arrays.sort(arr, new Comparator<Person>() {
//
//			@Override
//			public int compare(Person o1, Person o2) {
//				return o1.getAge()-o2.getAge();
//			}
//			
//		});
		
		//使用Lambda表达式简化匿名内部类
		Arrays.sort(arr, (o1,o2)->{
			return o1.getAge()-o2.getAge();
		});
		
		/*
		 * Lambda表达式：可推导，可省略
		 * 凡是根据上下文推导出来的内容，都可以省略书写
		 * 可以省略的内容：
		 * 		1、(参数列表)：括号中的参数类型可以省略
		 * 		2、(参数列表)：如果只有一个参数，可以省略括号和参数类型
		 * 		3、{一些代码}：如果{}中只有一行代码，无论是否有返回值，可省略{}、return和分号，但是要一起省略
		 */
//		Arrays.sort(arr, (o1,o2)->o1.getAge()-o2.getAge());
		
		for (Person person : arr) {
			System.err.println(person.toString());
		}
		
	}
}
