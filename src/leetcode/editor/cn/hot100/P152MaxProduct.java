package leetcode.editor.cn.hot100;

/**
 * Author: 曹赛
 * Date: 2025/3/5
 * Description:给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32-位 整数。
 */
public class P152MaxProduct {
    public static void main(String[] args) {
        P152MaxProduct maxProduct = new P152MaxProduct();
        int[] nums = new int[]{2,3,-2,4};
        int res = maxProduct.maxProduct(nums);
        System.out.println(res);
    }

    /**
     * 返回最大子数组乘积（数组中含有正负数及0）
     * @param nums 数组
     * @return 最大子数组乘积
     */
    public int maxProduct(int[] nums) {

        long maxF = nums[0], minF = nums[0];
        long res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            long mx = maxF, mn = minF;
            maxF = Math.max(nums[i] * mx, Math.max(nums[i], mn * nums[i]));
            minF = Math.min(nums[i] * mn, Math.min(nums[i], mx * nums[i]));

            // 因为maxF为long类型，换成int类型32位很可能会溢出，所以做个校验
            if (maxF < -Integer.MAX_VALUE) {
                maxF = nums[i];
            }

            res = Math.max(maxF, res);
        }

        return (int) res;
    }
}
