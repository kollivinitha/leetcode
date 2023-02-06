Question:
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
A leaf is a node with no children.
  
Solution:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean pathSum(TreeNode root,int sum,int target)
    {
        if(root == null)
        {
            return false;
        }
        else if(root.left == null && root.right==null)
        {
            int temp=sum+root.val;
            return(temp==target);
        }
        sum+=root.val;
        boolean l=pathSum(root.left,sum,target);
        boolean r=pathSum(root.right,sum,target);
        return l || r;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum=0;
        return pathSum(root,sum,targetSum);
    }
}
