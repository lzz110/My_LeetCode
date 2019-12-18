/*
	题目：
		给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

		输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
		输出:
		[
		  ["ate","eat","tea"],
		  ["nat","tan"],
		  ["bat"]
		]

	思路：
		找到可以唯一标识具有相同字母并且个数也一样的键:
		
		思路一:单词按字典顺序排序

		思路二:用素数. 如abc=bca=cab=30 

*/


//思路一:单词按字典顺序排序
public List<List<String>> groupAnagrams(String[] strs) {
	if (strs == null || strs.length ==0)  return new ArrayList<List<String>>();
        Map<String, List<String>> map= new HashMap<>();
        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);							//对当前字符串排序
            String keyStr = String.valueOf(tmp);		
            if (! map.containsKey(keyStr)) map.put(keyStr,new ArrayList<String>());
//            map.get(keyStr).add(str);
            List<String> strings = map.get(keyStr);     //这里是地址传递 加在 keystr 对应的value中
            strings.add(str);				//将未排序的字符串添加到 map的value 中
//          List<String> strings = new ArrayList<>(map.get(keyStr));  //如果是new 的话就是新的地址了
        }
        return new ArrayList<>(map.values());	//map.values() 返回的是 List<String>集合
}

//思路二:用素数.
public List<List<String>> groupAnagrams(String[] strs) {
	int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
	Map<Integer,List<String>> map = new HashMap<>();
	for (String str : strs) {
		int key = 1;
		for(char c : str.toCharArray()){
			key *= prime[c - 'a'];
		}
		if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
		map.get(key).add(str);
	}
	return new ArrayList<>(map.values());
}
