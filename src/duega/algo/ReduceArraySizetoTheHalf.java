package duega.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}

public class ReduceArraySizetoTheHalf {
	static final int SIZE  =  100000;
	public int minSetSize(int[] arr) {

		int countArr[] = new int[SIZE+1];

		for(int i=0;i<arr.length;i++){
			countArr[arr[i]]++;
		}
		
		List<Integer> integersList = new ArrayList<Integer>();
		for(int c : countArr) {
			if(c!=0) integersList.add(c);
		}
		Collections.sort(integersList, Collections.reverseOrder());
		System.out.println(integersList);
		
		int countInterger = 0,count=0;
		int halfLength = arr.length/2;
		for(int val : integersList) {
			countInterger+=val;
			count++;
			if(countInterger >= halfLength) {
				break;
			}
		}
		
		return count;
	}
	public static void main(String[] args) {
		ReduceArraySizetoTheHalf r = new ReduceArraySizetoTheHalf();
		int ar[] = {3,3,3,3,5,5,5,2,2,7};
		//int ar[] = {1};
		System.out.println(r.minSetSize(ar));
	}
}
