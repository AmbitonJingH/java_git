import java.util.ArrayList;

public class perfectNum {
    
    public static boolean checkPerfectNumber(int num) {
        //ArrayList list = new ArrayList();
        if(num==1)
            return false;
        int sum =0;
        for (int i = 2; i < num; i++) {
            if(num%i==0){
                sum+=i;
            }
        }
        System.out.println(sum);
        if(sum+1==num)
            return true;
        else
            return false;
        
    }

    public static void main(String[] args) {
        
        int num = 7;
        System.out.println(checkPerfectNumber(num));
    }
}
