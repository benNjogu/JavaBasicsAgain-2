package com.keytech;

public class Tree {

	private TreeNode root;
	
	public void insert(int value) {
		if (root == null) {
			root = new TreeNode(value);
		}else {
			root.insert(value);
		}
	}
	
	public int get(int value) {
		if (root != null) {
			return root.get(value);
		}
		
		return 0;
	}
	
	public void delete(int value) {
		root = delete(root, value);
	}
	
	private TreeNode delete(TreeNode subtreeRoot, int value) {
		if (subtreeRoot == null) {
			return subtreeRoot;
		}
		if(value < subtreeRoot.getData()) {
			subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
		}else if(value > subtreeRoot.getData()) {
			subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
		}else {
			//case where node is a leaf or it only has one child 
			if (subtreeRoot.getLeftChild() == null) {
				return subtreeRoot.getRightChild();
			}else if (subtreeRoot.getRightChild() == null){
				return subtreeRoot.getLeftChild();
			}
			
			//node to delete has two children
			
			/*
			 * Replace the value in the subtree root node with the smallest value
			 * from the right subtree 
			 * */ 
			subtreeRoot.setData(subtreeRoot.getRightChild().min());
			/*
			 * Delete the node that have the smallest value in the right subtree
			 * */
			subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
		}
		
		return subtreeRoot;
	}

	public int min() {
		if (root == null) {
			return Integer.MIN_VALUE;
		}else {
			return root.min();
		}
	}
	
	public int max() {
		if (root == null) {
			return Integer.MAX_VALUE;	
		}else {
			return root.max();
		}
	}
	
	public void traverseInOrder() {
		if (root != null) {
			root.traverseInOrder();
		}
	}
	
	public void traversePreOrder() {
		if (root != null) {
			root.traversePreOrder();
		}
	}
	
	public void traversePostOrder() {
		if (root != null) {
			root.traversePostOrder();
		}
	}
	
}
