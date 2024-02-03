/**
给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 

 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 

 

 示例 1： 

 
输入：nums = [3,2,3]
输出：3 

 示例 2： 

 
输入：nums = [2,2,1,1,1,2,2]
输出：2
 

 
提示：

 
 n == nums.length 
 1 <= n <= 5 * 10⁴ 
 -10⁹ <= nums[i] <= 10⁹ 
 

 

 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 

 Related Topics 数组 哈希表 分治 计数 排序 👍 2119 👎 0

*/
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：多数元素
public class P169MajorityElement{
    public static void main(String[] args) {
        Solution solution = new P169MajorityElement().new Solution();
        // TO TEST
        int[] nums = new int[]{3,3,2,2,1,1,1,2,2};

        int res = solution.majorityElement(nums);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int max = 0;
        int result = 0;
        for (int e:map.keySet()) {
            if (map.get(e) > max) {
                max = map.get(e);
                result = e;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}