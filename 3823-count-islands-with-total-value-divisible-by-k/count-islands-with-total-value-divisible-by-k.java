class Solution {
    public int countIslands(int[][] grid, int k) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0 && dfs(grid, i, j) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }
    long dfs(int[][] g, int i, int j) {
        if (i < 0 || j < 0 || i >= g.length || j >= g[0].length || g[i][j] == 0)
            return 0;

        long sum = g[i][j];
        g[i][j] = 0;

        sum += dfs(g, i + 1, j);
        sum += dfs(g, i - 1, j);
        sum += dfs(g, i, j + 1);
        sum += dfs(g, i, j - 1);
        return sum;
    }
}
