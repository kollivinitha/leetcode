/*
Question:
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

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
    public int numIslands(char[][] grid) {
        int n=0; 
        int rows=grid.length;
        int cols=grid[0].length;
        int[][] vis=new int[rows][cols];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if((grid[i][j]=='1') && (vis[i][j] == 0))
                {
                    bfs(grid,i,j,vis);
                    n+=1;
                }
            }
        }
        return n; 
    }
    public void bfs(char[][] grid,int r,int c,int[][] vis)
    {
        Queue<Pair> queue = new LinkedList<>();
        int rows=grid.length;
        int cols=grid[0].length;
        int[] offsetr={-1,0,1,0};
        int[] offsetc={0,1,0,-1};
        queue.offer(new Pair(r,c));
        vis[r][c]=1;
        while(!queue.isEmpty())
        {
            Pair node = queue.poll();
            int rs=node.row;
            int cs=node.col;
            for(int i=0;i<4;i++)
            {
                int u=rs+offsetr[i];
                int v=cs+offsetc[i];
                if(u>=0 && u<rows && v>=0 && v<cols && grid[u][v]=='1' && (vis[u][v] == 0))
                {
                    vis[u][v]=1;
                    queue.offer(new Pair(u,v));
                }
            }
        }
    }
}
