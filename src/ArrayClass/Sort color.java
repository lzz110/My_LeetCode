/*
	题目：
		给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

		此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

		示例:
		输入: [2,0,2,1,1,0]
		输出: [0,0,1,1,2,2]

	思路：
		用三个指针（p0, p2 和curr）来分别追踪0的最右边界，2的最左边界和当前元素
		While curr <= p2 :
		若 nums[curr] = 0 ：交换第 curr个 和 第p0个 元素，并将指针都向右移。

		若 nums[curr] = 2 ：交换第 curr个和第 p2个元素，并将 p2指针左移 。

		若 nums[curr] = 1 ：将指针curr右移。
	注意：
		因为curr左边的值已经扫描过了，所以curr要++继续扫描下一位，而与p2交换的值，curr未扫描，要停下来扫描一下，所以curr不用++
 
*/

public void sortColors(int[] nums) {
	if(nums==null||nums.length<=0)
		return ;
	int p0=0,cur=0,temp,p2=nums.length-1;
	while(cur<=p2){
		if(nums[cur]==0){
			//交换 nums[cur] 和 nums[p0] 
			temp=nums[cur];
			nums[cur]=nums[p0];
			nums[p0]=temp;
			p0++;cur++;
		}else if(nums[cur]==2){
			//交换 nums[cur] 和 nums[p2]
			temp=nums[cur];
			nums[cur]=nums[p2];
			nums[p2]=temp;
			p2--;
		}else{
			cur++;
		}
	}
}
