package newcoder;

import java.util.*;

/**
 * Author: 曹赛
 * Date: 2025/2/20
 * Description:
 */
public class P2playPuke {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] strs = in.nextLine().split(" ");
            int i = 0;
            int[] pokers = new int[strs.length];
            int[] exists = new int[15];
            for (String str : strs) {
                pokers[i++] = stringToDigit(str);
                exists[pokers[i-1]]++;
            }

            List<List<Integer>> straights = new ArrayList<>();

            while (true) {
                boolean flag = false;

                for (int j = 3; j < 15; j++) {
                    int start = j, end = j;
                    while (end < 15 && exists[end] >=1) {
                        end++;
                    }
                    int len = end - start;
                    if (len >= 5) {
                        List<Integer> list = new ArrayList<>();
                        for (int k = start; k < end; k++) {
                            exists[k]--;
                            list.add(k);
                        }
                        straights.add(list);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
            }

            if(straights.isEmpty()){
                System.out.println("NO");
            } else {
                System.out.println(straights.size());
                for (List<Integer> straight : straights) {
                    for (i = 0; i < straight.size() - 1; i++) {
                        System.out.print(digitToString(straight.get(i)) + " ");
                    }
                    System.out.println(digitToString(straight.get(straight.size() - 1)));
                }
            }
        }
    }

    public static String digitToString(int n) {
        if(n >= 3 && n <= 10) return String.valueOf(n);
        switch(n) {
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            case 14: return "A";
            default: return "";
        }
    }

    public static int stringToDigit(String s) {
        switch(s) {
            case "J": return 11;
            case "Q": return 12;
            case "K": return 13;
            case "A": return 14;
            default: return Integer.parseInt(s);
        }
    }
}
