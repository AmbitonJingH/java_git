package number;

public class Demo01 {

    public static void main(String[] args) {
        /*boolean a = false;
        Boolean b = true;
        Byte c = 0x20;
        if(a){
            System.out.println("进来了");
        }else {
            System.out.println("没有进来");
        }*/

                System.out.println("90 度的正弦值：" + Math.sin(Math.PI/2));
                System.out.println("0度的余弦值：" + Math.cos(0));
                System.out.println("60度的正切值：" + Math.tan(Math.PI/3));
                System.out.println("1的反正切值： " + Math.atan(1));
                System.out.println("π/2的角度值：" + Math.toDegrees(Math.PI/2));
                System.out.println(Math.PI);
                int a = 12;
                int b = 20;
        System.out.println(Math.max(a,b));
        System.out.println(Math.log10(100));
        Integer c = 10;
        System.out.println(c.compareTo(10));
        System.out.println(c.compareTo(100));
        System.out.println(c.compareTo(1));
        System.out.println(c.equals(10));
        float e = 1.25f;
        float f = 1.12f;
        float g = e-f;
        if(Math.abs(g)<0.135){
            System.out.println("计算有效");
        }else {
            System.out.println("计算无效");
        }
        //floor向下取整
        //round四舍五入！！！！-1.5round是-1 坑！！！！！！
        //ceil向上取整
    }



}
