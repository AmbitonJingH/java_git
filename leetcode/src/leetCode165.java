
/*
 * @author  AmbitionJingH
 * @date  2023/10/4 22:27
 * @version 1.0
 */

public class leetCode165 {
    public static int compareVersion(String version1, String version2) {
        String[] strings1 = version1.split("\\.");
        String[] strings2 = version2.split("\\.");
        int i=0,j=0,n = strings1.length,m = strings2.length;
        while (i<n||j<m){
            int a =0,b=0;
            if(i<n)
                a = Integer.parseInt(strings1[i++]);
            if(j<m)
                b = Integer.parseInt(strings2[j++]);
            if(a!=b)
                return a>b?1:-1;
        }
        return 0;
    }

    public static void main(String[] args) {
        String version1 = "1.0";
        String version2 = "1.0.1";
        compareVersion(version1,version2);
    }
}
