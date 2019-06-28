package com.hasee.server.basic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 反射,打印类
 * 可通过Class.forName(包名.类名).newInstance() 创建该类的对象
 * @author HASEE
 *
 */

public class ReflectionTest {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("输入一个类（eg:java.util.Date）：");
		String name = input.next();
		input.close();
		
		try {
			Class cl = Class.forName(name);
			//获取类的父类
			Class superClass = cl.getSuperclass();
			//获取类的修饰符
			String modifiers = Modifier.toString(cl.getModifiers()); 
			if(modifiers.length()>0) System.out.print(modifiers+" ");
			System.out.print("class "+name);
			if(superClass != null && superClass != Object.class) System.out.print("extends "+superClass.getName());
			System.out.print("\n{\n");
			printFileds(cl);
			System.out.println();
			printConstructors(cl);
			System.out.println();
			printMethods(cl);
			System.out.println("}");
			
		} catch (ClassNotFoundException e) {
			System.err.println("未找到该类");
			e.printStackTrace();
		}
		
		
  	}
	
	/*
	 * 打印成员变量
	 * getFileds() | getDeclaredFields()
	 * 
	 */
	private static void printFileds(Class cl) {
		Field[] fields = cl.getDeclaredFields();
		for(Field field : fields) {
			Class type = field.getType();
			String name = field.getName();
			System.out.print("\t");
			String modifiers = Modifier.toString(field.getModifiers());
			if(modifiers.length() > 0) System.out.print(modifiers+" ");
			System.out.print(type.getName()+" "+name+";\n");
		}
	}
	
	/*
	 * 打印构造器
	 */
	private static void printConstructors(Class cl) {
		Constructor[] constructors = cl.getDeclaredConstructors();
		for(Constructor constructor : constructors) {
			System.out.print("\t");
			String modifiers = Modifier.toString(constructor.getModifiers());
			if(modifiers.length() > 0) System.out.print(modifiers+" ");
			String name = constructor.getName();
			System.out.print(name+"(");
			Class[] paramTypes = constructor.getParameterTypes();
			for(int j = 0; j<paramTypes.length; j++) {
				if(j>0) System.out.print(",");
				System.out.print(paramTypes[j].getName());
			}
			System.out.print(");\n");
		}
	}
	
	//打印成员方法
	private static void printMethods(Class cl) {
		Method[] methods = cl.getDeclaredMethods();
		for(Method method : methods) {
			System.out.print("\t");
			String modifiers = Modifier.toString(method.getModifiers());
			if(modifiers.length() > 0) System.out.print(modifiers+" ");
			
			Class retType = method.getReturnType();
			System.out.print(retType.getName()+" ");
			
			String name = method.getName();
			System.out.print(name+"(");
			Class[] paramTypes = method.getParameterTypes();
			for(int j = 0; j<paramTypes.length; j++) {
				if(j>0) System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.print(");\n");
		}
	}
}
