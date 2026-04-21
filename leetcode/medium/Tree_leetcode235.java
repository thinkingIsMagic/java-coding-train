package leetcode.medium;

import leetcode.utils.TreeNode;

public class Tree_leetcode235 {
    // 输入：树、两个节点、求什么：两个节点的公共祖先、约束：二叉搜索树
    // BST -> BST性质 + 递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) return root;

        if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }
}
