/*
Question:
A binary tree is uni-valued if every node in the tree has the same value.

Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.
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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null)
        {
            return true;
        }
        int value=root.val;
        return inorder(root,value);
    }
    public boolean inorder(TreeNode root,int value)
{
    if(root == null)
    {
        return true;
    }
    else if(root.val != value)
    {
        return false;
    }
    boolean l=inorder(root.left,value);
    boolean r=inorder(root.right,value);
    return l && r; 
}

    }
