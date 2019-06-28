public class Two {
	public static void main(String[] args) {
		String str = "Hello";
		int[] codePoints = str.codePoints().toArray();
		for(int i=0;i<codePoints.length;i++) System.out.println(codePoints[i]);
		
	}
}
