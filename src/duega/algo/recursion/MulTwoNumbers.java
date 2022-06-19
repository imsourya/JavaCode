package duega.algo.recursion;

public class MulTwoNumbers {

	private int RecursiveMul(int i, int j) {
		if(i>j) return RecursiveMul(j,i);
		if(i==1) return j;
		return RecursiveMul(i-1,j)+j;
	}
	
	public static void main(String[] args) {
		MulTwoNumbers m = new MulTwoNumbers();
		System.out.println(m.RecursiveMul(6,1));
	}

	
}
