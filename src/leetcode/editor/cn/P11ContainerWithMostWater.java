//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 双指针 👍 4473 👎 0

package leetcode.editor.cn;

import java.util.*;


//Java：盛最多水的容器
public class P11ContainerWithMostWater{
    public static void main(String[] args) {
        Solution solution = new P11ContainerWithMostWater().new Solution();
        // TO TEST
        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        int b = solution.maxArea(a);
        System.out.println(b);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        int max_Volume = 0; // 最大容器体积
        int n = height.length;

        for (int i = 0, j = n-1; i < j;) {     // i 指向最左边短板， j指向最右边短板
            max_Volume = Integer.max(max_Volume, (j-i) * Integer.min(height[i],  height[j]));
            if(height[i] <= height[j]) i++;
            else j--;
//            System.out.println("i="+i+",j="+j+",max_Volume="+max_Volume);

            /*
            贪心算法。。。。原来这么简单，我的代码和屎一样
             */

        }


        return max_Volume;

    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
