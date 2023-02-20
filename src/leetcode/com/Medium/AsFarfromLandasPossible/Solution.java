package leetcode.com.Medium.AsFarfromLandasPossible;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * public static int maxDistance(int[][] grid) {
     * final int m = grid.length;
     * final int n = grid[0].length;
     * final int[] dirs = {0, 1, 0, -1, 0};
     * Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();
     * int water = 0;
     * <p>
     * for (int i = 0; i < m; ++i)
     * for (int j = 0; j < n; ++j)
     * if (grid[i][j] == 0)
     * ++water;
     * else
     * q.offer(new Pair<>(i, j));
     * <p>
     * if (water == 0 || water == m * n)
     * return -1;
     * <p>
     * int ans = 0;
     * <p>
     * for (int d = 0; !q.isEmpty(); ++d)
     * for (int sz = q.size(); sz > 0; --sz) {
     * AbstractMap.SimpleEntry<Integer, Integer> pair = q.poll();
     * final int i = pair.getKey();
     * final int j = pair.getValue();
     * ans = d;
     * for (int k = 0; k < 4; ++k) {
     * final int x = i + dirs[k];
     * final int y = j + dirs[k + 1];
     * if (x < 0 || x == m || y < 0 || y == n)
     * continue;
     * if (grid[x][y] > 0)
     * continue;
     * q.offer(new Pair<>(x, y));
     * grid[x][y] = 2; // Mark as visited.
     * }
     * }
     * <p>
     * return ans;
     * }
     */
    /**
     * public static int maxDistance(int[][] grid) {
     * int m = grid.length, n = grid[0].length;
     * Queue<int[]> queue = new LinkedList<>();
     * boolean[][] visited = new boolean[m][n];
     * for (int i = 0; i < m; i++) {
     * for (int j = 0; j < n; j++) {
     * if (grid[i][j] == 1) {
     * queue.offer(new int[]{i, j});
     * visited[i][j] = true;
     * }
     * }
     * }
     * <p>
     * if (queue.isEmpty() || queue.size() == m * n) {
     * return -1;
     * }
     * int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
     * int step = 0;
     * while (!queue.isEmpty()) {
     * for (int size = queue.size(), i = 0; i < size; i++) {
     * int[] curr = queue.poll();
     * for (int[] dir : DIRS) {
     * int nextRow = curr[0] + dir[0], nextCol = curr[1] + dir[1];
     * if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]
     * || grid[nextRow][nextCol] == 1) {
     * continue;
     * }
     * queue.offer(new int[]{nextRow, nextCol});
     * visited[nextRow][nextCol] = true;
     * }
     * }
     * step++;
     * }
     * return step;
     * }
     */

    //function that find the number of islands
    public static int findIslands(char[][] matrix) {
        //finds and stores the length of the matrix or grid
        int h = matrix.length;
        if (h == 0)
            //if matrix has no elements, returns 0
            return 0;
        int l = matrix[0].length;
        //variable to store result
        int result = 0;
        //loop iterates over rows
        for (int i = 0; i < h; i++) {
            //loop iterates over columns
            for (int j = 0; j < l; j++) {
                if (matrix[i][j] == '1') {
                    //if the above condition returns true, calls the dfs() function and increments the result
                    dfs(matrix, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    //function performs the depth first search over the matrix
    public static void dfs(char[][] matrix, int row, int col) {
        int H = matrix.length;
        int L = matrix[0].length;
        //returns true if any of the condition returns true
        if (row < 0 || col < 0 || row >= H || col >= L || matrix[row][col] != '1')
            return;
        //marking element as visited
        matrix[row][col] = '0';
        //moves in right direction
        dfs(matrix, row + 1, col);
        //moves in left direction
        dfs(matrix, row - 1, col);
        //moves in downward direction
        dfs(matrix, row, col + 1);
        //moves in upward direction
        dfs(matrix, row, col - 1);
    }

    public static void main(String[] args) {
        //int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};//Output: 4
        // System.out.println(findIslands(grid));

        //creating an instance of teh class
        Solution noi = new Solution();
//grid in which we have to find number of islands
        char[][] islandGrid = new char[][]
                {
                       // {'1', '1', '0', '0', '0'},
                       // {'1', '1', '0', '0', '0'},
                       // {'0', '0', '1', '0', '0'},
                       // {'0', '0', '0', '1', '1'}

                        {1, 0, 0}, {0, 0, 0}, {0, 0, 0}
                };
//prints the result
        System.out.println("Number of Islands: " + noi.findIslands(islandGrid));
    }
}

