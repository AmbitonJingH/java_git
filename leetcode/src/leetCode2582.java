
/*
 * @author  AmbitionJingH
 * @date  2023/9/26 9:29
 * @version 1.0
 */

public class leetCode2582 {
    public static int passThePillow(int n, int time) {
        if(time<n){
            return time+1;
        }
        int i =1;
        boolean temp = true;
        while (time!=0){
            if(temp){
                i++;
                time--;
            }else {
                i--;
                time--;
            }
            if(i==n)
                temp = false;
            if(i==1)
                temp = true;
        }
        return i;

    }

    public static void main(String[] args) {
        int i = passThePillow(18, 38);
        System.out.println(i);
    }
}
