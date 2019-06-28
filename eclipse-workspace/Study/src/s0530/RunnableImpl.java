package s0530;

public class RunnableImpl implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"正在执行");
	}
}
