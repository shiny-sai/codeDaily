//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 1920 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：四数之和
public class P18FourSum{
    public static void main(String[] args) {
        Solution solution = new P18FourSum().new Solution();
        // TO TEST
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(solution.fourSum(nums, -1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>(new ArrayList<>());
        Arrays.sort(nums);
        for (int a = 0; a < nums.length-1; a++) {
            if (a > 0 && nums[a] == nums[a-1])
                continue;
            for (int b = a+1; b < nums.length-1; b++) {
                if (b != a+1 && nums[b] == nums[b-1])
                    continue;
                int j = b+1;
                int k = nums.length-1;
                while(j < k) {
                    // sum需要使用long类型，存在溢出
                    long sum = (long)nums[a]+nums[b]+nums[j]+nums[k];
                    if (sum == target) {
                        List<Integer> res = new ArrayList<>();
                        res.add(nums[a]);
                        res.add(nums[b]);
                        res.add(nums[j]);
                        res.add(nums[k]);
                        if (!result.contains(res))
                            result.add(res);
                        j++;
                    }
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
                }
            }
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}