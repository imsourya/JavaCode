package duega.algo.codeBlock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueCharacterStringAlgo {
	
	private static boolean checkDuplicateString(String str) {
		short CharCount[] = new short[27];
		
		for(char c : str.toCharArray()) {
			CharCount[c-96]++;
		}
		for(int i=1; i<27; i++) {
			if(CharCount[i]>1) {
				return false;
			}
		}
		return true;
	}

	private static void printAllSubsets(String[] list, int indx, List<String> resultant, String result) {

		if(indx == list.length) {
			 if(checkDuplicateString(result)) resultant.add(result);
			return;
		}

		// Selected
		if(checkDuplicateString(list[indx]))
			printAllSubsets(list, indx+1, resultant, result+list[indx]);

		// non selected
		printAllSubsets(list, indx+1, resultant, result);
	}

	public static void main1(String[] args) {
		String [] lists = {"ab", "cd", "ab"};
		List<String> resultant = new ArrayList<String>(); 
		printAllSubsets(lists, 0, resultant, "");

		int max = 0;
		for(String str : resultant)
		{
			System.out.println(str);
			
			if(max<str.length()) {
				max = str.length();
			}
		}
		System.out.println("Max Length = "+max);
	}
	
	public static int maxLength(List<String> A) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int res = 0;
        for (String s : A) {
        	System.out.println("\n====================== For "+s);
            int a = 0, dup = 0;
            for (char c : s.toCharArray()) {
                dup |= a & (1 << (c - 'a'));
                a |= 1 << (c - 'a');
            }
            System.out.println("DuplicateFlag = "+ dup);
            System.out.println("A = "+ a);
            if (dup > 0) continue;
            System.out.println("dp  = "+ dp.size());
            for ( int i = dp.size() - 1; i >= 0; --i) {
                if ((dp.get(i) & a) > 0) continue;
                dp.add(dp.get(i) | a);
                res = Math.max(res, Integer.bitCount(dp.get(i) | a));
            }
            System.out.println("dp2 = "+ dp.size());
            for(int val : dp) {
            	System.out.print(val+"  ");
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		String [] lists = {"ab", "cd", "ab"};
		System.out.println("Max Length = "+maxLength(Arrays.asList(lists)));
	}
}
