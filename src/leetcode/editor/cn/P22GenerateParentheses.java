//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3596 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class P22GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST

        System.out.println(solution.generateParenthesis(3));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        traceback(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    /**
     * 回溯
     * @param res 结果集
     * @param cur 当前括号字符串
     * @param open 左括号数量
     * @param close 右括号数量
     * @param max 左/右括号最大数量
     */
    public void traceback(List<String> res, StringBuilder cur, int open, int close, int max) {
//        System.out.println("调用回溯\n");
        // 回溯第一步：1、设置终止条件
        if (open == max && open == close) {
            res.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append('(');
//            System.out.println("添加（\n");
            traceback(res, cur, open+1, close, max);
            cur.deleteCharAt(cur.length()-1);
//            System.out.println("回溯删除\n");
        }

        if (close < open) {
            cur.append(')');
//            System.out.println("添加)\n");
            traceback(res, cur, open, close+1, max);
            cur.deleteCharAt(cur.length()-1);
//            System.out.println("回溯删除\n");
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}