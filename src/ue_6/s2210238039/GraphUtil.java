package ue_6.s2210238039;

public class GraphUtil {
    public static boolean existPath(int[][] adjacencyMatrix, int start, int end) {
        int n = adjacencyMatrix.length;
        boolean[] visited = new boolean[n];
        return dfs(adjacencyMatrix, start, end, visited);
    }

    private static boolean dfs(int[][] adjacencyMatrix, int current, int end, boolean[] visited) {
        if (current == end) {
            return true;
        }

        visited[current] = true;

        for (int neighbor = 0; neighbor < adjacencyMatrix.length; neighbor++) {
            if (adjacencyMatrix[current][neighbor] == 1 && !visited[neighbor]) {
                if (dfs(adjacencyMatrix, neighbor, end, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
