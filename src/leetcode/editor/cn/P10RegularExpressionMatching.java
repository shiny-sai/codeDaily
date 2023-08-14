//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
//
// 示例 1： 
//
// 
//输入：s = "aa", p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa", p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab", p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 20 
// s 只包含从 a-z 的小写字母。 
// p 只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
//
// Related Topics 递归 字符串 动态规划 👍 3674 👎 0

package leetcode.editor.cn;
//Java：正则表达式匹配
public class P10RegularExpressionMatching{
    public static void main(String[] args) {
        Solution solution = new P10RegularExpressionMatching().new Solution();
        // TO TEST
        System.out.println(solution.isMatch("aaa", "ab*a*c*a"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {

        int m = s.length(); // m 为s的长度
        int n = p.length(); // n 为p的长度

        boolean dp[][] = new boolean[m+1][n+1];
        // dp[i][j] 表示s的前i个元素 和 p的前j个元素是否匹配
        // boolean 类型默认都是false
        dp[0][0] = true;

        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j){
                if (p.charAt(j-1) != '*') {     // 如果j读取的字符不是'*',则判断下当前单个字符是否匹配
                    if (matchCr(s, p, i, j)) {
                        dp[i][j] = dp[i-1][j-1];
                    }
                } else {
                    dp[i][j] = dp[i][j-2];
                    if (matchCr(s, p, i, j-1))
                        dp[i][j] = dp[i-1][j] | dp[i][j];
                }
            }
        }

        return dp[m][n];

    }

    public boolean matchCr(String s, String p, int i, int j) {
        if (i == 0)
            return false;
        if (p.charAt(j-1) == '.') {
            return true;    //如果p中读取到 '.'，则匹配任意字符，返回true
        }
        return s.charAt(i-1) == p.charAt(j-1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
