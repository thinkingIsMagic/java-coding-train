package leetcode.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import leetcode.utils.TreeNode;

public class Tree_leetcode103 {
    /**
    * 思路：层序遍历，reverse标识、双端队列Deque（存储每一层的结果）
    * 保存节点时：
    * 正向：节点正常添加至队尾 levelRes.offer()
    * 反向：节点添加至队头 levelRes.offerFirst()
    */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;

        while(!queue.isEmpty()){
            int levelLength = queue.size();
            Deque<Integer> levelRes = new LinkedList<>();
            for(int i=0; i<levelLength; i++){
                TreeNode cur = queue.poll();
                if(reverse){
                    levelRes.offerFirst(cur.val);
                }else{
                    levelRes.add(cur.val);
                }

                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
            res.add(new ArrayList<>(levelRes));
            reverse = !reverse;
        }
        return res;
    }
}
