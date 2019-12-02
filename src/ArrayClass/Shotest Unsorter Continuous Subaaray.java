/*
    题目：  
        给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
        你找到的子数组应是最短的，请输出它的长度。
        示例 1:
        输入: [2, 6, 4, 8, 10, 9, 15]
        输出: 5
        解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
    思路：
		先备份，再排序
		正向寻找第一个不同的数字，再反向找第一个不同的数字
*/
//Java
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] nums_copy=nums.clone();		//使用 object.clone() 方法实现的是复制对象（改变新数组） 如果=nums 实现的是复制引用（改变原数组）
        Arrays.sort(nums_copy);
        int left=0,right=nums.length-1;
        while(left<right){					//从前向后找
             if(nums[left]!=nums_copy[left])
                 break;
            left++;
        }
        while(right>=left){					//从后向前找			
            if(nums[right]!=nums_copy[right])
                break;
            right--;
        }
        return right-left+1;
    }
}
//C++
class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        int len=nums.size();
        vector<int> nums_copy;
        for(int i=0;i<len;i++) nums_copy.push_back(nums[i]);
        sort(nums_copy.begin(),nums_copy.end());    //c++   sort(a.begin(),a.end());
        int left=0,right=0;
        for(int i=0;i<len;i++){
            if(nums[i]!=nums_copy[i]){
                left=i;
                break;
            }
        }
        for(int i=len-1;i>=0;i--){
            if(nums[i]!=nums_copy[i]){
                right=i;
                break;
            }
                
        }
        if(right==0&&left==0)       //如果已经是排好序的数组，没有这个判断 结果会是1 不是0
            return 0;
        return right-left+1;
    }
};


