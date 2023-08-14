//罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。 
//
// 
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + 
//II 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给你一个整数，将其转为罗马数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 3
//输出: "III" 
//
// 示例 2: 
//
// 
//输入: num = 4
//输出: "IV" 
//
// 示例 3: 
//
// 
//输入: num = 9
//输出: "IX" 
//
// 示例 4: 
//
// 
//输入: num = 58
//输出: "LVIII"
//解释: L = 50, V = 5, III = 3.
// 
//
// 示例 5: 
//
// 
//输入: num = 1994
//输出: "MCMXCIV"
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 3999 
// 
//
// Related Topics 哈希表 数学 字符串 👍 1156 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：整数转罗马数字
public class P12IntegerToRoman{
    public static void main(String[] args) {
        Solution solution = new P12IntegerToRoman().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String intToRoman(int num) {

        StringBuilder result = new StringBuilder();
        Map<Integer, String> luoma = new HashMap<Integer, String>(){{
            put(1, "I");
            put(4, "IV");
            put(5, "V");
            put(9, "IX");
            put(10, "X");
            put(40, "XL");
            put(50, "L");
            put(90, "XC");
            put(100, "C");
            put(400, "CD");
            put(500, "D");
            put(900, "CM");
            put(1000, "M");
        }};
//          自己的解法 执行耗时:6 ms,击败了16.51% 的Java用户
//	内存消耗:42.4 MB,击败了18.00% 的Java用户
//
//        while(num > 0){
//            // if - else 分支结构可以优化 直接遍历哈希表 循环和key值比较 大于key值则减去key值 直到小于key值 则遍历下一个key值
//            if(num >= 1000) {
//                num -= 1000;
//                result.append(luoma.get(1000));
//            } else if (num >= 900) {
//                num -= 900;
//                result.append(luoma.get(900));
//            } else if (num >= 500) {
//                num -= 500;
//                result.append(luoma.get(500));
//            } else if (num >= 400) {
//                num -= 400;
//                result.append(luoma.get(400));
//            } else if (num >= 100) {
//                num -= 100;
//                result.append(luoma.get(100));
//            } else if (num >= 90) {
//                num -= 90;
//                result.append(luoma.get(90));
//            } else if (num >= 50) {
//                num -= 50;
//                result.append(luoma.get(50));
//            } else if (num >= 40) {
//                num -= 40;
//                result.append(luoma.get(40));
//            } else if (num >= 10) {
//                num -= 10;
//                result.append(luoma.get(10));
//            } else if (num >= 9) {
//                num -= 9;
//                result.append(luoma.get(9));
//            } else if (num >= 5) {
//                num -= 5;
//                result.append(luoma.get(5));
//            } else if (num >= 4) {
//                num -= 4;
//                result.append(luoma.get(4));
//            } else if (num >= 1) {
//                num -= 1;
//                result.append(luoma.get(1));
//            }
//        }


        // 看解析后，想的方法
        /*
        执行耗时:10 ms,击败了7.31% 的Java用户
	内存消耗:42.7 MB,击败了9.72% 的Java用户
         */
        List<Integer> keys = new ArrayList<>(luoma.keySet());   // 将key值转换成数组
        Collections.sort(keys, Collections.reverseOrder());     // 降序排序

        for (Integer i : keys) {
            while (num >= i){
                num -= i;
                result.append(luoma.get(i));
            }
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
