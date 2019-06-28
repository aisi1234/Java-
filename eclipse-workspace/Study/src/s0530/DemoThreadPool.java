package s0530;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池使用步骤：
 * 1.使用线程池的工厂类Executors里边提供的静态方法newFixedThreadPool生产一个指定线程数量的线程池,返回ExecutorService接口的实现对象
 * 2.创建一个类，实现Runnable接口，重写run方法，设置线程任务
 * 3.调用ExecutorService的submit(Runnable task)，传递线程任务，开启线程，执行run方法
 * 4.调用ExecutorSrevice的shutdown销毁线程池，但是不建议使用
 * @author HASEE
 *
 */

public class DemoThreadPool {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		
		threadPool.submit(new RunnableImpl());
		threadPool.submit(new RunnableImpl());
		threadPool.submit(new RunnableImpl());
		
		threadPool.shutdown();
	}
}
