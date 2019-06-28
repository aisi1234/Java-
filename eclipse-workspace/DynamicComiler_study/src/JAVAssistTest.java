import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;

/**
 *	JAVAssist的简单使用,可以操作类的字节码文件
 *	下载地址：http://www.csg.ci.i.u-tokyo.ac.jp/~chiba/javassist/
 * @author HASEE
 *
 */

public class JAVAssistTest {
	//使用JAVAssst动态的创建类，创建的是类的字节码文建，即.class文件，需要反编译才能看到对应的java文件
	public static void main(String[] args) throws Exception {
		
		
		CtClass ctClass = createClass();
		
		//createInstance(ctClass);
		
		//modifyMethod(ctClass);
		
		modifyField(ctClass);
	}
	
	private static CtClass createClass() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass ctClass = pool.makeClass("com.hasee.bean.Emp");
		
		//创建属性
		CtField f1 = CtField.make("private String name;", ctClass);
		CtField f2 = CtField.make("private int age;", ctClass);
		ctClass.addField(f1);
		ctClass.addField(f2);
		
		//创建构造器
//				CtConstructor constructor = new CtConstructor(new CtClass[] {}, ctClass); //无参构造器
//				ctClass.addConstructor(constructor);
		CtConstructor constructor1 = new CtConstructor(new CtClass[] {pool.get("java.lang.String"),CtClass.intType}, ctClass); //带参构造器
		constructor1.setBody("{this.name=$1;this.age=$2;}"); //设置方法体
		ctClass.addConstructor(constructor1);
		
		//创建方法
		CtMethod m = CtMethod.make("public void setName(String name){ this.name=name; }", ctClass);
		CtMethod m1 = CtMethod.make("public String getName(){ return name; }", ctClass);
		ctClass.addMethod(m);
		ctClass.addMethod(m1);
		m = CtMethod.make("public void setAge(int age){ this.age=age; }", ctClass);
		m1 = CtMethod.make("public int getAge(){ return age; }", ctClass);
		ctClass.addMethod(m);
		ctClass.addMethod(m1);
		
		//m = CtMethod.make("public int add(int a,int b){ return a+b; }", ctClass); //等同于下面三行代码
		m = new CtMethod(CtClass.intType, "add", new CtClass[]{CtClass.intType,CtClass.intType}, ctClass);
		m.setModifiers(Modifier.PUBLIC);
		m.setBody("{System.out.println(\"这是通过字节码创建的add方法\");return $1+$2;}"); //$i，占位符，表示方法的第i个参数，$0表示this
		
		ctClass.addMethod(m);
		/*
		 * 当CtClass 调用writeFile()、toClass()、toBytecode() 这些方法的时候，Javassist会冻结CtClass Object，
		 * 对CtClass object的修改将不允许
		 */
		//写出
		//ctClass.writeFile(); //如果不注释
		
		System.out.println("创建成功");
		
		return ctClass;
	}
	
	private static void createInstance(CtClass ctClass) throws Exception {
		//通过反射创建上面类的对象
		Class clzz = ctClass.toClass();
		System.out.println("1");
		//Object obj = clzz.newInstance(); //报错？？？？？？
		Constructor constructor = clzz.getDeclaredConstructor(String.class,int.class);
		Object obj = constructor.newInstance("aaa",123);
		System.out.println("2");
		Method method = clzz.getDeclaredMethod("add", int.class,int.class);
		Object result = method.invoke(obj, 20, 30);
		System.out.println(result);
	}
	
	/*
	 * 动态修改类的方法
	 */
	private static void modifyMethod(CtClass ctClass) throws Exception {
		CtMethod cm = ctClass.getDeclaredMethod("add",new CtClass[] {CtClass.intType,CtClass.intType});
		//在代码中添加一行 
		cm.insertBefore("System.out.print(\"Hello,\"+$1);");
		
		ctClass.writeFile();
		
		Class clzz = ctClass.toClass();
		Constructor constructor = clzz.getDeclaredConstructor(String.class,int.class);
		Object obj = constructor.newInstance("aaa",123);
		Method method = clzz.getDeclaredMethod("add", int.class,int.class);
		Object rresult = method.invoke(obj, 20,30);
		System.out.println(rresult);
 	}
	
	/*
	 * 动态修改属性
	 */
	private static void modifyField(CtClass ctClass) throws Exception {
		//CtField field = CtField.make("private double salary;", CtClass.doubleType);
		CtField field = new CtField(CtClass.doubleType,"salary",ctClass);
		field.setModifiers(Modifier.PRIVATE);
		ctClass.addField(field);
		
		//添加set、get方法
		ctClass.addMethod(CtNewMethod.setter("setSalaty", field));
		ctClass.addMethod(CtNewMethod.getter("getSalary", field));
		
		ctClass.writeFile();
	}
	
	/*
	 * 操作注解
	 */
}
