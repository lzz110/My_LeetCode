/*
    题目：
        给定一个整数数组 nums 和一个目标值 target，找出和为目标值的那 两个 整数，
        并返回他们的数组下标。
        假设每种输入只会对应一个答案.不能重复利用这个数组中同样的元素。
        示例:
        给定 nums = [2, 7, 11, 15], target = 9
        所以返回 [0, 1]

*/


 
////C

    int* twoSum(int* nums, int numsSize, int target) {
    	static int a[2] = { 0 };//如果没有static 会返回局部变量的地址，造成错误
    	for (int i = 0; i < numsSize - 1; i++) {
    		for (int j = 1; j < numsSize; j++) {
    			if (target - nums[i] == nums[j]) {
    				a[0] = i;
    				a[1] = j;
    				return a;
    			}
    		}
    	}
    	return NULL;
    }

///c++ 两层for循环 暴力搜索 
///第二层for循环初始条件应该是上层循环的条件+1，[2,5,5,11] 10 防止出现[1 1]现象
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int i, j;
        for (i = 0; i < nums.size()-1; i++) {
            for (j = i+1; j < nums.size(); j++) {   
            //不能重复利用这个数组中同样的元素 j一定要在i之后      
                if (target - nums[i] == nums[j]) 
                    return {i,j};
            }
        }
        return {nums.size(), nums.size()};
    }    
};

///c++ 使用unordered_map
///map： map内部实现了一个红黑树，该结构具有自动排序的功能，
///因此map内部的所有元素都是有序的，红黑树的每一个节点都代表着map的一个元素
///对于map进行的查找，删除，添加等一系列的操作都相当于是对红黑树进行这样的操作，故红黑树的效率决定了map的效率。 
//unordered_map: unordered_map内部实现了一个哈希表，因此其元素的排列顺序是杂乱的，无序的

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
    std::unordered_map<int, std::size_t> tmp;
    for (std::size_t i = 0; i < nums.size(); ++i) {
      if (tmp.count(target - nums[i])) {
        return {tmp[target - nums[i]], i};
      }
      tmp[nums[i]] = i;
    }
    return {nums.size(), nums.size()};
  }
};
  
  
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement) && map.get(complement) != i) {
            return new int[] { i, map.get(complement) };
        }
    }
    throw new IllegalArgumentException("No two sum solution");
} 
