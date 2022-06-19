package duega.algo;

import java.util.Collections;
import java.util.List;

public class Amaz1 {
	
private static boolean checkFamilyLoginString(String str1, String str2) {
        
        //System.out.println("==>"+str1);
        //System.out.println("==>"+str2);
        int i = 0;
        while(i<str1.length()){
            if(str1.charAt(i) + 1 != str2.charAt(i) || (str1.charAt(i)=='z' && str2.charAt(i)!='a')){
                return false;
            }
            i++;
        }
        return true;
    }
    
    public static int countFamilyLogins2(List<String> logins) {
    
        int count = 0;
        Collections.sort(logins);
        
        int first = 0;
        int second = first+1;
        
        while(first < logins.size()) {
            if(first< logins.size() && second < logins.size() 
            && logins.get(first).charAt(0)+1 ==  logins.get(second).charAt(0)) {
               if(checkFamilyLoginString(logins.get(first), logins.get(second))) {
                   count++;
                   second++;
               } 
            } else if(first< logins.size() && second < logins.size() 
            && logins.get(first).charAt(0) ==  logins.get(second).charAt(0)) {
                second ++;
            } else {
                first ++;
                second = first+1;
            }
        }
    
        return count;
    }

    public static int countFamilyLogins(List<String> logins) {
    
        int count = 0;
        for(int i=0; i< logins.size(); i++) {
            for(int j=0; j<logins.size(); j++) { 
                
                if((logins.get(i).charAt(0) == logins.get(j).charAt(0)+1) ||
                 (logins.get(j).charAt(0) == 'z' && logins.get(i).charAt(0)=='a')) {
                    //System.out.println("XXXXXX");
                    if(checkFamilyLoginString(logins.get(j), logins.get(i))) {
                        count++;
                        //System.out.println("X111111");
                    }
                }
                else if (logins.get(i).charAt(0)+1 == logins.get(j).charAt(0) ||
                (logins.get(i).charAt(0) == 'z' && logins.get(j).charAt(0)=='a'))
                {
                    if(checkFamilyLoginString(logins.get(i), logins.get(j))) {
                        count++;
                        
                    }
                }
             
            }
        }
    
    
        return count;
    }
}

