public class Demo {


    public static void main(String[] args) {
        String[] str = new String[10];
        str[0]="1";
        str[1]="2";
        str[2]="3";
        str[3]="4";
        str[4]="5";
        int b=0;
        while(b<2){
        for(String s:str) {
            if (s == "3") {
                System.out.println("开始执行break");
                continue;
            } else {
                System.out.println(s);
            }
        }
            b=b+1;

           /* for(String t:str){
                if(s=="3"){
                    System.out.println("开始执行break");
                    break;
                }
            }*/
        }
        //System.out.println("for循环执行结束");
    }


}
