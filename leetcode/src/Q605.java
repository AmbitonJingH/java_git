import java.util.Arrays;
import java.util.List;

public class Q605 {



        public static boolean canPlaceFlowers(int[] flowerbed, int n) {

            int m = flowerbed.length;

            int count = 0;
            for (int i=0;i<m;i++) {

                if (flowerbed[i] == 0 && (i == m - 1 || flowerbed[i + 1] == 0) && (i == 0 || flowerbed[i - 1] == 0)) {

                    flowerbed[i] = 1;
                    count++;
                }
            }
            return count >= n;
        }


    public static void main(String[] args) {
        int[] f = {1,0,0,0,1,0,0};
        int n = 2;
        System.out.println(canPlaceFlowers(f, n));
    }
}
