package duega.algo.recursion;

public class PowerOfNumber {
	
	private int powerOfNumer(int base, int exp) {
		if(exp == 0) return 1;
		if(exp == 1) {
			return base;
		}
		
		if(exp%2 == 0) {
			int m = powerOfNumer(base, exp/2);
			return m*m;
		}
		
		int m = powerOfNumer(base, (exp-1)/2);
		
		return m*m*base;
	}
	
	public static void main(String[] args) {
		PowerOfNumber p = new PowerOfNumber();
		System.out.println(p.powerOfNumer(6,4));
	}

	
}
