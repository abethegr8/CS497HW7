import java.util.*;

public class NetworkDelayTime {
    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        // create graph
        for (int[] time : times) {
            if(graph.get(time[0]) == null){
                graph.put(time[0], new ArrayList<>());
            }
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        // min heap to process cheapest edges first
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->a[1] - b[1]);

        queue.offer(new int[]{k, 0});

        // a map to keep track of distance for each node
        Map<Integer, Integer> dist = new HashMap<>();


        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            int node = curr[0];
            int weight = curr[1];

            if(dist.containsKey(node)){
                continue;
            }
            dist.put(node, weight);


            if(graph.containsKey(node)){
                for(int[] edge : graph.get(node)){
                    queue.offer(new int[]{edge[0], edge[1] + weight});
                }
            }

        }

        if(dist.size() != n){
            return -1;
        }

        int result = Integer.MIN_VALUE;

        for(int node : dist.keySet()){
            result = Math.max(result, dist.get(node));
        }
        return result;
    }
}
