import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode118 {

    public static List<List<Integer>> generate(int numRows) {
        List list = new ArrayList();
        int[][] a = new int[numRows][];
        for(int i=0;i<numRows;i++) {
            a[i] = new int[i+1];
            for (int j = 0; j <=i; j++) {
                if(j==0||j==i)
                    a[i][j] = 1;
                else
                    a[i][j] = a[i-1][j-1]+a[i-1][j];
            }
            list.add(a[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int num = 10;
        List list = generate(num);
        for (int i = 0; i < list.size(); i++) {
            int[] a = (int[]) list.get(i);
            System.out.println(Arrays.toString(a));
        }
    }

}
