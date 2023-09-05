public class leetcode551 {
    public static boolean checkRecord(String s) {
//        int count = 0;
//        int count1 = 0;
//        for (int i = 0; i < s.length()-1; i++) {
//            if(s.charAt(i)=='A')
//                count++;
//            if(count>2)
//                return false;
//            if(s.charAt(i)=='L'||s.charAt(i+1)=='L')
//                count1++;
//            if(s.charAt(i)=='L'&&s.charAt(i+1)!='L')
//                count1 = 0;
//            if(count1>=3)
//                return false;
//        }
//        return true;
//        System.out.println(s.indexOf("A"));
        return s.indexOf("A")==s.lastIndexOf("A")&&!s.contains("LLL");
    }

    public static void main(String[] args) {
        String s = "PPALLL";
        boolean a = checkRecord(s);
        System.out.println(a);
    }
}
