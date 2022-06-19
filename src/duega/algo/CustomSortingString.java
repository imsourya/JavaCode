package duega.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CustomSortingString {

	public String customSortString(String order, String str) {
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		for( char c : str.toCharArray()) {
			if(hm.containsKey(c)) {
				hm.put(c, hm.get(c)+1);
			}else {
				hm.put(c, 1);
			}
		}
		
		StringBuilder sbul = new StringBuilder();

		for(int i=0;i<order.length(); i++) {
			if(hm.containsKey(order.charAt(i))) {
				int n = hm.get(order.charAt(i));
				while(n>0) {
					sbul.append(order.charAt(i));
					n--;
				}
				hm.remove(order.charAt(i));
			}
		}
		
		for(Entry<Character, Integer> e : hm.entrySet()) {
			if(e.getValue()>0) {
				int n = e.getValue();
				while(n>0) {
					sbul.append(e.getKey());
					n--;
				}
			}
		}

		return sbul.toString();
	}
	
	public String customSortString_fromDiscussion(String S, String T) {
        int[] count = new int[26];
        for (char c : T.toCharArray()) { ++count[c - 'a']; }  // count each char in T.
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {                            
            while (count[c - 'a']-- > 0) { sb.append(c); }    // sort chars both in T and S by the order of S.
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) { sb.append(c); }    // group chars in T but not in S.
        }
        return sb.toString();
   }

	public static void main(String[] args) {
		CustomSortingString c = new CustomSortingString();
		System.out.println(c.customSortString("kqep", "saurabh"));
	}
}
