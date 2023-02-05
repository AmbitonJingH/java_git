public class Demo {

    public static void main(String[] args) {
        String s1 = "AKC";              // String 直接创建
        String s2 = "wasd12345678";              // String 直接创建
        String s3 = "AKC";
        String y = "1234567891@qq.com";
        yanzheng(y);
        System.out.println(s1.charAt(2));    //返回指定索引处的 char 值。char charAt(int index)
        System.out.println(s1.compareTo(s2));    //不相同返回值为非0的数 int compareTo(String anotherString)
        System.out.println(s1.compareTo(s3));    //相同返回值为0
        System.out.println(s1.compareToIgnoreCase(s2));
        System.out.println(s1.compareToIgnoreCase(s3));
        System.out.println(s2.replace("45",s1));//	String replace(char oldChar, char newChar)返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
        String str = "IT男，二次元，学习，op";
        String[] arr = str.split("，");//	String[] split(String regex) 根据给定正则表达式的匹配拆分此字符串。
        for(String s:arr){
            System.out.println(s);
        }
        String s4 = s2.substring(0,5);//	String substring(int beginIndex, int endIndex)  返回一个新字符串，它是此字符串的一个子字符串。
        System.out.println(s4);
        //char[] toCharArray()  将此字符串转换为一个新的字符数组。
        char[] ar = s2.toCharArray();
        for(char c:ar){
            System.out.println(c);
        }
    }

    //用户登录
    public int loginUser(String username,String password){
        String username_succ="jhjwww";
        String password_succ="123456";
        if(username==username_succ&&password==password_succ){
            System.out.println("登陆成功！");
            return 1;
        }else{
            System.out.println("登录失败！！！请检查账号密码！");
            return 0;
        }
    }

    //更改地址
    public static void loAcl(String address,boolean flag){
        String address_a = "xxxxxxx";
        if(flag){
            System.out.println("我的地址"+address);
        }else{
            System.out.println("我的地址"+address_a);
        }

    }
    //验证邮箱
    public static void yanzheng(String mail){
        char[] ar = mail.toCharArray();
        boolean check = false;
        for(char c:ar){
            if(c=='@'){
                System.out.println("合法邮箱");
                check = true;
            }
        }
        if(!check){
            System.out.println("非法邮箱");
        }
    }
}


