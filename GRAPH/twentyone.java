//Floyd Warshall - https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1


public class twentyone {
    public void shortestDistance(int[][] mat) {
        int n = mat.length;
        int INF = (int) 1e9; // A large value representing infinity

        // Step 1: Replace -1 with a large number (INF), except for diagonal elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == -1) {
                    mat[i][j] = INF;
                }
                if(i == j) mat[i][j] = 0; // Distance from a node to itself is always 0
            }
        }

        // Step 2: Floyd-Warshall Algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }

        // Step 3: Convert back INF values to -1 for unreachable paths
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == INF) 
                    mat[i][j] = -1;
            }
        }
    }
}


//TC: 0(n^3)