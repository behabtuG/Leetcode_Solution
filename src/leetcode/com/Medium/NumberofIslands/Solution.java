package leetcode.com.Medium.NumberofIslands;

public class Solution {
    public static int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j)
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ++ans;
                }
        return ans;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length)
            return;
        if (grid[i][j] != '1')
            return;
        grid[i][j] = '2'; // Mark '2' as visited
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
    public static void main(String[] args){
       String[][] grid = {
               {"1","1","0","0","0"},
               {"1","1","0","0","0"},
               {"0","0","1","0","0"},
               {"0","0","0","1","1"}};// Output: 3

       // System.out.println(numIslands(String.valueOf(grid)));
    }
}
