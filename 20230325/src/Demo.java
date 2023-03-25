public class Demo {


    public static void main(String[] args) {
        //demoClass(9);
        //shangPing(10);
        demoClass2(88);
    }

    public static void demoClass(int size) {
        Student[] arr = new Student[size];
        for (int i = 0; i < size; i++) {
            Student student = new Student();
            student.setAge(20);
            student.setSex("男");
            student.setName("jhj0"+(i+1));
            student.setSchool("西安工程大学");
            //System.out.println(student.toString());
            arr[i] = student;
        }
        for (Student student:arr) {
            System.out.println(student.toString());
        }
    }

    public static void shangPing(int size){
        Shangping[] arr = new Shangping[size];
        for (int i = 0;i<size;i++){
            Shangping shangping = new Shangping();
            shangping.setName("商品"+i);
            shangping.setYuanjia(399+i);
            shangping.setZhekoujia(199+10*i);
            shangping.setXioaliang(1555-9*i);
            shangping.setCaizhi("羊毛");
            shangping.setKuanshi("男款");
            shangping.setSize("M");
            arr[i] = shangping;
        }
        System.out.println(arr[2]);
        System.out.println(arr[4]);
        for (Shangping shangping:arr){
            System.out.println(shangping.toString());
        }
    }
    //垃圾算法
    public static void demoClass1(int num){
        int[] arr = {1,2,3,4,5,6,7,8};
        int count = 0;
        for (int i =0;i<arr.length;i++){
            count = count+1;
            if (arr[i]==num){
                System.out.println("该数据位于第"+(i+1)+"位");
                System.out.println("共执行了"+count+"次");
                break;
            }
        }


    }
    //二分查找
    public static void demoClass2(int num){
        int[] arr = {11,22,33,44,55,66,77,88};
        int count = 0;
        int len = arr.length;
        int flag = len/2;
        boolean open = true;
        while(open){
            count = count + 1;
            if (arr[flag]==num){
                System.out.println("该数据位于第"+(flag+1)+"位");
                System.out.println("共执行了"+count+"次");
                break;
            }
            if (arr[flag] > num) {
                flag = (flag-1)/2;
            }else {
                flag = (flag + flag/2)+1;
            }
        }
    }

    //二分查找
    public static  void  demoClass3(int num){
        int[] arr = {11,22,33,44,55,66,77,88};

        int len = arr.length;
        int count = 0;
        int flag = len/2;
        boolean open = true;
        while (open){
            count += 1;
            if(arr[flag]==num){
                System.out.println("该数据位于第"+(flag+1)+"位");
                System.out.println("共执行了"+count+"次");
                break;
            }

            if(arr[flag]>num){
                flag = flag-1;
            }else{
                flag = flag+1;
            }
        }
    }
}
