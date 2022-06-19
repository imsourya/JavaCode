package duega.algo;

import java.util.Stack;

class Pair<T,U>{
	T first;
	U second;
	Pair(T first, U second){
		this.first = first;
		this.second = second;
	}
}

public class RemoveAllAdjacentDuplicatesInString {
	
	public String removeDuplicates(String s) {

		Stack<Character> stck = new Stack<Character>();
		
		for(char c : s.toCharArray()) {
			if(!stck.empty() && stck.peek() == c) {
				stck.pop();
			}
			else {
				stck.push(c);
			}
		}
		
		StringBuilder res = new StringBuilder();
		
		//while(!stck.empty()) {
		//	res.append(stck.pop());
		//}
		//return res.reverse().toString();
		
		for(char c : stck) res.append(c);
		System.gc();
		return res.toString();
	}
	
	public static void main(String[] args) {
		//StringBuilder s = new StringBuilder("aaabcccx");
		//s.delete(1, s.length());
		//System.out.println(s.toString());
		RemoveAllAdjacentDuplicatesInString r = new RemoveAllAdjacentDuplicatesInString();
		System.out.println(r.removeDuplicates("aabbbbaaa"));
	}
	

	public String removeDuplicatesWoSTACK(String s) {

		StringBuilder sbul = new StringBuilder(s);
		int left = 0;
		boolean flag = false;
		while(true) {
			System.out.println("For = "+sbul.toString());
			flag = false;
			for(int i=0; i<sbul.length();) {
				if((i+1)<sbul.length() && sbul.charAt(i)==sbul.charAt(i+1)) {
					left = i;
					flag = true;
					while((i+1)<sbul.length() && sbul.charAt(i)==sbul.charAt(i+1)) {
						i++;
					}
					if(((i-left+1)%2!=0)) {
						sbul.delete(left, i);
					}else {
						sbul.delete(left, i+1);
					}
					break;
				}else {
					i++;
				}
			}
			if(!flag) {
				break;
			}
		}
		return sbul.toString();
	}

	

	public String removeDuplicatesWithStackHeavyCode(String s) {

		StringBuilder sbul = new StringBuilder(s);
		int left = 0;
		Stack< Pair<Integer,Integer> > delList = new Stack< Pair<Integer,Integer> >();
		while(true) {
			System.out.println("For = "+sbul.toString());
			for(int i=0; i<sbul.length();) {
				if((i+1)<sbul.length() && sbul.charAt(i)==sbul.charAt(i+1)) {
					left = i;
					while((i+1)<sbul.length() && sbul.charAt(i)==sbul.charAt(i+1)) {
						i++;
					}
					if(((sbul.length()&1)==1) && left==0 && i == (sbul.length()-1)) {
						delList.add(new Pair<Integer,Integer>(0,i-1));
					}else {
						delList.add(new Pair<Integer,Integer>(left,i));
					}
				}else {
					i++;
				}
			}
			if(delList.empty()) {
				break;
			}else {
				while(! delList.empty()) {
					Pair<Integer,Integer> p = delList.pop();
					sbul.delete(p.first, p.second+1);
				}
			}
		}
		return sbul.toString();
	}
}
