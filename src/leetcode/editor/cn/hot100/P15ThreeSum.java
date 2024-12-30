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
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> res = ts.threeSum(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }

    /**
     * （哈希表：时间超出限制）返回三数之和为0的三元组，不能重复，且i j k不相同
     * @param nums 数组
     * @return List
     */
    public List<List<Integer>> threeSum(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<List<Integer>> lists = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                if (map.containsKey(-sum)) {
                    int count = map.get(-sum);
                    if (nums[i] == -sum) {
                        count--;
                    }
                    if (nums[j] == -sum) {
                        count--;
                    }
                    if (count >= 1) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(-sum);
                        Collections.sort(list);
                        if (!lists.contains(list)) {
                            lists.add(list);
                        }
                    }
                }
            }
        }
        return lists;
    }
}
