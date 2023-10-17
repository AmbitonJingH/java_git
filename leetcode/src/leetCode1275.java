
/*
 * @author  AmbitionJingH
 * @date  2023/9/6 19:13
 * @version 1.0
 */

public class leetCode1275 {
    public static String tictactoe(int[][] moves) {
        String[][] game = new String[3][3];
        for (int i = 0; i < moves.length; i++) {
            int i1 = moves[i][0];
            int i2 = moves[i][1];
            if(i%2==0) {
                game[i1][i2] = "X";
            }else {
                game[i1][i2] = "O";
            }
            //System.out.println("["+i1+","+i2+"]");
        }
        for (int i = 0; i < 3; i++) {
            if(game[i][0].equals(game[i][1])&&game[i][0].equals(game[i][2])&&game[i][0].equals("X"))
                return "A";
            else if(game[i][0].equals(game[i][1])&&game[i][0].equals(game[i][2])&&game[i][0].equals("O"))
                return "B";
            //else if()
        }
        return "";
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{0,0},{2,0},{1,1},{2,1},{2,2}};
        tictactoe(a);
    }
}
