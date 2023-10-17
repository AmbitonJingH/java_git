
/*
 * @author  AmbitionJingH
 * @date  2023/9/22 23:47
 * @version 1.0
 */

public class leetCode2591 {
    public static int distMoney(int money, int children) {
        int count = 0;
        if(money<children )
            return -1;
        if(money>children*8)
            return children-1;
        if(money==8*children-4)
            return children-2;
        return (money-children)/7;
    }

    public static void main(String[] args) {

    }
}
