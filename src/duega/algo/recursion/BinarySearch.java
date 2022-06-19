package duega.algo.recursion;

public class BinarySearch {
	
	int bs(int[] arr, int hi, int lo, int t) {
		if(hi<lo) return -1;
		
		int mid = lo + (hi-lo)/2;
		
		if(arr[mid] == t) return mid;
		
		if(arr[mid]>t) {
			return bs(arr,mid-1, lo, t);
		}
		
		return bs(arr, hi, mid+1, t);
	}
	
	public static void main(String[] args) {
		BinarySearch b = new BinarySearch();
		
		System.out.println(b.bs(new int[] {2,3,4,5,6,7,8,9}, 7, 0, 3));
	}
}
