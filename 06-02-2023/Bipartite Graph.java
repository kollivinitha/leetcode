/*
Question:
There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.

*/

class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int size=graph.length;
        int v[] = new int[size];
        Arrays.fill(v,0);
        for(int i=0;i<size;i++)
        {
            if(v[i]==0)
            {
                if(!check(i,graph,v))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean check(int s,int[][] graph,int[] v)  
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        v[s]=1;
        while(!(queue.isEmpty()))
        {
            int u=queue.poll();
            for(int i:graph[u])
            {
                if(v[i]==0)
                {
                    v[i]=v[u]+1;
                    queue.add(i);
                }
                else if(v[i]==v[u])
                {
                    return false;
                }
            }
        }
        return true;
    }
}
