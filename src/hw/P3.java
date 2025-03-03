package hw;

import java.util.Scanner;

/**
 * Author: 曹赛
 * Date: 2025/2/21
 * Description:
 */
public class P3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            char[] str = s.toCharArray();

            int maxLength = -1;
            int begin = 0;
            int a = 0;
            int b = 0;
            for (int i = 0; i < str.length; i++) {
                if (str[i] != '0') {
                    continue;
                }
                int j = i+1;
                for (; j < str.length; j++) {
                    a = str[j-1] - '0';
                    b = str[j] - '0';
                    if (a == b) {
                        break;
                    }
                }
                if (b == 0 && j - i > 2) {
                    if (j - i > maxLength) {
                        maxLength = j - i;
                        begin = i;
                    }
                }
                i = j - 1;
            }
            if (maxLength == -1) {
                System.out.println("-1");
            } else {
                System.out.println(s.substring(begin, begin + maxLength));
            }

        }
    }

}
