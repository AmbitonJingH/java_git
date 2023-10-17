
/*
 * @author  AmbitionJingH
 * @date  2023/9/7 19:40
 * @version 1.0
 */

public class leetCode1523 {
    public int countOdds(int low, int high) {
        if((high-low+1)%2==0)
            return (high-low+1)/2;
        else {
            if(low%2==0)
                return (high-low)/2;
            else
                return (high-low)/2+1;
        }
    }

    public static void main(String[] args) {

    }
}
