package hw;

import java.util.*;

/**
 * Author: 曹赛
 * Date: 2025/2/21
 * Description:
 */
public class P1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());
            String[] strs = new String[n];
            int count  = 0;
            for (int i = 0; i < n; i++) {
                strs[count++] = in.nextLine();
            }

            Map<Long, List<String>> map = new TreeMap<>();

            for (String str : strs) {
                int k = 0;
                int m = 0;
                int g = 0;
                int t = 0;
                long totalCount = 0;
                for (char c : str.toCharArray()) {
                    if (Character.isDigit(c)) {
                        k += k*10 + (c - '0');
                    } else if (c == 'M') {
                        m += k;
                        k = 0;
                    } else if (c == 'G') {
                        g += k;
                        k = 0;
                    } else if (c == 'T') {
                        t += k;
                        k = 0;
                    }
                }
                totalCount = 1*m + 1024*g + 1024*1024*t;
                List<String> list = map.getOrDefault(totalCount, new ArrayList<>());
                list.add(str);
                map.put(totalCount, list);
            }

            List<String> ans = new ArrayList<>();
            for (Long i : map.keySet()) {
                List<String> res = map.get(i);
                for (String re : res) {
                    ans.add(re);
                }
            }
            for (int i = 0; i < ans.size()-1; i++) {
                System.out.println(ans.get(i));
            }
            System.out.print(ans.get(ans.size()-1));
        }
    }

}
