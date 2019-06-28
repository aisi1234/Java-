import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池使用过方式
 * 1.使用Executors类的newFixedThreadPool方法，返回ExecutorsService
 * 2.创建线程，实现Runnable接口，设置线程任务
 * 3.调用ExecutorsService实现类的submit方法，传递线程任务
 * 4.调用shutdown方法，关闭线程池
 * @author HASEE
 *
 */

public class Test1 {
	public static void main(String[] args) {
		//ExecutorService es = Executors.newFixedThreadPool(2);
	}
}
