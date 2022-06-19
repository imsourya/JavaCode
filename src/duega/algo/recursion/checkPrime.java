package duega.algo.recursion;

public class checkPrime {
	
	private boolean isPrime(int n, int k) {
		if(k > (int)Math.sqrt(n)) return true;
		if(n%k==0) return false;
		return isPrime(n, k+1);
	}
	
	public static void main(String[] args) {
		checkPrime c = new checkPrime();
		System.out.println(c.isPrime(2,2));
	}
}
