package s0529;

public class Test {
	public static void main(String[] args) {
		Baozi bz = new Baozi();
		
		new BaoZiPu(bz).start();
		new ChiHuo(bz).start();
	}
}
