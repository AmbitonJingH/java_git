
/*
 * @author  AmbitionJingH
 * @date  2023/9/8 18:49
 * @version 1.0
 */

public class leetCode1232 {
    public static boolean checkStraightLine(int[][] coordinates) {
        int k = (coordinates[coordinates.length-1][1]-coordinates[0][1])/(coordinates[coordinates.length-1][0]-coordinates[0][0]);
        for (int i = 1; i < coordinates.length-1; i++) {
            int x1 = coordinates[i][0] - coordinates[i-1][0];
            int y1 = coordinates[i][1] - coordinates[i-1][1];
            int x2 = coordinates[i+1][0] - coordinates[i-1][0];
            int y2 = coordinates[i+1][1] - coordinates[i-1][1];
            if(x1*y2!=x2*y1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
