package duega.algo;

public class EggDropping 
{
	// recursive Approach
	 private static int eggDrop(int k, int n) {
		    
	        if (n == 1 || n == 0)
	            return k;
	 
	        if (k == 1)
	            return k;
	 
	        int min = Integer.MAX_VALUE;
	        int x, res;
	 
	        for (x = 1; x <= n; x++) {
	            res = Math.max(eggDrop(k - 1, x - 1),
	            		eggDrop(k, n - x));
	            if (res < min)
	                min = res;
	        }
	 
	        return min + 1;     
	        
	    }
	 
	 // Dp approach
	 private static int eggDropDp(int k, int n) {

		 int dp[][]  = new int [k+1][n+1];
		 
		 dp[0][0] = 0;
		 
		 for(int i=1;i<=k;i++) {
			 dp[0][i] = 0;
			 dp[1][i] = 1;
		 }
		 
		 for(int i=1;i<=n;i++) {
			 dp[1][i] = i;
		 }
		 
		 for(int i = 1; i<=k;i++) {
			 for(int j = 1; j<=n; j++) {
				 for(int x = 1; x<=k; x++) {
					 dp[i][j] = Math.min(dp[i-1][x-1],dp[i][n-x])+1;
				 }
			 }
		 }

		 return dp[k][n];
	 }
	 
	public static void main(String[] args) {
		System.out.println(eggDrop(2,10));
		System.out.println(eggDropDp(2,10));
	}

}
