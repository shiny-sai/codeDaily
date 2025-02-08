package leetcode.editor.cn.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Author: 曹赛
 * Date: 2025/2/6
 * Description:给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class P20IsValid {

    public static void main(String[] args) {
        P20IsValid isValid = new P20IsValid();
        String s = "{()}";
        boolean res = isValid.isValid(s);
        System.out.println(res);
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else if (stack.isEmpty() || !isMatch(stack.pop(), c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isMatch(char l, char r) {
        return (l == '[' && r == ']') || (l == '(' && r == ')') || (l == '{' && r == '}');
    }

}
