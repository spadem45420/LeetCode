package prac;


/**
 * 
 * 	Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two 
 * 	trees are overlapped while the others are not.

	You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node 
	values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
	
	Example 1:
	Input: 
		Tree 1                     Tree 2                  
	          1                         2                             
	         / \                       / \                            
	        3   2                     1   3                        
	       /                           \   \                      
	      5                             4   7                  
	Output: 
	Merged tree:
		     3
		    / \
		   4   5
		  / \   \ 
		 5   4   7
	Note: The merging process must start from the root nodes of both trees.
 *
 */
public class MergeTwoBinaryTrees {
	
	public static void main(String[] args) {
		MergeTwoBinaryTrees mtbt = new MergeTwoBinaryTrees();
		Integer[] t1 = {1,3,2,5,null,null,null};
		Integer[] t2 = {2,1,3,null,4,null,7};
		TreeNode treeNode = mtbt.mergeTrees(mtbt.makeTree(t1), mtbt.makeTree(t2));
		System.out.println(treeNode);
//		System.out.println(treeNode);
//		System.out.println(treeNode.left + " " + treeNode.right);
//		System.out.println(treeNode.left.left + " " + treeNode.left.right + " " + treeNode.right.left + " " + treeNode.right.right);
	}
	
	/**
	 * 這種寫法的循環方式會先探索所有最左邊的節點，也就是先跑過step1
	 * 然後再進行step2，在進行step2的時候，又會先探索完所有的step1
	 * 然後再回到step2，最後才會合併自身的節點，也就是step3，回傳t1
	 * 
	 * 敞若遇到t1為空節點的情況，則回傳t2(因為要將節點相加，也就是說t1 + t2，但是因為t1是空的，所以t1+t2=t2)，反之則亦然
	 */
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		
		// 先判斷t1、t2節點是否存在
        if (t1 != null && t2 != null) {
        	
        	// step1
        	// 先合併leftNode
            t1.left = mergeTrees(t1.left, t2.left);
            
            // step2
            // 在合併rightNode
            t1.right = mergeTrees(t1.right, t2.right);
            
            // step3
            // 合併自身Node
            t1.val += t2.val;
            return t1;
        }
        return t1 == null ? t2 : t1;
    }

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
		
		public String toString() {
			return String.valueOf(val);
		}
	}

	/**
	 * 這個方法是方便產生TreeNode用的
	 * 可以簡易的將陣列轉成TreeNode
	 * 是參考某個博客上的寫法
	 */
	public TreeNode makeTree(Integer[] arr) {
		TreeNode []nodes = new TreeNode[arr.length + 1];
        for (int i = 1; i < nodes.length; i++) {
            if (arr[i - 1] != null) {
                nodes[i] = new TreeNode(arr[i - 1]);
            }else {
                nodes[i] = null;
            }
        }
        
        TreeNode node = null;
        for (int i = 1; i < nodes.length / 2; i++) {
            node = nodes[i];
            if (node == null) continue;
            node.left = nodes[2 * i];
            node.right = nodes[2 * i + 1];
        }
        return nodes[1];
	}
	
	/**
	 * TreeNode逆向轉回陣列的方式沒有寫出來
	 */
	public Integer[] makeArray(TreeNode tree) {
		// ... TODO
		return null;
	}
}
