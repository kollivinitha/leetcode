/*
Question:
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

*/
Solution:

class Pair
{
    int row;
    int col;
    int count;
    Pair(int row,int col,int count)
    {
        this.row=row;
        this.col=col;
        this.count=count;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int[] offsetr={-1,-1,-1,0,0,1,1,1};
        int[] offsetc={-1,0,1,-1,1,-1,0,1};
        Queue<Pair> queue = new LinkedList<>();
        if(grid[0][0] == 0 && grid[n-1][n-1] == 0)
        {
            grid[0][0]=2;
            queue.offer(new Pair(0,0,1));
            while(!queue.isEmpty())
            {
                Pair node=queue.poll();
                int rv=node.row;
                int cv=node.col;
                int val=node.count;
                if(rv==n-1 && cv==n-1)
                {
                    return val;
                }
                for(int i=0;i<offsetr.length;i++)
                {
                    int r=rv+offsetr[i];
                    int c=cv+offsetc[i];
                    if(r>=0 && r<n && c>=0 && c<n && grid[r][c] == 0)
                    {
                        grid[r][c]=2;
                        queue.offer(new Pair(r,c,val+1));
                    }
                }
        }
        return -1;
        }
    return -1;
    }
}
