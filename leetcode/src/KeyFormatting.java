public class KeyFormatting {

    public static String licenseKeyFormatting(String s, int k) {
//方法1
//        String news = "";
//        int temp = 0;
//        s = s.replaceAll("-","");
//        System.out.println(s);
//            for (int i = s.length()-1; i >=0; i--) {
//
//                    news = s.charAt(i) + news;
//                    temp++;
//                    if (i != 0 && temp % k == 0)
//                        news = "-" + news;
//
//            }
//        return news.toUpperCase();

//方法2
        StringBuilder a = new StringBuilder();
        int temp = 0;
        s = s.replaceAll("-","");
        for(int i =s.length()-1;i>=0;i--){

                if(temp!=0&&temp%k==0)
                    a.append('-');
                a.append(Character.toUpperCase(s.charAt(i)));
                temp++;

        }
        return a.reverse().toString();
    }

    public static void main(String[] args) {

        String s ="5F3Z-2e-9-w";
        int k =4;
        System.out.println(licenseKeyFormatting(s, k));
    }
}
