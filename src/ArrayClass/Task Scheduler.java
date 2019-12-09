/*

题目：
	给定一个用字符数组表示的 CPU 需要执行的任务列表。
	
	其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。
	
	任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。
	
	CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。

	然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

	你需要计算完成所有任务所需要的最短时间。

	示例 1：

	输入: tasks = ["A","A","A","B","B","B"], n = 2
	输出: 8
	执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.

思路：
     1、将任务按类型分组，正好A-Z用一个int[26]保存任务类型个数
     2、对数组进行排序，优先排列个数（count）最大的任务，
          如题得到的时间至少为 retCount =（count-1）* (n+1) + 1 ==> A->X->X->A->X->X->A(X为其他任务或者待命)
     3、再排序下一个任务，如果下一个任务B个数和最大任务数一致，
          则retCount++ ==> A->B->X->A->B->X->A->B
     4、如果空位都插满之后还有任务，那就随便在这些间隔里面插入就可以，因为间隔长度肯定会大于n，在这种情况下就是任务的总数是最小所需时间

*/

public int leastInterval(char[] tasks, int n) {
	if(tasks==null||tasks.length<2||n<1)
		return tasks.length;
	int[] temp=new int[26];
	for(int i=0;i<tasks.length;i++){
		temp[tasks[i]-'A']++;
	}
	Arrays.sort(temp);
	int max=temp[25];
	int res=(max-1)*(n+1)+1;
	for (int i = 24; i >=0; i--) {
		if(temp[i]==max){
			res++;
		}
	}
	return Math.max(res,tasks.length);
}