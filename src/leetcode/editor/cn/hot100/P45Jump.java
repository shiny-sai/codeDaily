package leetcode.editor.cn.hot100;

/**
 * Author: 曹赛
 * Date: 2025/3/3
 * Description:给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 */
public class P45Jump {
    public static void main(String[] args) {
        P45Jump jump = new P45Jump();
        int[] nums = new int[]{2,3,1,1,4};
        int res = jump.jump(nums);
        System.out.println(res);
    }

    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int step = 0;
        int maxPosition = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                step++;
                end = maxPosition;
            }
        }
        return step;
    }
}
