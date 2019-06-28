import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Demo01 {
	public static void main(String[] args) {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		
		
		int result = compiler.run(null, null, null, "E:\\Hello.java");
		
		System.out.println("编译"+(result == 0 ? "成功" : "失败" ));
	} 
}
