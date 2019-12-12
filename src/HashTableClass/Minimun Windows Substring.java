/*
	题目：
		给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
		示例：
		输入: S = "ADOBECODEBANC", T = "ABC"
		输出: "BANC"

	思路：
		双指针 滑动窗口  Hash表

	相似题目：
		Find All Anagrams in a String.java
*/

public String minWindow(String s, String t) {
        int left=0,right=0,start=0,match=0,minLen=Integer.MAX_VALUE;
        Map<Character,Integer> needs=new HashMap<>();
        Map<Character,Integer> window=new HashMap<>();
        for(char c:t.toCharArray()){
            needs.put(c,needs.getOrDefault(c,0)+1);
        }
        while(right<s.length()){
            char c = s.charAt(right);
            if(needs.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(needs.get(c))){
                    match++;
                }
            }
            right++;
            while(match==needs.size()){
                if(right-left<minLen){
                    start=left;
                    minLen=right-left;
                }
                char c2=s.charAt(left);
                if(needs.containsKey(c2)){
                    window.put(c2,window.get(c2)-1);
                    if (window.get(c2) < needs.get(c2)){
                        match--;
                    }
                }
                left++;
            }

        }
        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }

