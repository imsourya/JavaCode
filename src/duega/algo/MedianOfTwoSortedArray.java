package duega.algo;

public class MedianOfTwoSortedArray {

	double median(int[] arr1, int[] arr2) {
		
		int smallerArray[];
		int biggerArray[];
		if(arr1.length < arr2.length) {
			smallerArray = arr1;
		}else {
			smallerArray = arr2;
		}
		
		int lo = 0;
		int mid = 0;
		int hi = smallerArray.length-1;
		while(lo<hi) {
			int partX = lo + (hi-lo+1)/2;
			//int partY = 
			
		}
		
		return 0.0;
	}
	
	public static void main(String[] args) {
		
	}
}
