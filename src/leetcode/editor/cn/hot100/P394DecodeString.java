package leetcode.editor.cn.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Author: 曹赛
 * Date: 2025/2/10
 * Description:给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 */
public class P394DecodeString {
    public static void main(String[] args) {

        String s = "2[ac2[b10[a]]]";
        P394DecodeString decodeString = new P394DecodeString();
        String res = decodeString.decodeString(s);
        System.out.println(res);

    }

    /**
     * 解码字符串
     * @param s 编码的字符串
     * @return 解码后的字符串
     */
    public String decodeString(String s) {

        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<String> stringStack = new ArrayDeque<>();

        String curString = "";
        int curCount = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // 数字可能是多位，比如23 先读取2 后读取3 最后得到的是23
                curCount = curCount * 10 + (c - '0');
            } else if (c == '[') {
                // 遇到[,将[前的数字入栈
                countStack.push(curCount);
                stringStack.push(curString);
                curString = "";
                curCount = 0;
            } else if (c == ']') {
                // 遇到 ] 将前面的字母入栈
                StringBuilder temp = new StringBuilder(stringStack.pop());
                int repeatCount = countStack.pop();

                for (int i = 0; i < repeatCount; i++) {
                    temp.append(curString);
                }
                curString = temp.toString();
            } else {
                curString += c;
            }
        }

        return curString;
    }
}
