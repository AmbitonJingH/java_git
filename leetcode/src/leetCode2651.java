
/*
 * @author  AmbitionJingH
 * @date  2023/9/8 20:29
 * @version 1.0
 */

public class leetCode2651 {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        if(arrivalTime+delayedTime>24)
            return arrivalTime+delayedTime-24;
        else if(arrivalTime+delayedTime==24)
            return 0;
        else
            return arrivalTime+delayedTime;
    }

    public static void main(String[] args) {

    }
}
