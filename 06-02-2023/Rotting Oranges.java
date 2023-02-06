/*
Question:
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

*/

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
    public int orangesRotting(int[][] grid) {
      Queue<Pair> queue=  new LinkedList<>();
      boolean visit=false;
      int rows=grid.length;
      int time=0;
      int cols=grid[0].length;
      for(int i=0;i<rows;i++){
          for(int j=0;j<cols;j++)
          {
              if(grid[i][j]==2)
              {
                  queue.offer(new Pair(i,j));
              }
          }
      }
      int[] offsetr={-1,0,1,0};
      int[] offsetc={0,1,0,-1};
      while(!queue.isEmpty())
      {
          boolean vis=false;
          int size=queue.size();
          for(int j=0;j<size;j++)
          {
              Pair node=queue.poll();
              int r=node.row;
              int c=node.col;
              for(int i=0;i<4;i++)
              {
                  int u=r+offsetr[i];
                  int v=c+offsetc[i];
                  if(u>=0 && u<rows && v>=0 && v<cols && grid[u][v]==1)
                  {
                      vis=true;
                      grid[u][v]=2;
                      queue.offer(new Pair(u,v));
                  }
              }
          }
          if(vis)
          {
              time++;
          }
              
      }
      for(int i=0;i<rows;i++){
          for(int j=0;j<cols;j++)
          {
              if(grid[i][j]==1)
              {
                  return -1;
              }
          }
      }
      return time;
    }
}
