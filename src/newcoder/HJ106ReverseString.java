package newcoder;

import java.util.Scanner;
import java.util.Stack;

/**
 * Author: 曹赛
 * Date: 2025/2/19
 * Description:
 */
public class HJ106ReverseString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            String[] params = str.split(" ");
            int length = params.length;
            for (int i = length - 1; i > 0; i--) {
                System.out.print(reverse(params[i]) + " ");
            }
            System.out.println(reverse(params[0]));
        }
    }

    public static String reverse(String s) {
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
