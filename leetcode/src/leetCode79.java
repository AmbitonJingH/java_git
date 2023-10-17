
/*
 * @author  AmbitionJingH
 * @date  2023/10/11 20:26
 * @version 1.0
 */

public class leetCode79 {
    static boolean flag = false;
    public static boolean exist(char[][] board, String word) {
        int a = board.length,b=board[0].length;
        int[][] visited = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                dfs(i,j,board,visited,0,word);
            }
        }
        return flag;
    }

    public static void dfs(int i,int j,char[][] board,int[][]visited,int start,String word){
        if(start==word.length()){
            flag = true;
            return;
        }
        if(i<0||i>=board.length||j<0||j>= board[0].length||visited[i][j]==1||board[i][j] != word.charAt(start))
            return;
        visited[i][j]=1;
        dfs(i,j-1,board,visited,start+1,word);
        dfs(i,j+1,board,visited,start+1,word);
        dfs(i-1,j,board,visited,start+1,word);
        dfs(i+1,j,board,visited,start+1,word);
        visited[i][j]=0;
    }

    public static void main(String[] args) {
        char[][] arr = new char[][]{{'A','B','C','E'},
                                    {'S','F','C','S'},
                                    {'A','D','E','E'}};
        String word = "ABCCED";
        boolean exist = exist(arr, word);
        System.out.println(exist);
    }
}
