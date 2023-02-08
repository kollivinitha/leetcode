/*
Question:
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

*/

Solution:

class Pair
{
    int row;
    int col;
    Pair(int row,int col)
    {
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=0; 
        int r=isConnected.length;
        int[] vis=new int[r];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<r;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<r;j++)
            {
                if((isConnected[i][j]==1) && (i!=j))
                {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        for(int k=0;k<r;k++){
            if(vis[k] == 0)
            {
                dfs(adj,k,vis);
                n+=1;
            }
                
        }
        return n; 
    }
    public void dfs(List<List<Integer>> adj,int a,int[] vis)
    {
        vis[a]=1;
        for(int val:adj.get(a)){
            if(vis[val]==0){
                dfs(adj,val,vis);
            }
        }
    }
}
