package s0529;

public class BaoZiPu extends Thread {
	private Baozi bz;

	public BaoZiPu(Baozi bz) {
		super();
		this.bz = bz;
	}
	
	//设置线程任务，生产包子
	@Override
	public void run() {
		
		int count=0;
		
		//死循环，一直生产包子
		while(true) {
			synchronized (bz) {
				//如果有包子，等待
				if(bz.flag == true) {
					try {
						bz.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				//生产包子
				if(count % 2 == 0) {
					bz.pi = "冰皮";
					bz.xian = "牛肉大葱馅";
				}else {
					bz.pi = "薄皮";
					bz.xian = "猪肉三鲜馅";
				}
				System.out.println("包子铺正在生产："+bz.pi+bz.xian+"的包子");
				bz.flag = true;
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("包子铺生产完成："+bz.pi+bz.xian+"的包子");
				bz.notify();
				count++;
			}
		}
	}
}
