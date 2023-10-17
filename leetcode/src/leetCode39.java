
/*
 * @author  AmbitionJingH
 * @date  2023/10/14 10:48
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

public class leetCode39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans,candidates,target,0,new ArrayList<>());
        return ans;
    }
    public static void dfs(List<List<Integer>> ans,int[] candidates,int target,int start,List<Integer> temp){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if(target-candidates[i]<0)
                break;
            temp.add(candidates[i]);
            dfs(ans,candidates,target-candidates[i],i,temp);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,6,7};
        List<List<Integer>> lists = combinationSum(arr, 7);
        System.out.println(lists);
    }
}
