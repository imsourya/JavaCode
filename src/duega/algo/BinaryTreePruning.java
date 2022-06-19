package duega.algo;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class BinaryTreePruning {
	
	boolean postOrder(TreeNode root) {
		if(root == null) return false;
		boolean leftRes  = postOrder(root.left);
		boolean rightRes = postOrder(root.right);
		
		if(leftRes == false && rightRes == false) {
			root.left = null;
			root.right = null;
			if(root.val == 0) {
				return false;
			} 
			return true;
		} else if(leftRes == false) {
			root.left = null;
			return true;
		} else if(rightRes == false) {
			root.right = null;
			return true;
		}
		return true;
	}
	
	public TreeNode pruneTree(TreeNode root) {
		if(postOrder(root))
			return root;
		return null;
	}
	
	void display(TreeNode root) {
		// Level Order Printing using BFS
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(! q.isEmpty()) {
			TreeNode node = q.poll();
			if(Objects.nonNull(node)) {
				System.out.print(node.val+"  ");
				q.add(node.left);
				q.add(node.right);
			}
		}
	}
	
	public TreeNode pruneTree1(TreeNode root) {
		if(root == null) return null;
		root.left = pruneTree(root.left);
		root.right = pruneTree(root.right);
		if(root.left == null && root.right == null && root.val == 0) return null;
		return root;
	}
	
	public static void main(String[] args) {
		BinaryTreePruning b = new BinaryTreePruning();
		/*TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(0);
		
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(1);*/
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(1);
		root.left.left.left = new TreeNode(1);
		
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(0);
		root.right.right.left = new TreeNode(0);
		root.right.right.right = new TreeNode(1);
		
		b.display(root);
		b.pruneTree1(root);
		System.out.println("=======================================");
		b.display(root);
	}
}
