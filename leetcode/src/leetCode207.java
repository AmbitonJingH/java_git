
/*
 * @author  AmbitionJingH
 * @date  2023/9/9 9:46
 * @version 1.0
 */

import java.util.Arrays;

public class leetCode207 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] courses = new int[numCourses];
//        if(prerequisites.length==numCourses)
//            return false;
        for (int i = 0; i < prerequisites.length; i++) {
            courses[prerequisites[i][0]]++;
            courses[prerequisites[i][1]]++;
        }
        System.out.println(Arrays.toString(courses));
        return true;
    }

    public static void main(String[] args) {
        //canFinish(5,new int[][]{{1,4},{2,4},{3,1},{3,2}});
        canFinish(2,new int[][]{{0,1},{1,0}});
    }
}
