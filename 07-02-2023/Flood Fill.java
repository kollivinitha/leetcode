/*
Question

An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.

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
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Pair> queue=new LinkedList<>();
        int rows=image.length;
        int cols=image[0].length;
        queue.offer(new Pair(sr,sc));
        int temp=image[sr][sc];
        image[sr][sc]=color;
        int[] offsetr={-1,0,1,0};
        int[] offsetc={0,1,0,-1};
        while(!queue.isEmpty())
        {
            Pair node=queue.poll();
            int r=node.row;
            int c=node.col;
            for(int i=0;i<4;i++)
            {
                int u=r+offsetr[i];
                int v=c+offsetc[i];
                if(u>=0 && u<rows && v>=0 && v<cols && image[u][v] == temp && image[u][v] != color)
                {
                    image[u][v]=color;
                    queue.offer(new Pair(u,v));
                }
            }

        }
        return image;   
    }
}
