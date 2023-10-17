
/*
 * @author  AmbitionJingH
 * @date  2023/10/8 18:44
 * @version 1.0
 */

public class leetCode11 {
    public static int maxArea(int[] height) {
        int max = 0;
        int i = 0,j = height.length-1;
        while (i<j){
            if(height[i]<height[j])
                max = Math.max(max,(j-i)*height[i++]);
            else
                max = Math.max(max,(j-i)*height[j--]);
        }
        return max;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i+1; j < height.length; j++) {
//                int w = j-i;
//                int h = Math.min(height[i],height[j]);
//                max = Math.max(max,w*h);
//            }
//        }
//        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int i = maxArea(height);
        System.out.println(i);
    }
}
