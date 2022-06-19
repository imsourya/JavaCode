package duega.algo.tree;

public class HeightOfBinaryTree {
	
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
	
	static int heightOfBinaryTree( TreeNode root ) {
		if(root == null) return 0;
		
		int leftHeight = heightOfBinaryTree(root.left);
		int rightHeight = heightOfBinaryTree(root.right);
		
		return 1+Math.max(leftHeight, rightHeight);
	}
	
	public static void main(String[] args) {
		
		TreeNode Root = new TreeNode(10);
		
		TreeNode Left = new TreeNode(3);
		
		TreeNode Right = new TreeNode(16);
		
		Root.left = Left;
		Root.right = Right;
		
		System.out.println(heightOfBinaryTree(Root));
	}
}
