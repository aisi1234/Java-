
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * 测试脚本引擎Rhino
 * @author HASEE
 *
 */

public class Demo02 {
	public static void main(String[] args) throws Exception {
		//获取脚本引擎对象
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		
		//定义变两个，存储到引擎上下文中
		engine.put("msg", "Hello engine");
		String str = "var user = {name:'hasee',age:18,schools:['清华大学','北京大学']};";
		str += "print(user.name);";
		
		engine.eval(str);
		System.out.println(engine.get("msg"));
		
		//定义函数
		engine.eval("function add(a,b){var sum=a+b;return sum;}");
		//读的调用接口
		Invocable invocable = (Invocable) engine;
		//执行脚本中定义的方法
		Object result = invocable.invokeFunction("add", new Object[]{12,33});
		System.out.println(result);
		
		//导入java包，使用其他包中的java类；
		/*
		 * //在jdk1.8中importPackage已经不适用 String jsCode =
		 * "importPackage(java.util); var list = Arrays.asList([\"北京大学\",\"清华大学\",\"北京农业大学\"]);"
		 * ;
		 */
		String jsCode1 = "var list = java.util.Arrays.asList([\"北京大学\",\"清华大学\",\"北京农业大学\"]);";
		engine.eval(jsCode1);
		List<String> list = (List<String>) engine.get("list");
		for (String string : list) {
			System.out.println(string);
		}
	}
}
