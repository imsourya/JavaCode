package duega.algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosestElements {

	private static int[] getIndexPair(int arr[], int x) {
		int res[] = new int[2];
		int mid = 0;
		int left = 0; 
		int right = arr.length-1;
		while(left<right) {
			mid = left+(right-left)/2;
			if(x<arr[mid]) {
				right = mid;
				if((mid-1) >= 0 && arr[mid-1]<=x) {
					left = (mid-1);
					break;
				}
			}else if(x>arr[mid]) {
				left = mid;
				if((mid+1) < arr.length && arr[mid+1]>=x) {
					right = mid+1;
					break;
				}
			}else {
				left=mid;
				right=mid+1;
				break;
			}
		}
		res[0] = left;
		res[1] = right;
		return res;
	}

	public List<Integer> findClosestElements1(int[] arr, int k, int x) {
		if(arr==null) return null;
		if(arr.length <= k) return Arrays.stream(arr).boxed().collect(Collectors.toList());

		if(x<arr[0]) {
			return Arrays.stream(arr, 0, k).boxed().collect(Collectors.toList());
		}else if(x>arr[arr.length-1]) {
			return Arrays.stream(arr, arr.length-k, arr.length).boxed().collect(Collectors.toList());
		}

		LinkedList<Integer> res = new LinkedList<Integer>();
		// bissection.
		int indxPair[] = getIndexPair(arr,x);
		int left = indxPair[0];
		int right = indxPair[1];
		//System.out.println(left+"  "+right);
		while(k>0) {

			if(left>=0 && right<arr.length) {
				if(Math.abs(arr[left]-x)>Math.abs(arr[right]-x)) {
					res.addLast(arr[right]);
					right++;
				}else if(Math.abs(arr[left]-x)<Math.abs(arr[right]-x)){
					res.addFirst(arr[left]);
					left--;
				}else {
					if(arr[left]<arr[right]) {
						res.addFirst(arr[left]);
						left--;
					}else {
						res.addLast(arr[right]);
						right++;
					}
				}
			}else {
				if(left>=0) {
					res.addFirst(arr[left]);
					left--;
				}
				if(right<arr.length) {
					res.addLast(arr[right]);
					right++;
				}
			}
			k--;
		}

		return res;
	}
	
	public List<Integer> findClosestElements(int[] arr, int k, int x) {

		LinkedList<Integer> res = new LinkedList<Integer>();
		
		int lo = 0;
		int hi = arr.length-1;
		
		while(hi-lo >= k) {
			if(Math.abs(arr[hi]-x)<Math.abs(arr[lo]-x)) {
				lo++;
			}else {
				hi--;
			}
		}
		
		for(int i=lo;i<=hi;i++) {
			res.add(arr[i]);
		}

		return res;
	}

	public static void main(String[] args) {
		FindKClosestElements f = new FindKClosestElements();
		//int arr[] = {1,2,3,4,5};
		int arr[] = {1,2,7,10,13,14,15,16,17};
		//int res[] = getIndexPair(arr, 19);
		//System.out.println(res[0]+" "+res[1]);
		
		//int arr[] = {1,2,3,4,5};
		
		for(int c: f.findClosestElements(arr, 4, 11)) {
			System.out.print(c+"  ");
		}
	}
}
