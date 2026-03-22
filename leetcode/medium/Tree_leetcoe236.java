package leetcode.medium;

import leetcode.utils.TreeNode;

public class Tree_leetcoe236 {
    // 输入：树、求什么：最近公共祖先、约束：无
    // 树、可以拆成相同分子问题 -> 递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left!=null && right!=null){
            return root;
        }
        return left==null ? right: left;
    }
}
