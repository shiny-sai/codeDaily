package leetcode.editor.cn.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: 曹赛
 * Date: 2025/2/8
 * Description:给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class P78Subsets {

    public static void main(String[] args) {
        P78Subsets subsets = new P78Subsets();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res = subsets.subsets(nums);
        int n = res.size();
        int count = 0;
        System.out.print("[");
        for (List<Integer> re : res) {
            count++;
            if (count < n) {
                System.out.print(re.toString() + ",");
            } else {
                System.out.print(re.toString());
            }
        }
        System.out.println("]");
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        res.add(output);
        backtrack(0, output, res, nums);
        return res;

    }

    public void backtrack(int first, List<Integer> output, List<List<Integer>> res, int[] nums) {
        for (int i = first; i < nums.length; i++) {
            output.add(nums[i]);
            res.add(new ArrayList<>(output));
            backtrack(i+1, output, res, nums);
            output.remove(output.size() - 1);
        }
    }
}
