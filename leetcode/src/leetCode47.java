
/*
 * @author  AmbitionJingH
 * @date  2023/10/11 21:31
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

public class leetCode47 {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        dfs(res,nums,visited,new ArrayList<>());
        return res;
    }
    public static void dfs(List<List<Integer>> res,int[] nums,int[] visited,ArrayList<Integer> temp){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i]==0){
                temp.add(nums[i]);
                visited[i]=1;
                dfs(res,nums,visited,temp);
                visited[i]=0;
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }
}
