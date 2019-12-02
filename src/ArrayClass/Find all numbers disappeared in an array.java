/*
    题目：
        给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，
        数组中的元素一些出现了两次，另一些只出现一次。
        找到所有在 [1, n] 范围之间没有出现在数
        您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 
        你可以假定返回的数组不算在额外空间内。
        示例:
        输入:
        [4,3,2,7,8,2,3,1]
        输出:
        [5,6]
    
	思路：
        将所有正数作为数组下标，置对应数组值为负值。那么，仍为正数的位置即为（未出现过）消失的数字。
	
	注意：数组中有负数
        
*/
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* findDisappearedNumbers(int* nums, int numsSize, int* returnSize){
    int temp = 0;
    int index = 0;
    for (int i = 0; i < numsSize; i++) {
        temp = nums[i] > 0 ? nums[i] : -nums[i];    //将数组中的负数转为正数
        if (nums[temp-1] > 0) {    //对于出现两次的数字，第二次该值为负数时，直接跳过
            nums[temp-1] *= -1;
        }
    }
    
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] > 0) {
            nums[index++] = i + 1;
        }
    }
    
    *returnSize = index;
    return nums;
}

//JAVA
public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int temp=nums[i]>0?nums[i]:-nums[i];
            if(nums[temp-1]>0)
                nums[temp-1]=-1*nums[temp-1];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                res.add(i+1);
        }
        return res;
}


class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> res;
        int len=nums.size();
        int temp=0;
        for(int i=0;i<len;i++){
            //temp=nums[i];     //之前这样写报错，原因给定的数组里面有负数，需要转换成正数
            temp = nums[i] > 0 ? nums[i] : -nums[i];
            if(nums[temp-1]>0)
            nums[temp-1]*=-1;
        }
        for(int i=0;i<len;i++){
            if(nums[i]>0){
                res.push_back(i+1);
            }
        }
        return res;
    }
};