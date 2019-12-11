
/*
    
    给定一个二叉树，返回它的中序 遍历。
    示例:
    输入: [1,null,2,3]
       1
        \
         2
        /
       3

    输出: [1,3,2]

    思路
		一：基于栈的遍历
		二：递归
*/  

//一：基于栈的遍历
public List<Integer> inorderTraversal(TreeNode root) {
	List < Integer > res = new ArrayList < > ();
	Stack < TreeNode > stack = new Stack < > ();
	TreeNode curr = root;
	while (curr != null || !stack.isEmpty()) {
		////当cur!=null 左子树遍历
		while (curr != null) {
			stack.push(curr);
			curr = curr.left;
		}
		//当cur==null && !stack.isEmpty() 弹栈
		curr = stack.pop();
		//添加节点
		res.add(curr.val);
		//右子树遍历
		curr = curr.right;
	}
	return res;
}


//二：递归
public List < Integer > inorderTraversal(TreeNode root) {
	List < Integer > res = new ArrayList<>();
	inorderTraversalCore(root, res);
	return res;
}

private void inorderTraversalCore(TreeNode root, List < Integer > res) {
	if (root != null) {
		if (root.left != null) {
			inorderTraversalCore(root.left, res);
		}
		res.add(root.val);
		if (root.right != null) {
			inorderTraversalCore(root.right, res);
		}
	}
}
