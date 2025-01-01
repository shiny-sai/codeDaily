package leetcode.editor.cn.hot100;

import leetcode.editor.cn.test.binarysearch.P153FindMin;

import java.util.*;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 答案中不可以包含重复的三元组。
 */
public class P15ThreeSum {

    public static void main(String[] args) {
        P15ThreeSum ts = new P15ThreeSum();
        int[] nums = new int[]{1,2,-2,-1};
        List<List<Integer>> res = ts.threeSum(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }

    /**
     * 返回三数之和为0的三元组，不能重复，且i j k不相同
     * @param nums 数组
     * @return List
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = -nums[i];
            int k = n - 1;
            for (int j = i + 1; j < k; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                while (j < k && nums[j] + nums[k] > target) {
                    k--;
                }
                if (j == k) {
                    break;
                }
                if (nums[j] + nums[k] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    lists.add(list);
                }
            }
        }
        return lists;
    }
}
