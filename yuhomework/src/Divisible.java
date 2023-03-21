public class Divisible {
    public static void main(String[] args) {
        int count=0;
        for (int i = 100;i<201;i++){
            if (i%5==0|i%6==0){
                if (i%5==0&i%6==0)continue;
                else {
                    System.out.print(i+" ");
                    count=count+1;
                    if (count%10== 0) System.out.println();
                }
            }
        }
    }
}
