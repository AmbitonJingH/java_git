public class Atoi {

    public static int myAtoi(String s) {
       // char[] chars = s.toCharArray();
        String ans ="";
        boolean first = false;
        for (int i = 0; i < s.length(); i++) {
            if(first == false) {
                if (s.charAt(i) == 45 && (s.charAt(i + 1) >= 48 && s.charAt(i + 1) <= 57))
                    first = true;
            }
            if(s.charAt(i)>=48&&s.charAt(i)<=57){
                ans += s.charAt(i);
            }

        }
        int n = Integer.parseInt(ans);
        if(first)
            return -n;
        else
            return n;
    }

    public static void main(String[] args) {
        String s = "words and 987";
        System.out.println(myAtoi(s));
    }
}
