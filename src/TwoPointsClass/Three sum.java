﻿
/*
    
    题目：
		给定一个包含 n 个整数的数组 nums，
		判断 nums 中是否存在三个元素 a，b，c 
		使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
    
    思路
		标签：数组遍历 双指针
		首先对数组进行排序，排序后固定一个数 nums[i]，转化为 two sum ,再使用左右指针指向 nums[i]后面的两端，
		数字分别为 nums[L]和 nums[R]，计算三个数的和sum 判断是否满足为 0，满足则添加进结果集
		如果 nums[i]> 0，则三数之和必然无法等于 0，结束循环
		如果 nums[i] == nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过
		当 sum == 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
		当 sum == 0 时，nums[R] == nums[R−1] 则会导致结果重复，应该跳过，R−−
		时间复杂度：O(n^2)，n 为数组长度
*/  


public List<List<Integer>> threeSum(int[] nums) {
	List<List<Integer>> res= new ArrayList<>();
	if(nums == null || nums.length < 3) return res;
	Arrays.sort(nums);
	for(int i=0;i<nums.length-2;i++){
		if(nums[i]>0)   break;  // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
		if(i > 0 && nums[i] == nums[i-1]) continue; // 相同i去重
		int left=i+1,right=nums.length-1;
		while(left<right){
			if(nums[left]+nums[right]+nums[i]<0){
				left++;
			}else if(nums[left]+nums[right]+nums[i]>0){
				right--;
			}else{
//                    temp.add(nums[i]);
//                    temp.add(nums[left]);
//                    temp.add(nums[right]);
//                    res.add(new ArrayList<Integer>(temp));
				res.add(Arrays.asList(nums[i],nums[left],nums[right]));
				while (left<right && nums[left] == nums[left+1]) left++; // 相同left去重
				while (left<right && nums[right] == nums[right-1]) right--; // 相同right去重
				left++;
				right--;
			}
		}
	}
	return res;
}

