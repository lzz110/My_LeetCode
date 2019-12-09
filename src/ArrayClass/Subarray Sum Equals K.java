/*
	题目：
		给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

		示例 1 :
		输入:nums = [1,1,1], k = 2
		输出: 2 , [1,1] 与 [1,1] 为两种不同的情况
	思路：
		正常：暴力 O(n3)
				两层循环遍历数组 外层start 内层end 一个循环计算 start--end的数组和 
				
		优化1：累计和数组 O(n2)	
				新建数组sum[i] 表示 0 到 i-1 的连续数组和 
				sum[end] - sum[start] == k	为所求
				
		优化2：累计和数组+Hash表	O(n)+O(n)
				实际上不需要加法，只需要 nums[0] + nums[1] + nums[2] - nums[0]，
				用sum[i]表示从0到i所有元素的和，那么nums[1] + nums[2] = sum[2] - sum[0]。
				
				我们需要找到的是target k，即sum[j] - sum[i] = k (j > i)，k已知，sum[j]在迭代过程中逐步计算。
				需要存储的就只有sum[i]，查找sum[i]要常数时间，那么map的key应该是sum[i]，value应该是当前值的个数。
				那么在找到满足的sum[i] = sum[j] - k的时候，最后的结果只需要加上map[sum[j] - k]即可。

*/
////暴力
public int subarraySum(int[] nums, int k) {
	int count = 0;
	for (int start = 0; start < nums.length; start++) {
		for (int end = start + 1; end <= nums.length; end++) {
			int sum = 0;
			for (int i = start; i < end; i++)
				sum += nums[i];
			if (sum == k)
				count++;
		}
	}
	return count;
}


////优化1：累计和数组 
public int subarraySum(int[] nums, int k) {
	int count = 0;
	int[] sum = new int[nums.length + 1];
	sum[0] = 0;
	for (int i = 1; i <= nums.length; i++)
		sum[i] = sum[i - 1] + nums[i - 1];
	for (int start = 0; start < nums.length; start++) {
		for (int end = start + 1; end <= nums.length; end++) {
			if (sum[end] - sum[start] == k)
				count++;
		}
	}
	return count;
}

////优化2：累计和数组+Hash表
public int subarraySum(int[] nums, int k) {
	int count = 0, sum = 0;
	HashMap < Integer, Integer > map = new HashMap < > ();
	map.put(0, 1);		//关键 
	for (int i = 0; i < nums.length; i++) {
		sum += nums[i];
		if (map.containsKey(sum - k))
			count += map.get(sum - k);
		map.put(sum, map.getOrDefault(sum, 0) + 1);
	}
	return count;
}


