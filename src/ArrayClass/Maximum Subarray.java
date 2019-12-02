/*
    题目：给定一个整数数组 nums ，
            找到一个具有最大和的连续子数组（子数组最少包含一个元素）
            返回其最大和。

		示例:
		输入: [-2,1,-3,4,-1,2,1,-5,4],
		输出: 6
		解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
    
    思路：
		动态规划：通过把原问题分解为相对简单的子问题的方式求解复杂问题的方法。
		动态规划常常适用于有  重叠子问题  和 最优子结构  性质的问题。
		需要一个head来指向最优解序列的头结点，head指向将不断变化，
		定义一个最优解数组dp[i]记录截至到当前元素的最优子序和.
		三目运算符的使用
		
	注意：
		负数数组[-1，-2]  返回-1
		max和sum的初始值必须要是数组中的值，否则会用0代替负值
*/

//JAVA
class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0,res=nums[0];
        for(int i=0;i<nums.length;i++){
            if(sum<0){
                sum=0;
            }
            sum=sum+nums[i];
            if(sum>res)
                res=sum;
        }
        return res;
    }
}

	
int maxSubArray(int* nums, int numsSize){
    int max=nums[0];
    int i,sum=nums[0];
    for(i=1;i<numsSize;i++){
        if(sum<0){
            sum=0;
        }
        sum+=nums[i];
        max=(max>sum)?max:sum;      
    }
    return max;
}



