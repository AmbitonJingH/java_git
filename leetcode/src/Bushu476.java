import java.util.Arrays;

public class Bushu476 {

    public static int findComplement(int num) {
        int ans = 0;
        String string = Integer.toBinaryString(num);
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='1')
                chars[i]='0';
            else
                chars[i]='1';
        }

        String s = new String(chars);
        ans = Integer.parseInt(s,2);

        return ans;
    }

    public static void main(String[] args) {

        int num=5;
        System.out.println(findComplement(num));
    }
}
