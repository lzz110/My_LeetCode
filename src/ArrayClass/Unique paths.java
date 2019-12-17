
/*
    题目：
        一个机器人位于一个 m x n 网格的左上角 。   //n 行 m 列
        机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角。
        问总共有多少条不同的路径？
        输入: m = 3, n = 2
        输出: 3
        解释:
        从左上角开始，总共有 3 条路径可以到达右下角。
        1. 向右 -> 向右 -> 向下
        2. 向右 -> 向下 -> 向右
        3. 向下 -> 向右 -> 向右
 
    思路：
		动态规划
		点(i-1,j)和点(i,j-1)，都可以一步到达终点。
		所以到达点(i,j)的方式，就是到达(i-1,j)的所有方式和到达(i,j-1)的所有方式之和
		第一行与第一列全为1是因为：第一行只能从左顶点通过一直向右获得，路径只有1条，
		同理，第一列只能通过从上顶点一直向下获得
*/  

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] map=new int [n][m]; //n 行 m 列
        for(int i=0;i<n;i++)    map[i][0]=1;
        for(int j=0;j<m;j++)    map[0][j]=1;
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                map[j][i]=map[j-1][i]+map[j][i-1];
            }
        }
        return map[n-1][m-1];
    }
}

//优化
public int uniquePaths(int m, int n) {
	int[] cur = new int[n];	 //数组存n行 代表这一行最大的数字
	Arrays.fill(cur,1);
	for (int i = 1; i < m;i++){
		for (int j = 1; j < n; j++){
			cur[j] += cur[j-1] ;
		}
	}
	return cur[n-1];
}




