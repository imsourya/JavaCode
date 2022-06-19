package duega.algo;

public class InterLeaved {
    /*This is for the no common char between s1 and s2*/
	public static boolean isInterleave(String s1, String s2, String s3) {

		int indxS1 = 0;
		int indxS2 = 0;
		
		for(int i=0; i< s3.length(); i++) {
			if(indxS1 < s1.length() && s1.charAt(indxS1) == s3.charAt(i)) {
				indxS1++;
			}
			else if(indxS2 < s2.length() && s2.charAt(indxS2) == s3.charAt(i)) {
				indxS2++;
			}
			else
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isInterleaveRec(String s1, int si1, String s2, int si2, String s3, int si3) {

		if(si1 == s1.length() && si2 == s2.length() && si3 == s3.length()) {
			return true;
		}
		
		if(si3 == s3.length()) return false;
		
		boolean s1flag = true;
		boolean s2flag = true;
		if(s1.charAt(si1) == s3.charAt(si3)) {
			 s1flag = isInterleaveRec(s1,si1+1,s2,si2,s3,si3+1);
		}
		if(s2.charAt(si2) == s3.charAt(si3)) {
			 s2flag = isInterleaveRec(s1,si1,s2,si2+1,s3,si3+1);
		}
		
		return s1flag || s2flag;
	}
	
	public static void main(String[] args) {
		//String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
		String s1 = "c", s2 = "ca", s3 = "cac";
		//System.out.println(isInterleave(s1,s2,s3));
		System.out.println(isInterleaveRec(s1,0,s2,0,s3,0));
	}
}
