/*
Question:

A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.

Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.

The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.

The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).

Return the number of minutes needed to inform all the employees about the urgent news.

*/
Solution:
class Solution {
    int res=0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    HashMap<Integer,List<Integer>> map=new HashMap<>();
    for(int i=0;i<n;i++)
    {
        int u=manager[i];
        if(u==-1)
        {
            continue;
        }
        else if(!map.containsKey(u))
        {
            List<Integer> l=new ArrayList<>();
            l.add(i);
            map.put(u,l);
        }
        else
        {
           List<Integer> l=map.get(u);
            l.add(i);
            map.put(u,l); 
        }
    }
    
    timeNeeded(headID,map,informTime,0);    
        return res;
    }
    public void timeNeeded(int headID,HashMap<Integer,List<Integer>> map,int[] informTime,int t)
    {
        if(informTime[headID] == 0)
        {
            return;
        }
        else
        {
            t+=informTime[headID];
            List<Integer> list=map.get(headID);
            for(int i=0;i<list.size();i++)
            {
                timeNeeded(list.get(i),map,informTime,t);
                if(t>res)
                {
                    res=t;
                }
            }
        }
        
    }
}
