
/*
 * @author  AmbitionJingH
 * @date  2023/8/31 21:32
 * @version 1.0
 */

import java.util.Scanner;

public class AcWing5181 {
    public static void main(String[] args) {
        int n,ans = 0;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i=0;i<=n/4;i++){
            if((n-4*i)%5==0)
                ans++;
        }
        System.out.println(ans);
    }
}
