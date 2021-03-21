package leetcode.easy;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class OneZeroFourMax {
//获取二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right));
//        深度优先遍历：左子树和右子树的最大深度 ll 和 rr，那么该二叉树的最大深度即为max(l,r)+1
//        左子树和右子树的最大深度又可以以同样的方式进行计算

    }

    public int maxDepth2(TreeNode root) {
        if(root==null){
            return 0;
        }
//        初始化一个队列，并且将root放入队列，队列存放的是每一层的节点
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
//        初始化深度
        int ans=0;
//        判断，当队列不为空的时候就循环
        while(!queue.isEmpty()){
//            获取这一层的数量
            int size = queue.size();
            while(size>0){
//                遍历这一层的每一个节点，并将每个节点的左子节点和右子节点加入队列中
                TreeNode poll = queue.poll();
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
                size--;
            }
//            深度+1
            ans++;
        }
        return ans;
    }
}
