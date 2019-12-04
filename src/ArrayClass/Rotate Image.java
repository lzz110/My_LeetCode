/*
	题目:
		给定一个 n × n 的二维矩阵表示一个图像。

		将图像顺时针旋转 90 度。

		说明：必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

		示例 1:
		给定 matrix = 
		[
		  [1,2,3],
		  [4,5,6],
		  [7,8,9]
		],
		原地旋转输入矩阵，使其变为:
		[
		  [7,4,1],
		  [8,5,2],
		  [9,6,3]
		]
	思路：
		方法一：任意一个(i,j) , (j, n-i-1), (n-i-1, n-j-1), (n -j-1, i)就是这四个索引号上的数交换.

		方法二：翻转整个数组,再按正对角线交换两边的数

		[                    [                  [
		  [1,2,3],             [7,8,9],            [7,4,1],
		  [4,5,6],    ---->    [4,5,6], ----->     [8,5,2],
		  [7,8,9]              [1,2,3]             [9,6,3] 
		]                    ]                  ]

*/
//方法一：
public void rotate(int[][] matrix) {
	if(matrix==null)return ;
	int rows=matrix.length;
	for(int i=0;i<rows/2;i++){
		for(int j=i;j<n-i-1;j++){
			int temp=matrix[i][j];
			matrix[i][j]=matrix[n-j-1][i];
			matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
			matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
			matrix[j][n-i-1]=temp;
		}
	}
}


//方法二：翻转整个数组
public void rotate(int[][] matrix) {
	int n = matrix.length;
	// 上下翻转，两种写法
	// 第一种
	//  for (int i =0; i < n /2 ; i++ ){		//单个数字翻转
	//      for (int j =0; j < n; j ++){
	//          int tmp = matrix[i][j];
	//          matrix[i][j] = matrix[n-i-1][j];
	//          matrix[n-i-1][j] = tmp;
	//      }
	//  }
	// 第二种 
	for (int i = 0; i < n / 2; i ++){	//直接翻转一行
		int[] tmp = matrix[i];
		matrix[i] = matrix[n - i - 1];
		matrix[n - i - 1] = tmp;
	}
	//System.out.println(Arrays.deepToString(matrix));
	// 对角翻转
	for (int i = 0; i < n; i ++){
		for (int j= i + 1; j < n; j++){
			int tmp = matrix[i][j];
			matrix[i][j] = matrix[j][i];
			matrix[j][i] = tmp;
		}
	}
}
