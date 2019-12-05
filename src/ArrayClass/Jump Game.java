/*
	题目：
		给定一个非负整数数组，你最初位于数组的第一个位置。
		
		数组中的每个元素代表你在该位置可以跳跃的最大长度。

		判断你是否能够到达最后一个位置。
		
		输入: [2,3,1,1,4]
		输出: true
		
		输入: [3,2,1,0,4]
		输出: false
	思路：
		
		
*/

public boolean canJump(int[] nums) {
	int k = 0;  						//k 代表当前可以跳到最远的地方
	for (int i = 0; i < nums.length; i++){
		if (i > k) return false;
		k = Math.max(k, i + nums[i]);   //代表站在索引（i）的位置 跳到最远距离nums[i]
		if(k>=nums.length)return true;  //距离大于数组长度 直接返回
	}
	return true;
}