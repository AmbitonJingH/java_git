public class zuida485 {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int sum = 0;
        for (int i =0;i<nums.length;i++) {
            if(nums[i]==1) {
                count++;
               // System.out.println(count);
            }
            if(nums[i]==0||(i==(nums.length-1))) {
             //   sum = count;
                if(count>sum)
                sum = count;
                count = 0;
            }

        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
