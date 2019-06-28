package com.hasee.server.basic;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射
 * 1.加载类(3种方式)
 * 2.创建类对象 newInstance()
 * 3.获取属性 
 * 		- getField()
 * 		- getDeclaredFields()
 * 4.获取构造器
 * 		- getConstructor()
 * 		- getDeclaredConstructor()
 * 5.获取方法
 * 		- getMethod
 * 		- getDeclaredConstructor()
 * 6.获取注解
 * 		- getAnnotation()
 * @author HASEE
 *
 */

public class ReflectionTest02 {
	public static void main(String[] args) throws Exception {
		//通过反射获取加载类
		Class<Student> cl = (Class<Student>) Class.forName("com.hasee.server.basic.Student");
		//通过加载得到的类创建对象
		Student stu = cl.newInstance(); //实际调用的是Student的午餐构造
		//通过获得类的有参构造器创建对象
		Constructor<Student> constructor = cl.getDeclaredConstructor(String.class,int.class,String.class);
		Student stu2 = (Student) constructor.newInstance("2016",18,"Tom");
		//直接通过对象调用方法和通过反射API调用方法
		stu.setName("Bob");
		Method method = cl.getDeclaredMethod("setName", String.class);
		method.invoke(stu2, "Bob1");
		System.out.println(stu2.getName());
		
		//通过反射API操作属性
		Student stu3 = cl.newInstance();
		Field field = cl.getDeclaredField("name");
		field.setAccessible(true); //取消安全检查，可以直接访问私有属性
		field.set(stu3, "123");
		System.out.println(stu3.getName());
	}
}
