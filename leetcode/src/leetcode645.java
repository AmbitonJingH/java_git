import java.util.HashSet;

public class leetcode645 {
    public static int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int r = 0;
        int l = 0;
        for (int n: nums) {
            if(set.contains(n))
                r = n;
            set.add(n);
        }
        for (int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)){
                l = i;
                break;
            }
        }
        return new int[] {r,l};
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        System.out.println(findErrorNums(nums));
    }
}
