
/*
	题目：
		给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

		示例 1:
		输入: nums = [1,1,1,2,2,3], k = 2
		输出: [1,2]
		示例 2:

		输入: nums = [1], k = 1
		输出: [1]
	思路：最小堆


*/

public List<Integer> topKFrequent(int[] nums, int k) {
	// 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
	HashMap<Integer,Integer> map = new HashMap();
	for(int num : nums){
		if (map.containsKey(num)) {
		   map.put(num, map.get(num) + 1);
		 } else {
			map.put(num, 1);
		 }
	}
	// 遍历map，用最小堆保存频率最大的k个元素
	PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer a, Integer b) {
			return map.get(a) - map.get(b);
		}
	});
	for (Integer key : map.keySet()) {
		if (pq.size() < k) {
			pq.add(key);
		} else if (map.get(key) > map.get(pq.peek())) {
			pq.remove();
			pq.add(key);
		}
	}
	// 取出最小堆中的元素
	List<Integer> res = new ArrayList<>();
	while (!pq.isEmpty()) {
		res.add(pq.remove());
	}
	return res;
}

