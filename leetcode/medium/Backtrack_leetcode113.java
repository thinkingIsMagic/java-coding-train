package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import leetcode.utils.TreeNode;

// 思路：回溯、dfs
// 时间复杂度：O(N) ，遍历所有节点
// 空间复杂度：O(N)、res、path：O(n)，递归栈深度O(h)=log(n)
public class Backtrack_leetcode113 {
    // 输入：树 、求什么：所有路径、约束：无
    // 所有 -> 回溯

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    public void dfs(TreeNode root, int targetSum){
        if(root==null) return;

        path.add(root.val);
        targetSum-=root.val;
        if(root.left==null && root.right==null){
            if(targetSum==0){
                res.add(new ArrayList<>(path));
            }
        }else{
            this.dfs(root.left, targetSum);
            this.dfs(root.right, targetSum);
        }
        // 回溯
        targetSum+=root.val;
        path.remove(path.size()-1);
    }
}
