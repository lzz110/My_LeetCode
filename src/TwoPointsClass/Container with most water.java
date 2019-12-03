/*
    题目：
		盛最多水的容器 
		输入: [1,8,6,2,5,4,8,3,7]
		输出: 49
	
	思路：
		双指针法 首尾判断长度 移动短的那根

		两线段之间形成的区域总是会受到其中较短那条长度的限制。此外，两线段距离越远，得到的面积就越大。

		我们在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。 
		
		使用变量 maxarea 来持续存储到目前为止所获得的最大面积。 
		
		更新 maxarea，并将指向较短线段的指针向较长线段那端移动一步
		
		关键是要懂为什么移动短的指针，因为宽度已经最大，
		
		如果移动长的相当于宽度和高度可能同时减少，所以要移动短的
    

*/

//JAVA
public int maxArea(int[] height) {
	int max=0,left=0,right=height.length-1;
	while(left<right){
		max=Math.max((right-left)*Math.min(height[right],height[left]),max);
		if(height[right]<height[left]){
			right--;
		}else{
			left++;
		}
	}
	return max;
}

//C++
class Solution {
public:
    int maxArea(vector<int>& height) {
     int maxarea=0;
        int left=0;
        int right=height.size()-1;
        while(left<right){
            maxarea=max((right-left)*min(height[left],height[right]),maxarea);
            if(height[left]<height[right])
                left++;
            else right--;
        }
        return maxarea;
    }
};



