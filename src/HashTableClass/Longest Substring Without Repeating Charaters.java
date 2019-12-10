/*
题目：
	给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

	示例 1:
	输入: "abcabcbb"
	输出: 3 
思路：
	标签：滑动窗口
	暴力解法时间复杂度较高，会达到 O(n^2)，故而采取滑动窗口的方法降低时间复杂度
	定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
	我们定义不重复子串的开始位置为 start，结束位置为 end
	随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
	无论是否更新 start，都会更新其 map 数据结构和结果 ans。
	时间复杂度：O(n)
*/

public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(alpha, end + 1);
        }
        return ans;
}

当我们知道该字符集比较小的时侯，我们可以用一个整数数组作为直接访问表来替换 Map。
常用的表如下所示：
int [26] 用于字母 ‘a’ - ‘z’ 或 ‘A’ - ‘Z’
int [128] 用于ASCII码
int [256] 用于扩展ASCII码

public int lengthOfLongestSubstring(String s) {
	int n = s.length(), ans = 0;
	int[] index = new int[128]; // current index of character
	// try to extend the range [i, j]
	for (int j = 0, i = 0; j < n; j++) {
		i = Math.max(index[s.charAt(j)], i);
		ans = Math.max(ans, j - i + 1);
		index[s.charAt(j)] = j + 1;
	}
	return ans;
}

