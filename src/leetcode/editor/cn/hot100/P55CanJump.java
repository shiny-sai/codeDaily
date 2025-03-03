package leetcode.editor.cn.hot100;

/**
 * Author: 曹赛
 * Date: 2025/3/1
 * Description:给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
public class P55CanJump {
    public static void main(String[] args) {
        P55CanJump canJump = new P55CanJump();
        int[] nums = new int[]{3,2,1,0,4};
        boolean res = canJump.canJump(nums);
        System.out.println(res);

    }

    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
