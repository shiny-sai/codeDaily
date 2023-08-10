//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 3873 👎 0

package leetcode.editor.cn;

//Java：整数反转
public class P7ReverseInteger{
    public static void main(String[] args) {
        Solution solution = new P7ReverseInteger().new Solution();
        // TO TEST
//        System.out.println(solution.reverse(123));
//        System.out.println(solution.reverse(-123));
//        System.out.println(solution.reverse(0));
//        System.out.println(solution.reverse(-1));
        System.out.println(solution.reverse(1534236469));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        if(x == 0 || (x > ((int)(Math.pow(2,31)-1))) || (x < -(int)(Math.pow(2,31)))) {
            return 0;
        }
        int mid = (x > 0) ? x : (-x);
        int count = 0;
        long result = 0;
        int[] res = new int[10];
        while(mid != 0) {
            res[count] = mid % 10;
            mid /= 10;
            count ++;
        }
        for(int i = count-1; i >= 0; i--) {
            result += res[i]*(Math.pow(10,count-i-1));
            if(result > ((int)(Math.pow(2,31)-1))){
                return 0;
            }

        }
        return (x > 0) ? (int)result : -(int)result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
