
/*
 * @author  AmbitionJingH
 * @date  2023/10/12 21:01
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

public class leetCode17 {
    public static List<String> letterCombinations(String digits) {

        if(digits==null || digits.length()==0) {
            return new ArrayList<String>();
        }

        String[] dig = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int index = digits.charAt(i) - '0';
            String letter = dig[index];
            int size = res.size();
            for (int j = 0; j < size; j++) {
                String first = res.remove(0);
                for (int k = 0; k < letter.length(); k++) {
                    res.add(first+letter.charAt(k));
                }
            }
        }
        return res;


//        if(digits==null || digits.length()==0) {
//            return new ArrayList<String>();
//        }
//        //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
//        //这里也可以用map，用数组可以更节省点内存
//        String[] letter_map = {
//                " ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
//        };
//        List<String> res = new ArrayList<>();
//        //先往队列中加入一个空字符
//        res.add("");
//        for(int i=0;i<digits.length();i++) {
//            //由当前遍历到的字符，取字典表中查找对应的字符串
//            String letters = letter_map[digits.charAt(i)-'0'];
//            int size = res.size();
//            //计算出队列长度后，将队列中的每个元素挨个拿出来
//            for(int j=0;j<size;j++) {
//                //每次都从队列中拿出第一个元素
//                String tmp = res.remove(0);
//                //然后跟"def"这样的字符串拼接，并再次放到队列中
//                for(int k=0;k<letters.length();k++) {
//                    res.add(tmp+letters.charAt(k));
//                }
//            }
//        }
//        return res;

    }
    public static void main(String[] args) {
        String a = "23";
        List<String> list = letterCombinations(a);
        System.out.println(list);
    }
}
