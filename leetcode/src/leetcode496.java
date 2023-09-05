import java.util.Arrays;

public class leetcode496 {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int k = 0;
        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    for (int l = j; l <nums2.length ; l++) {
                    if (nums2[l] > nums1[i]) {
                        ans[k] = nums2[l];
                        k++;
                        break;
                    } else if (l == nums2.length - 1) {
                        ans[k] = -1;
                        k++;
                    }
                }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
}
