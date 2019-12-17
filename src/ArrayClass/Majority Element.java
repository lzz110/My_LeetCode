/*
    题目：
        给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
        你可以假设数组是非空的，并且给定的数组总是存在众数。
        示例 1:
        输入: [3,2,3]
        输出: 3

    
    思路：
		方法一：从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
		方法二：哈希表
	
*/


//c++
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int len=nums.size();
        if(len==0)return 0;
        int major,count=0;
        for(int i=0;i<len;i++){
            if(count==0){
                major=nums[i];
                count++;
            }
            else if(major==nums[i])
                count++;
            else count--;
            
        }
        return major;
    }
};

public int MoreThanHalfNum_SolutionbyHash(int[] array) {
	HashMap<Integer,Integer> map=new HashMap<>();
	for(int i=0;i<array.length;i++){
		if(!map.containsKey(array[i])){
			map.put(array[i],1);
		}else{
			int count=map.get(array[i]);
			map.put(array[i],++count);
		}
	}
	
	Iterator iter=map.entrySet().iterator();
	while(iter.hasNext()){
		Map.Entry entry = (Map.Entry) iter.next();
		Integer key= (Integer) entry.getKey();
		Integer value= (Integer) entry.getValue();
		if(value>array.length/2){
			return key;
		}
	}

	return 0;
}
//如果数组中不存在众数 [1,2,3]count=3 但是不是众数 需要判断
public int MoreThanHalfNum_Solutionbycount(int[] array) {
	int temp=0,count=0;
	for(int i=0;i<array.length;i++){
		if(count==0){
			temp=array[i];
			count++;
		}else if(temp==array[i]){
			count++;
		}else{
			count--;
		}
	}
	count=0;
	for(int i=0;i<array.length;i++){
	   if(temp==array[i])
		   count++;
	}
	if(count>array.length/2)return temp;
	return 0;
}