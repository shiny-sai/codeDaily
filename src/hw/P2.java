package hw;

import java.util.*;

/**
 * Author: 曹赛
 * Date: 2025/2/21
 * Description:
 */
public class P2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String[] strs = in.nextLine().split(" ");
            Map<String, Boolean> map = new HashMap<>();
            for (String str : strs) {
                map.put(str, true);
            }

            boolean flag = false;
            List<String> list = new ArrayList<>();
            for (String s : map.keySet()) {
                int i = 0;
                for (i = s.length() - 1; i >= 1; i--) {
                    if (!map.containsKey(s.substring(0, i))) {
                        flag = false;
                        break;
                    } else {
                        flag = true;
                    }
                }

                if (i == 0 && flag) {
                    if (list.isEmpty() || s.length() == list.get(0).length()) {
                        list.add(s);
                    } else if (s.length() > list.get(0).length()) {
                        list.clear();
                        list.add(s);
                    }
                }
            }

            Collections.sort(list);
            if (list.isEmpty()) {
                System.out.println("");;
            }else {
                System.out.println(list.get(list.size() - 1));
            }
        }
    }
}
