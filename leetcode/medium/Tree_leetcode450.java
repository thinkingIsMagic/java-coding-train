package leetcode.medium;

import leetcode.utils.TreeNode;

public class Tree_leetcode450 {
    // 输入：树、求什么：删除节点、约束：二叉搜索树
    // 二叉搜索树、删除 -> BST性质、递归
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;

        if(key<root.val){
            root.left = deleteNode(root.left, key);
        }else if(key>root.val){
            root.right = deleteNode(root.right, key);
        }else{
            // 删除操作
            if(root.left==null && root.right==null){
                return null;
            }else if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }else{
                // 都不为null、左子树搬到右子树最最下角节点的left
                TreeNode rightTmp = root.right;
                while(rightTmp.left!=null){
                    rightTmp = rightTmp.left;
                }
                rightTmp.left = root.left;
                return root.right;
            }
        }
        return root;
    }
}
