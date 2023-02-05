public class Stringbuilders {

    public static void main(String[] args) {
//        String res = new String("sss");
//        StringBuilder builder = new StringBuilder();
//        builder.append("cxk");
//        System.out.println(builder);
//        builder.append("01");
//        System.out.println(builder);
//        builder.delete(2,3);
//        System.out.println(builder);
//        builder.insert(1,"ntm");
//        System.out.println(builder);
        StringBuffer sBuffer = new StringBuffer("真丝羊毛白色休闲西装外套女高级感小个子春秋新款2022设计感小众");
        System.out.println(sBuffer.length());
        sBuffer.replace(27,33,"...");
        System.out.println(sBuffer);

//        sBuffer.append("www");
//        sBuffer.append(".runoob");
//        sBuffer.append(".com");
//        String str ;
//        System.out.println(sBuffer);
//        userInfo1(sBuffer);
//        userInfo2(sBuffer);
    }

    public static void userInfo1(StringBuffer stringBuffer){
        stringBuffer.append("进站");
        System.out.println(stringBuffer);
    }

    public static void userInfo2(StringBuffer stringBuffer){
        stringBuffer.append("出站");
        System.out.println(stringBuffer);
    }
}
