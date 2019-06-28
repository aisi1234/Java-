
class Test{
	private static int x = 10;

	public int get() {
		return x;
	}
	
	public void set(int x) {
		//Test1.x = x;
	}
}

public class One{
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = new String("Hello");
		String s4 = new String("Hello");
		System.out.println(s1==s2); //true
		/*
		 * s1,s2属于常量，在定义常量时，会先在常量区中查找是否存已存在该常量值，若存在，则常量名指向该地址，否则在常量区中分配新的空间
		 */
		//System.out.println(s1.equals(s2)); //true
		String string = "Hello";
//		byte[] bts = string.getBytes();
//		for(byte bt:bts) {
//			System.out.println(bt);
//		}
		System.out.println(string.hashCode());
		System.out.println(s3==s4); //false
		//System.out.println(s3.equals(s4)); //true
		
	}
}