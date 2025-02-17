package leetcode.editor.cn.hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: 曹赛
 * Date: 2025/2/10
 * Description:给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */
public class P739DailyTemperatures {

    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] temperatures) {
        int length= temperatures.length;
        int[] res = new int[length];
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return res;
    }
}
