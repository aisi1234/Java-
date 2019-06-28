import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 将CSV格式的文件转为HTML格式的文件
 * @author HASEE
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		f("CVS.txt", "to.html");
	}
	
	/*
	 * fromPath:SVC格式文件路径字符串
	 * toPath：转换为HTML文件输出文件路径字符串
	 * 
	 */
	public static void f(String fromPath, String toPath) throws IOException {
//		InputStreamReader input = new InputStreamReader(new FileInputStream(fromPath), "utf-8");
//		OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(toPath), "utf-8");
		
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fromPath),"uft-8"));
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(toPath), "utf-8"));
		
		BufferedReader input = new BufferedReader(new FileReader(fromPath));
		BufferedWriter output = new BufferedWriter(new FileWriter(toPath));
		
		
		output.write("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"		<meta charset=\"utf-8\">\r\n" + 
				"		<title></title>\r\n" + 
				"	</head>\r\n" + 
				"	<body>\r\n" + 
				"		<table border=\"1px\" cellspacing=\"0px\" cellpadding=\"5px\">\r\n" + 
				"			<tr><td>角色</td><td>描述</td></tr>\r\n");
		
		String line = "";
		while((line = input.readLine()) != null) {
			
			System.out.println(line);
			
			int index = line.indexOf(",");
			if(index == -1) continue;
			
			output.write("			<tr>");
			output.write("<td>");
			output.write(line.substring(0, index));
			output.write("</td>");
			output.write("<td>");
			output.write(line.substring(index+1));
			output.write("</td>");
			output.write("</tr>\r\n");
		}
		
		output.write("</table>\r\n" + 
				"		\r\n" + 
				"	</body>\r\n" + 
				"</html>");
		input.close();
		output.close();
		
	}
}
