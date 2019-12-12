/*

	题目：
		给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
		字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
		说明：
		字母异位词指字母相同，但排列不同的字符串。
		不考虑答案输出的顺序。
		
		示例 1:
		输入:
		s: "cbaebabacd" p: "abc"

		输出:
		[0, 6]
	思路：
		双指针 滑动窗口  Hash表

	相似题目：
		Minimun Windows Substring.java

*/
public List<Integer> findAnagrams(String s, String p) {
	List<Integer> res=new ArrayList<>();
	// 记录最短子串的开始位置和长度
	int start = 0, minLen = Integer.MAX_VALUE;
	int left = 0, right = 0;

	Map<Character,Integer> window = new HashMap<Character,Integer>();
	Map<Character,Integer> needs = new HashMap<Character,Integer>();
	for(char c:p.toCharArray()){
		needs.put(c,needs.getOrDefault(c,0)+1);
	}

	int match = 0;

	while(right < s.length()){
		char c1 = s.charAt(right);
		if(needs.containsKey(c1)){
			window.put(c1,window.getOrDefault(c1,0)+1);
			//注意needs.get(c1)==window.get(c1) 这样不通过 整型对象的比较不能用“==”，应该用“equals” 
			//-127-128 都是 在缓冲区中 其他需要new 地址不一样
			if(needs.get(c1).equals(window.get(c1))){		
				match++;
			}
		}
		right++;

		while(match == needs.size()){

			if(right - left == p.length()){
				res.add(left);
			}
			char c2 = s.charAt(left);
			if (needs.containsKey(c2)) {
				window.put(c2,window.get(c2)-1);
				if (window.get(c2) < needs.get(c2)){
					match--;
				}
			}
			left++;
		}
	}

	return res;
}