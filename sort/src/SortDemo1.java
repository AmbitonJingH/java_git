import java.util.Arrays;

public class SortDemo1 {

        public static void main(String[] args) {
            int[] arr = {2,1,7,6,5,3,8};
           // bubbleSort(arr);
            //System.out.println(Arrays.toString(arr));
            int[] arr1 = QuickSort(arr,0,arr.length-1);
            System.out.println(Arrays.toString(arr1));
        }

        //冒泡排序
        public static int[] bubbleSort(int[] arr) {
            int len = arr.length;
            if(len<=0){
                return arr;
            }
            else {
                for (int i = 0; i < len; i++) {
                    for (int j = i+1; j < len; j++) {
                        if (arr[i] > arr[j]) {
                            int temp = arr[j];
                            arr[j] = arr[i];
                            arr[i] = temp;
                        }
                    }
                }
            }
            return new int[10];
        }

        /**
         1.选择一个基准值，一般是数列的中间数
         2.将基准左边和右边的序列进行初步排序
         3.继续对分开的序列选中基准进行1,2操作
         **/
        //快排
    //快排
    /**
     * 1.选择一个基准值，一般是数列的中间数
     * 2.将基准值左边的和右边的序列进行初步排序
     * 3.继续对分开的序列中选基准值进行1，2操作
     * */
    public static int[] QuickSort(int[] arr,int low, int high){
        if(arr.length==0||arr==null){
            System.out.println("数组不合法");
            return arr;
        }
        if(low>=high){
            return arr;
        }
        int left = low;
        int right = high;
        int temp = arr[left];
        System.out.println(temp);
        while (left<right){

            while (left<right&&arr[right]>=temp){
                right--;
            }

            arr[left] = arr[right];

            while (left<right&&arr[left]<=temp){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        QuickSort(arr,low,left-1);
        QuickSort(arr,left+1,high);
        return arr;
    }
    }
