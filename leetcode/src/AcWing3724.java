
/*
 * @author  AmbitionJingH
 * @date  2023/9/3 16:08
 * @version 1.0
 */

import java.util.Scanner;

public class AcWing3724 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int[] road = new int[n + 1];
            int ans = 0;
            for (int i = 1; i <= m; i++) {
                int temp = scanner.nextInt();
                road[temp] = 1;
                if(k<temp)
                    ans++;
            }
            int count = 0;
            for (int i = 1;i<n+1;i++){
//                if (i>2*k) {
                    if(road[i]==0)
                        count++;
                    if(road[i]==1)
                        count = 0;
                    if((count>2*k)||(count>k&&i==n)) {
                        count = 0;
                        ans++;
                    }
//                }
//                else {
//                    if(road[i]==0)
//                        count++;
//                    if(road[i]==1)
//                        count = 0;
//                    if(count>k) {
//                        count = 0;
//                        ans++;
//                    }
//                }
            }
            System.out.println(ans);
        }
        //001001001001
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
//            int count[]=new int[n+5];
//            for(int i=0;i<m;i++){
//                int p=sc.nextInt();
//                count[Math.max(1,p-k)]++;
//                count[Math.min(n+1,p+k+1)]--;
//            }
//            for(int i=1;i<=n+1;i++){
//                count[i]+=count[i-1];
//            }
//            int ans=0,num=0;
//            for(int i=1;i<=n+1;i++){
//                if(count[i]==0&&i<=n){
//                    num++;
//                }
//                else{
//                    if(num>0){
//                        ans+=(num-1)/(k*2+1)+1;
//                    }
//                    num=0;
//                }
//            }
//            System.out.println(ans);
//        }
//    }
    }
}
