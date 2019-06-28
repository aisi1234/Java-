package demo.IO;

/**
 * java.io.PrintStream extends OutputStream ：打印流，为其他输出流添加了功能，使他们能够方便的打印各种数据表示形式
 * 	特点：
 * 		1.只负责数据的输出，不负责数据的读取
 * 		2.与其他输出流不同，PrintStream永远不会抛出IOException
 * 		3.有特有的方法，print，println
 * 	注意：
 * 		如果使用继承自父类的write方法写数据，那么查看数据是会查询编码表
 * 		如果使用自己特有的方法print/println方法写数据时，写的数据原样输出
 * @author HASEE
 *
 */

public class Demo09 {

}
