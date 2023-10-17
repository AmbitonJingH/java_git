
/*
 * @author  AmbitionJingH
 * @date  2023/10/15 10:40
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

public class leetCode100084 {
    public static void shortestBeautifulSubstring(String s, int k) {
        List<String> list = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int min=999999,flag=0;
        boolean a = true;
        if(k==1&&s.contains("1"))
            //return "1";
        for (int i = 0; i < s.length() ; i++) {
            for (int j = i+1; j < s.length()+1 ; j++) {
                list.add(s.substring(i, j));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            String temp = list.get(i);
            for (int j = 0; j <temp.length(); j++) {
                if(temp.charAt(j)=='1')
                    count++;
                if(count==k) {
                    ans.add(temp);
                    break;
                }
            }
        }

        if(ans.size()==0){
            //return "";
        }
        String res = "";
        for (int i = 0; i < ans.size(); i++) {
            int first = 0,second = 0;
            System.out.println(ans.get(i).length());
            if(ans.get(i).length()<min) {
                min = ans.get(i).length();
                flag = i;
                res = ans.get(i);
            }
            else if(ans.get(i).length()==min){
                String temp = ans.get(i);
                for (int j = 0; j < min; j++) {
                    if(res.charAt(j)=='0'){
                        first++;
                    }
                }
                for (int j = 0; j < min; j++) {
                    if(ans.get(i).charAt(j)=='0') {
                        second++;
                    }
                }
                System.out.println("first"+first);
                System.out.println("second"+second);
                if(second>first){
                    res = ans.get(i);
                    flag = i;
                }else if(second==first){
                    while (a) {
                        if(temp.indexOf("0")<res.indexOf("0")){
                            res = temp;
                            flag = i;
                            a = false;
                        }else if(temp.indexOf("0")==res.indexOf("0")){
                            temp=temp.substring(temp.indexOf("0")+1);
                            res = res.substring(res.indexOf("0")+1);
                        }else {
                            break;
                        }
                    }
                }
            }
        }
        //return ans.get(flag);
        System.out.println(ans.get(flag));
        //System.out.println(ans);

    }

    public static void main(String[] args) {
        //shortestBeautifulSubstring("001110101101101111",10);
        //shortestBeautifulSubstring("111111110010001010",11);
        //shortestBeautifulSubstring("100011001",3);
        shortestBeautifulSubstring("00101100110010110",6);
        shortestBeautifulSubstring("110101000010110101"
                ,3);
    }
}
