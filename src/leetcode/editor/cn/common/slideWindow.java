package leetcode.editor.cn.common;

/**
 * 滑动窗口：【长度最小的子数组】给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的子数组
 *  [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0
 */
public class slideWindow {

    // Test
    public static void main(String[] args) {
        slideWindow sw = new slideWindow();
        int[] nums = new int[]{1,1};
        int res  = sw.findShortest(nums, 7);
        System.out.println(res);
    }

    /**
     * 返回数组中最小子数组的长度
     * @param nums 数组
     * @param target 目标和
     * @return 最小子数组长度
     */
    public int findShortest(int[] nums, int target) {
        int slowIndex = 0;
        int sum = 0;    // 当前和
        int result = Integer.MAX_VALUE; // 当前子数组长度
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            sum += nums[fastIndex];
            while (sum >= target) {
                int subLength = (fastIndex - slowIndex) + 1;
                result = Math.min(result, subLength);
                sum -= nums[slowIndex++];
            }
        }
        if (result == Integer.MAX_VALUE) {
            // 用例 [1,1,1,1,1,1], target=11,不通过，补充整个数组和都比目标和小的情况
            return 0;
        }
        return result;
    }


}
