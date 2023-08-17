//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 6238 👎 0

package leetcode.editor.cn;
import java.util.*;

//Java：三数之和
public class P15ThreeSum{
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        // TO TEST
        int[] nums = new int[]{1,0,-1};
        System.out.println(solution.threeSum(nums).toString());
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>(new ArrayList<>());

        int index = nums.length;  // 记录数组排序后，nums[i] 大于0的第一个下标，从左到右
        // 将nums数组转化为List，纯手动转换
        // 还有其他方法 ： 1、Arrays.asList：List<Integer> list = new ArrayList<>(Arrays.asList(nums));
        // 2、List<Integer> list = Arrays.stream(nums).collect(Collectors.toList());
        List<Integer> num_list = new ArrayList<>();
        Arrays.sort(nums);  // 先给nums排序
        // 筛选出第一个大于0的元素的下标
        for (int i =0; i < nums.length; i++) {
            if (nums[i] > 0) index = Integer.min(index, i); // 第一个大于0的nums元素下标
            num_list.add(nums[i]);
        }

        // 如果数组全为大于0或者全为小于0， 则不满足3个相加等于0，返回空
        if (index == 0 || (index == nums.length && nums[nums.length-1] < 0)) {
            return new ArrayList<>();
        }

        for (int i = 0; i < )

        /*
        for (int i = 0; i < index; i++) {
            for(int j = nums.length-1; j > i;j--) {
                int k = j-1;
                while(k > i) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> res = new ArrayList<Integer>();
                        res.add(nums[i]);
                        res.add(nums[k]);
                        res.add(nums[j]);
                        Collections.sort(res);
                        if (!result.contains(res))
                            result.add(res);
                    }
                    k--;
                }

            }
        }
    */
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
