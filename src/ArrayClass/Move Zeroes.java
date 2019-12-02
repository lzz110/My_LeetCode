/*
    题目：
		给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
		示例:
		输入: [0,1,0,3,12]
		输出: [1,3,12,0,0]
		说明:
			必须在原数组上操作，不能拷贝额外的数组。
			尽量减少操作次数。

    思路：
		可以先把所有非0的元素移到前面，然后将后面的位置补0。 
		使用指针i，指向需要插入的下标，使用指针j指向遍历的下标。
		遍历一遍，如果j指向的位置为0，则i不变，j++后移；
		如果j指向的位置不为0，则将j位置的元素值赋值到i位置，然后i++
*/

void moveZeroes(int* nums, int numsSize){
    int i,count=0;
    for(i=0;i<numsSize;i++){
        if(nums[i]==0){
            count++;
        }
        else 
            nums[i-count]=nums[i];
    }
    for(i=numsSize-count;i<numsSize;i++){
        nums[i]=0;
    }
    
}
/*  
	//采用双指针  j代表非零元素个数
    //正常能想到，给剩余元素赋值为0时，应该用while循环，
    //第一次想到的是for循环，但是这样内存消耗大，耗时多
   
    void moveZeroes(int* nums, int numsSize) {
        int i = 0,j = 0;
        for(i = 0 ; i < numsSize; i++)
        {
            if(nums[i] != 0)
            {
                nums[j] = nums[i];
                j++;
            }
        }
        while(j < numsSize)
        {
            nums[j++] = 0;
        }
    }
*/

//c++
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int len=nums.size();
        if(len<2) return ;
        int left=0;
        int right=0;
        for(;right<len;right++){
            //while(nums[right]!=0){ 	如果用while 根本没有进行right++ 造成left数组越界
            if(nums[right]!=0){
                nums[left]=nums[right];
                left++;
            }
            
        }
        for(;left<len;left++){
            nums[left]=0;
        }
    }
};

