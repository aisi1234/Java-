import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Three {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String name;
		if(args.length>0) name=args[0];
		else {
			System.out.println("Enter Class name(e.g. java.util.Date):");
			name = input.next();
		}
		
		try {
			Class class1 = Class.forName(name);
			Class superclass = class1.getSuperclass();
			String modifiers = Modifier.toString(class1.getModifiers());
			if(modifiers.length()>0) System.out.print(modifiers+" ");
			System.out.print("class "+name);
			if(superclass != null && superclass != Object.class) System.out.print(" extends "+superclass.getName());
			System.out.print("\n{\n");
			
			printConstructors(class1);
			System.out.println("\n");
			printMethods(class1);
			System.out.println("\n");
			printFileds(class1);
			
			System.out.print("}\n");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		
		input.close();
	}
	
	public static void printConstructors(Class c1) {
		Constructor[] constructors = c1.getConstructors();
		for(Constructor c: constructors) {
			String name =c.getName();
			System.out.print("	");
			String modifiers = Modifier.toString(c.getModifiers());
			if(modifiers.length()>0) System.out.print(modifiers+" ");
			System.out.print("(");
			Class[] paramTypes = c.getParameterTypes();
			for(int j=0;j<paramTypes.length;j++) {
				if(j>0) System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}

	public static void printMethods(Class c1) {
		Method[] methods = c1.getMethods();
		for(Method m:methods) {
			Class retType = m.getReturnType();
			String name = m.getName();
			System.out.print("	");
			String modifiers = Modifier.toString(m.getModifiers());
			if(modifiers.length()>0) System.out.print(modifiers+" ");
			System.out.print(retType.getName()+" "+ name+"(");
			Class[] paramTypes = m.getParameterTypes();
			for(int j=0;j<paramTypes.length;j++) {
				if(j>0) System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	public static void printFileds(Class c1) {
		Field[] fields = c1.getDeclaredFields();
		for(Field f : fields) {
			Class type = f.getType();
			String name = f.getName();
			System.out.print("	");
			String modifiers = Modifier.toString(f.getModifiers());
			if(modifiers.length()>0) System.out.print(modifiers+" ");
			System.out.println(type.getName()+" "+name+";");
		}
	}
	
}
