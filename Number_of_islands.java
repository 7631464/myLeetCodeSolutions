public class Solution {
    public int numIslands(char[][] grid) {
        int res=0;
        if (grid.length==0) return 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j]=='1') {res++; dfs(i,j, grid);}
            }
        }
        return res;
    }
    public void dfs(int i, int j, char[][] grid) {
        grid[i][j]='2';
        if (i>0 && grid[i-1][j]=='1') dfs(i-1, j, grid);
        if (i<grid.length-1 && grid[i+1][j]=='1') dfs(i+1, j, grid);
        if (j>0 && grid[i][j-1]=='1') dfs(i,j-1, grid);
        if (j<grid[0].length-1 && grid[i][j+1]=='1') dfs(i, j+1, grid);
    }
}
