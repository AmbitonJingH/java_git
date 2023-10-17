
/*
 * @author  AmbitionJingH
 * @date  2023/9/27 18:47
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetCode1333 {
    public static  /*List<Integer>*/void filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        int[][] ans = new int[restaurants.length][];
        List<Integer> ids = new ArrayList<>();
        int t = 0;
        if (veganFriendly == 1) {
            for (int i = 0; i < restaurants.length; i++) {
                if(restaurants[i][2]==1){
                    if(restaurants[i][3]<=maxPrice){
                        if(restaurants[i][4]<=maxDistance)
                            ans[t++] = restaurants[i];
                    }
                }
            }
        }else {
            for (int i = 0; i < restaurants.length; i++) {
                    if(restaurants[i][3]<=maxPrice){
                        if(restaurants[i][4]<=maxDistance)
                            ans[t++] = restaurants[i];
                    }
            }
        }
        int[] temp = new int[5];
        for (int i = 0; i < ans.length; i++) {
            for (int j = i; j < ans.length; j++) {
                if (ans[i]!=null && ans[j]!=null) {
                    if(ans[i][1]>ans[j][1]){
                        temp = ans[i];
                        ans[i] = ans[j];
                        ans[j] = temp;
                    }else if(ans[i][1]==ans[j][1]){
                        if(ans[i][0]>ans[j][0]){
                            temp = ans[i];
                            ans[i] = ans[j];
                            ans[j] = temp;
                        }
                    }
                }
            }
        }
        for (int i = ans.length-1; i >=0 ; i--) {
            if(ans[i]!=null){
                ids.add(ans[i][0]);
            }
        }
        System.out.println(ids);
//        for (int i = 0; i < ans.length; i++) {
//            System.out.println(Arrays.toString(ans[i]));
//        }
    }

    public static void main(String[] args) {
        int[][] restaurants = new int[][]{{1,4,1,40,10}, {2,8,0,50,5}, {3,8,1,30,4}, {4,10,0,10,3}, {5,1,1,15,1}};
        filterRestaurants(restaurants,0,30,3);
    }
}
