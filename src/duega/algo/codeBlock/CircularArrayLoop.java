package duega.algo.codeBlock;

public class CircularArrayLoop {

	private int next(int[] nums, int index) {
		int val = (nums[index] + index + nums.length) % nums.length;
		System.out.println("Val = "+ val);
		return val;
	}
	
	public int circularArrayLoopCount(int[] nums) {
		
		int count = 0;

		for(int i = 0; i<nums.length; i++){
			if(nums[i] == 0) {
				continue;
			}
			int slow = i;
			int fast = i;
			
			while(extracted(nums, slow, fast)) {
				slow = next(nums, slow);
				fast = next(nums, next(nums, fast));
				
				if(slow == fast) {
					// Length should not be one.
					if(slow == next(nums, slow)) {
						break;
					}
					
					count++;
					
					int s = i;
					do {
						int val = s;
						s = next(nums, s);
						nums[val] = 0;
					}while(s!=slow);
					nums[slow] = 0;
					
				}
			}
			
			slow  = i;
			// to mark zeroes for all non circular elements
			while(nums[i] * nums[slow] > 0) {
				int val = slow;
				slow = next(nums, slow);
				nums[val] = 0;
			}
		}

		return count;
	}
	
	private boolean extracted(int[] nums, int slow, int fast) {
		return nums[slow] * nums[next(nums, slow)] > 0 &&
				nums[fast] * nums[next(nums, fast)]>0 &&
				nums[fast] * nums[next(nums, next(nums, fast))] > 0;
	}
	
	public boolean circularArrayLoop(int[] nums) {

		for(int i = 0; i<nums.length; i++) {
			if(nums[i] == 0) {
				continue;
			}
			int slow = i;
			int fast = i;
			
			while(extracted(nums, slow, fast)) {
				slow = next(nums, slow);
				fast = next(nums, next(nums, fast));
				System.out.println("Slow "+slow+" Fast "+fast);
				if(slow == fast) {
					// Length should not be one.
					if(slow == next(nums, slow)) {
						break;
					}
					System.out.println("At "+slow);
					return true;
				}
			}

			slow  = i;
			// to mark zeroes for all non circular elements
			while(nums[i] * nums[slow] > 0) {
				int val = slow;
				slow = next(nums, slow);
				nums[val] = 0;
			}
			
			System.out.println("=======================");
			display(nums);
		}
		return false;
	}

	private void display(int[] nums) {
		
		for(int c : nums) {
			System.out.print(c+" ");
		}
		
		System.out.println();
		
	}

	public static void main(String[] args) {
		CircularArrayLoop c = new CircularArrayLoop();
		//int[] nums = {2,2,2,2,2,4,7};
		int[] nums = {-2,-3,-9};
		System.out.println(c.circularArrayLoop(nums));
		System.out.println(c.circularArrayLoopCount(nums));
	}
}
