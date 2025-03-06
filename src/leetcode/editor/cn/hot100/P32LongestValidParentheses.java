package leetcode.editor.cn.hot100;

/**
 * Author: 曹赛
 * Date: 2025/3/6
 * Description:给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class P32LongestValidParentheses {

    public static void main(String[] args) {
        P32LongestValidParentheses longestValidParentheses = new P32LongestValidParentheses();
        String s = "())";
        int res = longestValidParentheses.longestValidParentheses(s);
        System.out.println(res);
    }

    public int longestValidParentheses(String s) {

        if (s.isEmpty()) {
            return 0;
        }
        // 以i结尾的最长有效子串长度
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int maxLength = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                dp[i] = 0;
            } else if (c == ')') {
                char front = s.charAt(i-1);
                if (front == '(') {
                    dp[i] = (i > 2 ? dp[i-2] : 0) + 2;
                } else if (i - dp[i-1] > 0 && s.charAt(i - dp[i-1] - 1) == '(') {   // i - dp[i-1] > 0 保证&& 后面不会溢出
                    // dp[i - dp[i-1] - 2] 可能会造成outOfIndex
                    dp[i] = dp[i-1] + ((i - dp[i-1] > 2) ? dp[i - dp[i-1] - 2] : 0)+ 2;
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
