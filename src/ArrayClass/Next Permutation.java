
/*
	题目：
		实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

		如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

		必须原地修改，只允许使用额外常数空间。

		以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
		1,2,3 → 1,3,2
		3,2,1 → 1,2,3
		1,1,5 → 1,5,1
	
*/






public void nextPermutation(int[] A) {
    if(A == null || A.length <= 1) return;
    int i = A.length - 2;
    while(i >= 0 && A[i] >= A[i + 1]) i--; // Find 1st id i that breaks descending order
    if(i >= 0) {                           // If not entirely descending
        int j = A.length - 1;              // Start from the end
        while(A[j] <= A[i]) j--;           // Find rightmost first larger id j
        swap(A, i, j);                     // Switch i and j
    }
    reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
}

public void swap(int[] A, int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
}

public void reverse(int[] A, int i, int j) {
    while(i < j) swap(A, i++, j--);
}