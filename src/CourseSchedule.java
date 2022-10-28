import java.util.ArrayList;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create Array of lists -> adjecency matrix of graph
        ArrayList<Integer>[] adj = new ArrayList[numCourses];


        for(int i=0; i<numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        //create graph
        for(int[] pre : prerequisites) {
            adj[pre[0]].add(pre[1]);
        }


        int[] visited = new int[numCourses];

        // check for cycles
        for(int i=0; i<numCourses; i++) {
            if( !dfs(i, visited, adj))
                return false;
        }

        return true;
    }

    public static boolean dfs(int node, int[] visited, ArrayList<Integer>[] adj) {
        // Return false if the node is visited and viewed again before completion
        if(visited[node] == 1) {
            return false;
        }

        // Return true if the node is completed processing
        if(visited[node] == 2) {
            return true;
        }


        visited[node] = 1;

        // DFS of all the other nodes current "node" is connected to
        for(int n : adj[node]) {
            if(!dfs(n, visited, adj))
                return false;
        }

        // If no more other nodes for the current "node" mark as completed and return true

        visited[node] = 2;

        return true;
    }
}
