package ue_6.s2210238039;

public class GraphUtil {

    // Anmerkung:
    // Wurde mithilfe ChatGPT gelöst:
    public static boolean existPath(int[][] adjacencyMatrix, int start, int end) {
        int vertices = adjacencyMatrix.length;
        boolean[] visited = new boolean[vertices];
        return dfs(adjacencyMatrix, start, end, visited);
    }

    private static boolean dfs(int[][] adjacencyMatrix, int current, int end, boolean[] visited) {
        visited[current] = true;

        if (current == end) {
            return true;
        }

        for (int neighbor = 0; neighbor < adjacencyMatrix[current].length; neighbor++) {
            if (adjacencyMatrix[current][neighbor] == 1 && !visited[neighbor]) {
                if (dfs(adjacencyMatrix, neighbor, end, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

}
