package leetcode.easy;

import leetcode.utils.TreeNode;

public class Tree_leetcode104 {

    public int maxDepth(TreeNode root){
        if(root==null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}