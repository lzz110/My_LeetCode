/**
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *
 * 思路： 递归调用 核心函数（pre ,preStart,preEnd,in,inStart,inEnd）
 *
 * 注意： 递归的 前序 和 中序 的 头节点和尾节点
 *
 */
 
 public TreeNode buildTree(int[] preorder, int[] inorder) {
	int prestart=0,preend=preorder.length-1,instart=0,inend=inorder.length-1;
	TreeNode root=buildTreeCore(preorder,prestart,preend,inorder,instart,inend);
	return root;
}


private TreeNode buildTreeCore(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
	if(prestart>preend||instart>inend){
		return null;
	}
	TreeNode root=new TreeNode(preorder[prestart]);
	for(int i=instart;i<=inend;i++){    	//i是中序的根节点 i<=inend
		if(inorder[i]==preorder[prestart]){ 	//从前序找根节点   i-instart 是左子树的长度
			root.left=buildTreeCore(preorder,prestart+1,prestart+(i-instart),inorder,instart,i-1);
			root.right=buildTreeCore(preorder,prestart+(i-instart)+1,preend,inorder,i+1,inend);
			break;
		}
	}
	return root;
}