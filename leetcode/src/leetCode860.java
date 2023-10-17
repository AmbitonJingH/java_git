
/*
 * @author  AmbitionJingH
 * @date  2023/9/7 20:06
 * @version 1.0
 */

public class leetCode860 {
    public static boolean lemonadeChange(int[] bills) {
        if(bills[0]!=5)
            return false;
        else {
            int[] money = new int[2];
            for (int i = 0; i < bills.length; i++) {
                if(bills[i]==5)
                    money[0]++;
                else if(bills[i]==10) {
                    money[0]--;
                    money[1]++;
                }
                else{
                    if(money[1]!=0) {
                        money[1]--;
                        money[0]--;
                    }else {
                        money[0] -= 3;
                    }
                    //money[0] -= 3;
                }
                if (money[0]<0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,5,5,10,20};
        System.out.println(lemonadeChange(arr));
    }
}
