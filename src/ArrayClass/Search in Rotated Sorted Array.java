/*

	题目：
		假设按照升序排序的数组在预先未知的某个点上进行了旋转。

		数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

		搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

		你可以假设数组中不存在重复的元素。

		你的算法时间复杂度必须是 O(log n) 级别。

			
	思路： 
		二分查找
		
		第一类 2 3 4 5 6 7 1 这种，也就是 nums[start] <= nums[mid]。此例子中就是 2 <= 5。
		
		这种情况下，前半部分有序。因此如果 nums[start] <=target<nums[mid]，则在前半部分找，否则去后半部分找。
		
		第二类 6 7 1 2 3 4 5 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2。

		这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]，则在后半部分找，否则去前半部分找。


	

*/

//JAVA 
public int search(int[] nums, int target) {
	int res=-1;
	int mid,left=0,right=nums.length-1;
	while(left<=right){
		 mid=(left+right)/2;
		 if(nums[mid]==target)
			 return mid;
		 if(nums[left]<=nums[mid]){ 	//前半部分有序 如 1 2 4 5 6 7 0
			//target 在前部分
			if(target >= nums[left] && target < nums[mid]){
				right=mid;
			}else{
				left=mid+1;
			}
		 }else{     			//后半部分有序 如  6 7 0 1 2 4 5
			if(target>nums[mid]&&target<=nums[right]){
				left=mid+1;
			}else{
				right=mid;
			}
		 }
	}
	return res;
}