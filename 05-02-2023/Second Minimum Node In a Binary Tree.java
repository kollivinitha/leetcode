/*
Question:
Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Solution:
*/
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
    int min;
    boolean flag=false;
    int res=Integer.MAX_VALUE;
    public void getMin(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
      if(root.val>min && root.val<=res){
          res=root.val;
          flag=true;
      }else if(root.val==min)
      {
          getMin(root.left);
          getMin(root.right);
      }
    }
    public int findSecondMinimumValue(TreeNode root) {
     if(root==null)
     {
         return -1;
     }
      min=root.val;
      getMin(root);
      if(flag)
      {
          return res;
      }
      return -1;

    }
}
