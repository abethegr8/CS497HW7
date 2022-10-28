import java.util.*;

public class OptimizeWaterVillage {
    static Map<Integer, List<int[]>> graph=new HashMap<>();
    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        populate(n,pipes);
        Set<Integer> visited=new HashSet<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int i=0;i<wells.length;i++){
            graph.get(0).add(new int[]{i+1,wells[i]});
            pq.offer(new int[]{0,i+1,wells[i]});
        }
        visited.add(0);
        int total=0;
        while(!pq.isEmpty()){
            if(visited.size()==n+1) break;
            int []current=pq.poll();
            if(!visited.contains(current[1])){
                total+=current[2];
                visited.add(current[1]);
                for(int []nei:graph.get(current[1])){
                    if(!visited.contains(nei[0])){
                        pq.offer(new int[]{current[1],nei[0],nei[1]});
                    }
                }
            }

        }
        return total;
    }
    public static void populate(int n, int[][] pipes){
        for(int i=0;i<=n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int []edge:pipes){
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }

    }
}
