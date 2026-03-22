package leetcode.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import leetcode.utils.TreeNode;

public class Tree_leetcode102 {
    // 队列：头节点入队 -> while循环、当前队列长度 -> 出队 子节点入队
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelLength = queue.size();
            List<Integer> levelRes = new ArrayList<>();
            for(int i=0; i<levelLength; i++){
                TreeNode cur = queue.poll();
                levelRes.add(cur.val);

                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
            res.add(levelRes);
        }
        return res;
    }
}
