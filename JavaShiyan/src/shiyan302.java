public class shiyan302 {
    public static void main(String[] args) {
        double a;
        int time = 1000000,count1=0,count2=0;
        for (int i=0;i<time;i++){
            a = Math.random();
            if (a<0.5)
                count1 += 1;
            else
                count2 += 1;
    }
        System.out.println("正面的次数" + count1);
        System.out.println("反面的次数" + count2);
    }
}
