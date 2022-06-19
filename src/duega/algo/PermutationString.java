package duega.algo;

public class PermutationString {

	public static void main(String[] args) {
		System.out.println("Hello World");
		String str = "ABCD";
		permute(str,str.length(),0);
	}

	private static void permute(String str, int n, int init) {
		
		if(init==n)
		{
			System.out.println(str);
			return;
		}
		for(int i=init; i<n; i++) {
			str = swap(str,init,i);
			permute(str, n, init+1);
			str = swap(str,init,i);
		}
	}

	private static String swap(String str, int l, int r) {
		
		char[] strChar = str.toCharArray();
		char temp = strChar[l];
		strChar[l] = strChar[r];
		strChar[r] = temp;
		return String.copyValueOf(strChar);
	}
}
