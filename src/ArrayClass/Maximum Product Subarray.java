/*
	题目：
		给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

		示例 1:
		输入: [2,3,-2,4]
		输出: 6
		
		输入: [-2,-3,-2,-4]
		输出: 48
	思路：
		动态规划
		记录前i的最小值, 和最大值, 
		那么 dp[i] = max(nums[i] * pre_max, nums[i] * pre_min, nums[i]), 
		这里0 不需要单独考虑, 因为当相乘不管最大值和最小值,都会置0


*/

 public int maxProduct(int[] nums) {
	if(nums==null||nums.length<=0)
		return 0;
	int min=nums[0],max=nums[0],result=nums[0];
	for (int i = 1; i <nums.length ; i++) {
		int temp=max;
		max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
		min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
		if(max>result)
			result=max;
	}
	return result;
}