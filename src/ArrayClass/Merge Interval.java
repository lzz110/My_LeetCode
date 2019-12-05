/*
	题目：
		给出一个区间的集合，请合并所有重叠的区间。

		示例 1:
		输入: [[1,3],[2,6],[8,10],[15,18]]
		输出: [[1,6],[8,10],[15,18]]
	
	思路：
		先按首位置进行排序;

		接下来,如何判断两个区间是否重叠呢?比如 a = [1,4],b = [2,3]

		当 a[1] >= b[0] 说明两个区间有重叠.

		但是如何把这个区间找出来呢?

		左边位置一定是确定，就是 a[0]，而右边位置是 max(a[1], b[1])

		所以,我们就能找出整个区间为:[1,4]

*/

public int[][] merge(int[][] intervals) {
	List<int[]> res=new ArrayList<>();
	if(intervals==null||intervals.length==0)
		return res.toArray(new int[0][]);
	Arrays.sort(intervals,(a,b)->a[0]-b[0]);        //按照数组首元素排序
	int i=0;
	while(i<intervals.length){
		int left=intervals[i][0];
		int right=intervals[i][1];
		while(i<intervals.length-1&&intervals[i+1][0]<=right){   //找到数组中下一个数组的首元素<当前数组的末尾元素的数组
			i++;
			right=Math.max(right,intervals[i][1]);  //比较right
		}
		res.add(new int[]{left,right});
		i++;
	}
	return res.toArray(new int[0][]);   //转换成二维数组
}