package Trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class HeightBT {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int maxDepthIterative(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        int height=0;
        if(root==null)   return height;
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();

            while(size>0) {
                TreeNode curr = q.poll();

                if(curr.left!=null)   q.add(curr.left);
                if(curr.right!=null)    q.add(curr.right);
                size--;
            }
            height++;

        }
        return height;
    }

    public int maxDepth(TreeNode root) {
        if(root==null)  return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int isBalanced(TreeNode root) {
        if(root==null)  return 0;

        int left = isBalanced(root.left);
        int right = isBalanced(root.right);

        //left and right are not height balanced
        if(left==-1 || right ==-1)  return -1;

        //current node is height balanced or not
        if(Math.abs(left-right)>1)  return -1;

        return Math.max(left, right) + 1;
    }
}
