//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 双指针 排序 👍 1577 👎 0

package leetcode.editor.cn;

import com.sun.javafx.runtime.async.AbstractRemoteResource;

import java.util.Arrays;

//Java：最接近的三数之和
public class P16ThreeSumClosest{
    public static void main(String[] args) {
        Solution solution = new P16ThreeSumClosest().new Solution();
        // TO TEST
        int[] nums = new int[]{-100,-98,-2,-1};
        System.out.println(solution.threeSumClosest(nums, -101));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best = 1000000;
        for (int i = 0; i < nums.length-1; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target)
                    return sum;
                if (sum > target){
                    k--;
                    while(nums[k] == nums[k+1] && j < k)
                        k--;
                }
                if (sum < target){
                    j++;
                    while (nums[j] == nums[j-1] && j < k)
                        j++;
                }
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best =sum;
                }
            }
        }
        return best;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}