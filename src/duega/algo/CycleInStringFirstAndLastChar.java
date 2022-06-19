package duega.algo;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/* Given an array of strings, find if the given strings can be chained to form a circle. A string X can be put before another string Y in a circle 
if the last character of X is the same as the first character of Y.

Input: arr[] = {"tea", "apple", "elephant"}  -> True


Input: arr[] = {"tea", "apple", "elephant", "abc"} -> False 
*/

/*

    t   a        
    a   e
    e   t
    a   t


a -> e 
e -> t
t -> a 
a-> t

t   ->   a
a   ->   e
e   ->   t
t   ->   l
l   ->   t

 t -> a -> e -> t  
 
 b-> c-> b

*/

public class CycleInStringFirstAndLastChar {
    
    public static void main(String[] args){
        
        String input[] = {"tea", "apple", "elephant"};
        
        int leftChar[] = new int[27];
        int rightChar[] = new int[27];
        
        for(int i=0; i<input.length; i++){
            String str = input[i];
            leftChar[str.charAt(0)-96]++;
            rightChar[str.charAt(str.length()-1)-96]++;
        }
        
        for(int i=1; i< 27; i++ ){
            if(leftChar[i] != rightChar[i])
            {
                System.out.println("False No Cycle Found");
                return;
            }
        }
        
        boolean visited[] = new boolean[input.length] ;
        
        Stack<Integer> stck = new Stack<Integer>();
        
        stck.push(0);
        
        while(! stck.empty()) {
            int indx  =  stck.pop();
            visited[indx] = true;
            String str = input[indx];
            char lastChar = str.charAt(str.length()-1);
            
            if(lastChar == input[0].charAt(0)){
                System.out.println("Cycle found");
				if(checkIfVistedAll(visited)) {
					System.out.println("Cycle found");
				}
            }
            
            for(int i = 0; i <input.length ;i++){
                // if node not visited
                
                if(visited[i]== false && lastChar == input[0].charAt(0))
                {
                    stck.push(i);
                }
            }
        }
        
    }

	private static boolean checkIfVistedAll(boolean[] visited) {
		for(int i=0; i < visited.length; i++) {
			if(! visited[i]) {
				return false;
			}
		}
		return true;
	}
}
