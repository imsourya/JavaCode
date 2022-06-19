package duega.algo.recursion;

public class PrintNto0 {
	
	private void printNtoZero(int n) {
		System.out.print(n+" ");
		if(n<=0) return;
		printNtoZero(n-1);
	}
	

	private void printZeroToN(int n) {
		if(n==0) {
			System.out.print(0+" ");
			return;
		}
		printZeroToN(n-1);
		System.out.print(n+" ");
	}
	
	public static void main(String[] args) {
		PrintNto0 p = new PrintNto0();
		p.printNtoZero(8);
		p.printZeroToN(8);
	}

}
