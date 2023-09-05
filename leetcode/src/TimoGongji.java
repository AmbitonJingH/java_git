import java.util.Arrays;

public class TimoGongji {

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum=duration;
        for (int i = 0; i < timeSeries.length-1; i++) {
            if(timeSeries[i]+duration>timeSeries[i+1])
                sum += duration-(timeSeries[i+1]-timeSeries[i]);
            else if(timeSeries[i]+duration<=timeSeries[i+1]){
                sum += duration ;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] time = {1,4};
        int d = 2;
        System.out.println(findPoisonedDuration(time, d));
    }
}

