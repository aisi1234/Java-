package s0529;

public class ChiHuo extends Thread {
	private Baozi bz;

	public ChiHuo(Baozi bz) {
		super();
		this.bz = bz;
	}
	
	//设置线程任务
	@Override
	public void run() {
		//死循环，一直吃包子
		while(true) {
			synchronized (bz) {
				//没有包子，等待
				if (bz.flag == false) {
					try {
						bz.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println("吃货正在是："+bz.pi+bz.xian+"的包子");
				bz.flag = false;
				bz.notify(); //包子吃完，唤醒包子铺线程生产包子
				System.out.println("-------------------------------");
			}
		}
	}
}
