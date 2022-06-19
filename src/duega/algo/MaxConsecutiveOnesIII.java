package duega.algo;

public class MaxConsecutiveOnesIII {

	public int longestOnes(int[] nums, int k) {
		int j,i=0,zeroes=0;
		
		for(j=0; j<nums.length; j++) {
			if(nums[j]==0) zeroes++;
			if(zeroes>k && nums[i++]==0) zeroes--;
		}

		return j-i;
	}

	public static void main(String[] args) {
		MaxConsecutiveOnesIII m = new MaxConsecutiveOnesIII();
		int nums[] = {1,1,1,0,0,0,1,0,1,0,1,1};
		System.out.println(m.longestOnes(nums, 1));
	}
	/*
	int findMaxConsecutiveOnes(vector<int<& nums) {
      int ret = 1;
      int n = nums.size();
      if (!n)
         return 0;
      int j = 0;
      int zero = 0;
      for (int i = 0; i < n; i++) {
         if (nums[i] == 0) {
            zero++;
         }
         while (j <= i && zero > 1) {
            if (nums[j] == 0) {
               zero--;
            }
            j++;
         }
         ret = max(ret, i - j + 1);
      }
      return ret;
   }*/
}
