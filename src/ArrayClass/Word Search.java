/*
	题目：
		给定一个二维网格和一个单词，找出该单词是否存在于网格中。

		单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
		
		同一个单元格内的字母不允许被重复使用。

		示例:

		board =
		[
		  ['A','B','C','E'],
		  ['S','F','C','S'],
		  ['A','D','E','E']
		]

		给定 word = "ABCCED", 返回 true.
		给定 word = "SEE", 返回 true.
		给定 word = "ABCB", 返回 false.
	思路：
		回溯
		
		注意回溯递归中 index+1 不是index++
*/

 public boolean exist(char[][] board, String word) {
	int rows=board.length,cols=board[0].length;
	boolean[][] flag=new boolean[rows][cols];
	for(int row=0;row<rows;row++){
		for (int col = 0; col < cols; col++) {
			if(word.charAt(0)==board[row][col]&&existCore(board,row,col,rows,cols,word,0,flag)){
				return true;
			}
		}
	}
	return false;
}

private boolean existCore(char[][] board, int row,  int col,int rows, int cols, String word, int index, boolean[][] flag) {
//  	if(index==word.length()) return true;
	if(row<0||row>=rows||col<0||col>=cols||word.charAt(index)!=board[row][col]||flag[row][col])
		return false;
	if(index==word.length()-1) return true;
	flag[row][col]=true;
	if(existCore(board,row-1,col,rows,cols,word,index+1,flag)||
			existCore(board,row+1,col,rows,cols,word,index+1,flag)||
			existCore(board,row,col-1,rows,cols,word,index+1,flag)||
			existCore(board,row,col+1,rows,cols,word,index+1,flag)
	)return true;
	flag[row][col]=false;
	return false;
}