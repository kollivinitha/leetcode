Question:
You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:
Create a root node whose value is the maximum value in nums.
Recursively build the left subtree on the subarray prefix to the left of the maximum value.
Recursively build the right subtree on the subarray suffix to the right of the maximum value.
Return the maximum binary tree built from nums.
 
Solution:
/*
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
    public TreeNode inorder(int[] nums,int s,int e)
    {
        if((s>e)||(s<0))
        {
            return null;
        }
        int index=s;
        for(int i=s;i<=e;i++)
        {
            if(nums[i] > nums[index])
            {
                index=i;
            }
        }
        System.out.println(index);
        TreeNode root = new TreeNode(nums[index]);
        root.left=inorder(nums,s,index-1);
        root.right=inorder(nums,index+1,e);
        return root;

    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n=nums.length-1;
        int s=0;
        if(n+1 == s)
        {
            return null;
        }
        return inorder(nums,s,n);   
    }
}
