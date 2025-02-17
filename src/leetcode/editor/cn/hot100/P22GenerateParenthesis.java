package leetcode.editor.cn.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: 曹赛
 * Date: 2025/2/10
 * Description:数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class P22GenerateParenthesis {
    public static void main(String[] args) {
        int n = 1;
        P22GenerateParenthesis generateParenthesis = new P22GenerateParenthesis();
        List<String> res = generateParenthesis.generateParenthesis(n);
        System.out.println(Arrays.toString(res.toArray()));
    }

    /**
     * 回溯法返回所有可能括号组合
     * @param n 括号对数
     * @return 返回所有有效的括号组合
     */
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        backtrack(n, res, new StringBuilder(), 0, 0);
        return res;
    }

    /**
     * 回溯
     * @param max 括号对数
     * @param res 结果集
     * @param cur  当前字符串
     * @param open 左括号个数
     * @param close 右括号个数
     */
    public void backtrack(int max, List<String> res, StringBuilder cur, int open, int close) {
        if (cur.length() == max * 2) {
            res.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append('(');
            backtrack(max, res, cur, open+1, close);
            cur.deleteCharAt(cur.length()-1);
        }

        if (close < open) {
            cur.append(')');
            backtrack(max, res, cur, open, close+1);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
