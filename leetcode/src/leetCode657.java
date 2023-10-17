
/*
 * @author  AmbitionJingH
 * @date  2023/9/6 18:43
 * @version 1.0
 */

public class leetCode657 {
    public static boolean judgeCircle(String moves) {
        int[] flag = new int[2];
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)){
                case 'U':
                    flag[0]++;
                    break;
                case 'D':
                    flag[0]--;
                    break;
                case 'R':
                    flag[1]++;
                    break;
                case 'L':
                    flag[1]--;
                    break;
            }
        }
        return flag[1]==0&&flag[0]==0;
    }

    public static void main(String[] args) {
        String abc = "LL";
        System.out.println(judgeCircle(abc));
    }
}
