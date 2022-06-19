package duega.algo.codeBlock;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		int n = nums.length;

		for(int i = 0; i < n; i++) {
			//System.out.println(nums[i]);
			while(nums[i] > 0 && nums[i] < n && nums[nums[i] - 1] != nums[i])
			{
				int idx = nums[i]-1;
				int temp = nums[i];
				nums[i] = nums[idx];
				nums[idx] = temp;
			}
		}

		for(int i=0;i<n;i++){
			if(nums[i] != i+1) return (i+1);
		}

		return n+1;
	}
	
	public static void main(String[] args) {
		FirstMissingPositive f = new FirstMissingPositive();
		int nums[] = {3,4,-1,2};
		System.out.println(f.firstMissingPositive(nums));
	}
}
