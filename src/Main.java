public class Main {
    public static void main(String[] args) {
        // Test for CourseSchedule
        int[][] prerequisites = {{1,0}};
        int numCourses = 2;

        System.out.println(CourseSchedule.canFinish(numCourses, prerequisites));
        // Output: True;

        // Test for Network Delay Time
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;

        System.out.println(NetworkDelayTime.networkDelayTime(times, n, k));
        // Output: 2

        // Test for Optimize Village
        int n2 = 3;
        int[] wells = {1,2,2};
        int[][] pipes = {{1,2,1},{2,3,1}};

        System.out.println(OptimizeWaterVillage.minCostToSupplyWater(n2, wells, pipes));
        // Output: 2
    }
}
