
/*
 * @author  AmbitionJingH
 * @date  2023/9/19 18:47
 * @version 1.0
 */

public class leetCode34 {
    public static int[] searchRange(int[] nums, int target) {
        int l=0,r = nums.length-1;
        int m = l + (r-l)/2;
        if(nums==null|nums.length==0)
            return new int[]{-1,-1};
        boolean find = false;
        while (l<=r){
            m = l + (r-l)/2;
            if(nums[m]<target)
                l = m + 1;
            else if (nums[m]>target)
                r = m - 1;
            else {
                find = true;
                break;
            }
        }
        if(!find)
            return new int[]{-1,-1};
        l = m;
        r= m;
        while (l-1>=0&&nums[l]==nums[l-1])
            l--;
        while (r+1<=nums.length-1&&nums[r]==nums[r+1])
            r--;
        return new int[]{l,r};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2};
        int t = 2;
        int[] ints = searchRange(nums, t);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
