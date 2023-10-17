
/*
 * @author  AmbitionJingH
 * @date  2023/10/17 20:25
 * @version 1.0
 */

public class leetCode299 {
    public static String getHint(String secret, String guess) {
        int a = 0, b = 0;

        int[] arr = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            } else {
                // 小于0说明之前guess中出现过相同的字符
                if (arr[secret.charAt(i) - '0']++ < 0)
                    b++;
                // 大于0说之前secret中出现过相同的字符
                if (arr[guess.charAt(i) - '0']-- > 0)
                    b++;
            }
        }

        // 构造返回值
        return new StringBuilder().append(a).append('A').append(b).append('B').toString();

    }

    public static void main(String[] args) {
        String s = "1123";
        String g = "0111";
        System.out.println(getHint(s, g));
    }
}
