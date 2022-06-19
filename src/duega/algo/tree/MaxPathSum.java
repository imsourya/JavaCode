package duega.algo.tree;


public class MaxPathSum {
	
	static class TreeNode {
		public int value;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	static int MaxSumPath( TreeNode root ) {
		if(root == null) return 0;
		
		int leftHeight  = MaxSumPath(root.left);
		int rightHeight = MaxSumPath(root.right);
		
		int max_linear = Math.max(Math.max(leftHeight, rightHeight)+root.value, root.value) ;
		
		int max_umbrella = Math.max(max_linear, leftHeight+rightHeight+root.value);
		
		return max_linear;
	}
	
	public static void main(String[] args) {
		
		TreeNode root    = new TreeNode(10);
	    root.left        = new TreeNode(2);
	    root.right       = new TreeNode(10);
	    root.left.left   = new TreeNode(20);
	    root.left.right  = new TreeNode(1);
	    root.right.right = new TreeNode(-25);
	    root.right.right.left   = new TreeNode(3);
	    root.right.right.right  = new TreeNode(4);
		
		System.out.println(MaxSumPath(root));
		
		
	}

}
