/*
	题目：
		给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

		算法时间复杂度必须是 O(log n) 级别。

		如果数组中不存在目标值，返回 [-1, -1]。

		输入: nums = [5,7,7,8,8,10], target = 8
		输出: [3,4]

		输入: nums = [5,7,7,8,8,10], target = 6
		输出: [-1,-1]
	思路：
		二分查找 找到相同的target 后 
		先向前查找第一个  再向后查找最后一个
	注意：
		nums={1} 1  返回：[0 0] 
		nums={1,7} 7  返回：[1 1] 
*/

public int[] searchRange(int[] nums, int target) {
	int[] res={-1,-1};
	if(nums==null||nums.length==0){
		return res;
	}
	/*if(nums.length==1&&nums[0]==target){
		return new int[]{0,0};
	}else if(nums.length==1&&nums[0]!=target){
		return res;
	}*/
	int mid=0,left=0,right=nums.length-1;
	while(left<right){
		mid=(left+right)>>>1;
		if(nums[mid]>target){
			right=mid;
		}else if(nums[mid]<target){		
			left=mid+1;
		}else{
			while(mid>0&&nums[mid-1]==target){		//先向前查找第一个
				mid--;
			}
			res[0]=mid;
			while(mid<nums.length&&nums[mid]==target){	//再向后查找最后一个
				mid++;
			}
			res[1]=mid-1;
			return res;
		}
	}
	if(nums[left]==target)      //退出时可能 left=right && nums[left]==target 需要再次判断 如{1，7} 7
		return new int[]{left,left};    //同时过滤掉只有一个数字的情况 如{1} 1
	return res;
}