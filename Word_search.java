public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length==0) return false;
        int len1=board.length, len2=board[0].length;
        int[][] mark=new int[len1][len2];
        for (int i=0; i<len1; i++) {
            for (int j=0; j<len2; j++) mark[i][j]=0;
        }
        for (int i=0; i<len1; i++) {
            for (int j=0; j<len2; j++) {
                if (dfs(i, j, 0, word, board, mark)) return true;
            }
        }
        return false;
        
    }
    public boolean dfs(int i, int j, int start, String word, char[][] board, int[][] mark) {
        if (mark[i][j]==1 || board[i][j]!=word.charAt(start)) return false;
        mark[i][j]=1;
        if (start==word.length()-1) return true;
        if (i+1<board.length && dfs(i+1,j, start+1, word, board, mark)) return true;
        if (i-1>=0 && dfs(i-1,j, start+1, word, board, mark)) return true;
        if (j+1<board[0].length && dfs(i,j+1, start+1, word, board, mark)) return true;
        if (j-1>=0 && dfs(i,j-1, start+1, word, board, mark)) return true;
        mark[i][j]=0;
        return false;
    }
}
