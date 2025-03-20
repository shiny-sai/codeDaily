package test;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: 曹赛
 * Date: 2025/3/19
 * Description:腾讯面试手撕代码
 */
public class test1 {

    public static void main(String[] args) {
        int num = 776833902;
        test1 test = new test1();
        int res = test.total(num);
        System.out.println(res);
    }

    public int total(int num) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
            put(0, 1);
            put(6, 1);
            put(9, 1);
            put(8, 2);
        }};

        int totalSum = 0;
        while (num != 0) {
            int ans = num % 10;
            totalSum += map.getOrDefault(ans, 0);
            num /= 10;
        }
        return totalSum;
    }

}
