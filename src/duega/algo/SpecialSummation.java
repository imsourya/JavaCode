package duega.algo;

import java.util.HashMap;
import java.util.Map;

public class SpecialSummation {

	static final long initValues[][] = {{0,0},{1,1},{11,2},{111,3},{1111,4},{11111,5},
			{111111,6},{1111111,7},{11111111,8},{0x1ff,9},{0x3ff,10},
			{0x7ffL,11},{0xfffL,12}};
	static final long MAX = 0x3ff;	
	static long[] getNextNumber(long N) {
		long result[] = new long[2];
		int left=0, right=0;
		for(int i=2;i<initValues.length;i++) {
			if(N==initValues[i-1][0]) {
				result[0] =  0;
				result[1] =  initValues[i-1][1];
				return result;
			}
			if(N==initValues[i][0]) {
				result[0] =  0;
				result[1] =  initValues[i][1];
				return result;
			}
			if(N<=initValues[i][0] && N>=initValues[i-1][0]) {
				left = i-1;
				right = i;
				break;
			}
		}
		
		// Left Calculation
		
		long leftResult = (N/initValues[left][0]);                    // 668/111 = 6
		long numOfOnesLeft = (leftResult)*initValues[left][1];        // 6*3 = 18
		long resultAfterLeft = N-(leftResult*initValues[left][0]);    // 668 - (6*111) = 2
		
		System.out.println("Left Result ="+leftResult+"  "+numOfOnesLeft+"  "+resultAfterLeft);
		
		// Right Calculation
		
		long rightResult = ((initValues[right][0]-N)/initValues[left][0]);                                        // (1111-668)/111 = 443/111 = 3
		long numOfOnesRight = initValues[right][1]+(rightResult)*initValues[left][1];                             // 4+3*3 = 13
		long resultAfterRight = (initValues[right][0] - rightResult*initValues[left][0]) - N;                     // 1111- 3*111 = 1111- 333 = 778
		
		System.out.println("Right Result ="+rightResult+"  "+numOfOnesRight+"  "+resultAfterRight);
		
		if(numOfOnesRight>numOfOnesLeft) {
			result[0] = resultAfterLeft;
			result[1] = numOfOnesLeft;
		}else {
			result[0] = resultAfterRight;
			result[1] = numOfOnesRight;
		}
		
		return result;
	}
	static Map<Long,Long> hm = new HashMap<Long, Long>();
	
	static int solve(long N){
		int result = 0;
	    if(hm.containsKey(N)) return Integer.valueOf(hm.get(N)+"");	
        while(N!=0) {
        	long[] arr = getNextNumber(N);
        	result+=arr[1];
        	hm.put(N, arr[1]);
        	N=arr[0];
        	if(hm.containsKey(N)) {
        		result += hm.get(N);
        		break;
        	}
        }
		return result;

	}

	public static void main(String[] args) {
		System.out.println("==========================================");
        System.out.println(solveRec(111112));
	}
	
	static Map<Long, Long> dp = new HashMap<Long, Long>();
	
	static {
		dp.put(0L, 0L);
		dp.put(1L, 1L);
		dp.put(2L, 2L);
		dp.put(3L, 3L);
		dp.put(4L, 4L);
		dp.put(5L, 5L);
		dp.put(6L, 6L);
		dp.put(7L, 6L);
		dp.put(8L, 5L);
		dp.put(9L, 4L);
		dp.put(10L, 3L);
		dp.put(11L, 2L);
	}
	
	static long solveRec(long N) {
		
		if(dp.containsKey(N)) return dp.get(N);
		int left = 0, right = 0;
		for(int i=2;i<initValues.length;i++) {
			if(N==initValues[i-1][0]) {
			    dp.put(N, (long)initValues[i-1][1]);
				return initValues[i-1][1];
			}
			if(N==initValues[i][0]) {
				dp.put(N, (long)initValues[i][1]);
				return initValues[i][1];
			}
			if(N<initValues[i][0] && N>initValues[i-1][0]) {
				left = i-1;
				right = i;
				break;
			}
		} 
		
		System.out.println("left="+left+"  right="+right);
		
		long leftResult = N/initValues[left][0];            // 54/11 = 4
		long leftAns = leftResult*initValues[left][1]+solveRec(N-initValues[left][0]*leftResult);
		
		System.out.println("leftRes = "+leftResult+"  leftAns= "+leftAns);
		
		long rightResult= (initValues[right][0]-N)/initValues[left][0];   // (111-54)/11  = 57/11 = 5
		long rightAns = initValues[right][1] + rightResult*initValues[left][1]
				+ solveRec((initValues[right][0]-N)-(rightResult*initValues[left][0]));
		
		System.out.println("rightRes = "+rightResult+"  rightAns= "+rightAns);
		
		long res = Math.min(leftAns, rightAns);
		
		dp.put(N, res);
		
		return res;
	}
}
