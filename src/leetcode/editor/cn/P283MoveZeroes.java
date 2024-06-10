//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics 数组 双指针 👍 2386 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：移动零
public class P283MoveZeroes{
    public static void main(String[] args) {
        Solution solution = new P283MoveZeroes().new Solution();
        // TO TEST
        int[] nums = new int[]{0};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 官方题解
         * @param nums 数组
         */
        public void moveZeroes(int[] nums) {
            int n = nums.length, left = 0, right = 0;
            while (right < n) {
                if (nums[right] != 0) {
                    swap(nums, left, right);
                    left++;
                }
                right++;
            }
        }

        public void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        /*
        // 我的题解
        public void moveZeroes(int[] nums) {

        // 循环遍历
        for (int i = 0; i < nums.length-1; i++) {
            int j = i;
            int k = j+1;
            if (nums[j] != 0)
                continue;
            while (k < nums.length) {
                if (nums[k] != 0) {
                    // 如果0后续存在不为0的数字，则交换位置。
                    nums[j] = nums[k];
                    nums[k] = 0;
                    j = k;
                    k = j+1;
                } else {
                    k++;
                }

            }
        }
    }
         */
}
//leetcode submit region end(Prohibit modification and deletion)

}