
/*
 * @author  AmbitionJingH
 * @date  2023/9/6 15:52
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Scanner;

public class leetCode682 {
    public static int calPoints(String[] operations) {
        int score=0;
        //ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]){
                case "+":
                    //score += list.get(list.size()-1) + list.get(list.size()-2);
                    list.add(list.get(list.size()-1)+list.get(list.size()-2));
                    break;
                case "D":
                    //score += 2*list.get(list.size()-1);
                    list.add(list.get(list.size()-1)*2);
                    break;
                case "C":
                    if(list.get(list.size()-1)>0){
                        //score -= list.get(list.size()-1);
                    }else {
                        //score += list.get(list.size()-1);
                    }
                    list.remove(list.size()-1);
                    break;
                default:
                    int temp = Integer.parseInt(operations[i]);
                    //list.add(temp);
                    //score +=temp;
                    list.add(temp);
                    break;
            }
        }
        for(Integer i :list){
            score += i;
        }
        System.out.println(list);
        return score;
    }

    public static void main(String[] args) {
        String[] strings = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(strings));
    }
}
