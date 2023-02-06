/*
Question:
Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

If the tree has more than one mode, return them in any order.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.


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
    public void inorder(TreeNode root,HashMap<Integer,Integer> map)
        {
            if(root==null)
            {
                return;
            }
            int r=root.val;
            if(map.containsKey(r)){
                int v=map.get(r);
                map.put(r,v+1);
            }
            else{
            map.put(r,1);
            }
            inorder(root.left,map);
            inorder(root.right,map);
        }
    public int[] findMode(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> l=new ArrayList<>();
        inorder(root,map);
        int max=Collections.max(map.values());
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if(entry.getValue()== max)
            {
                l.add(entry.getKey());
            }
        }
        int n=l.size();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=l.get(i);
        }
        return arr;
    }
}
