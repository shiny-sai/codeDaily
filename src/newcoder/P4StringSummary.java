package newcoder;

import java.util.*;

/**
 * Author: 曹赛
 * Date: 2025/2/20
 * Description:
 */
public class P4StringSummary {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            char[] characters = in.nextLine().replaceAll("[^a-zA-Z]", "").toLowerCase().toCharArray();
            Map<Integer, List<String>> map = new TreeMap<>(Comparator.reverseOrder());
            for (int i = 0; i < characters.length; i++) {
                int count = 1;
                char ch = characters[i];

                int j = i + 1;

                // 计算连续字符出现次数
                while (j < characters.length && characters[j] == ch) {
                    count++;
                    j++;
                }

                // 计算非连续字符出现次数
                if (count == 1) {
                    count = discontinuousCount(characters, j, ch);
                }

                List<String> val = map.getOrDefault(count, new ArrayList<>());
                val.add(ch + Integer.toString(count));
                map.put(count, val);

                // 更新i位置
                i = j-1;
            }

            StringBuffer sb = new StringBuffer();
            for (int i : map.keySet()) {
                List<String> list = map.get(i);
                Collections.sort(list);  // 确保相同 count 的字母排序
                for (String s : list) {
                    sb.append(s);
                }
            }
            System.out.println(sb.toString());
        }

    }

    public static int discontinuousCount(char[] characters, int start, char c) {
        int count = 0;
        for (int i = start; i < characters.length; i++) {
            if (characters[i] == c) {
                count++;
            }
        }
        return count;
    }

}
