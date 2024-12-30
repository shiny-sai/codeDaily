package leetcode.editor.cn.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 *给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class P128LongestConsecutive {

    public static void main(String[] args) {

        int[] nums = new int[]{100,4,200,1,3,2};
        P128LongestConsecutive lc = new P128LongestConsecutive();
        int res = lc.longestConsecutive(nums);
        System.out.println(res);
    }

    /**
     * 找出数组中的最长连续序列长度
     * @param nums 数组
     * @return 最长序列长度
     */
    public int longestConsecutive(int[] nums) {
        // 利用哈希表去重
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int maxLen = 0;
        for (int num : nums) {
            int len = 1;
            if (!map.containsKey(num - 1)) {
                while (map.containsKey(++num)) {
                    len++;
                }
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

}
