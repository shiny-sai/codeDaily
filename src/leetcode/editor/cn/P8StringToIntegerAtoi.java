//请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。 
//
// 函数 myAtoi(string s) 的算法如下： 
//
// 
// 读入字符串并丢弃无用的前导空格 
// 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。 
// 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。 
// 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 
//2 开始）。 
// 如果整数数超过 32 位有符号整数范围 [−2³¹, 231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2³¹ 的整数应该被固
//定为 −2³¹ ，大于 231 − 1 的整数应该被固定为 231 − 1 。 
// 返回整数作为最终结果。 
// 
//
// 注意： 
//
// 
// 本题中的空白字符只包括空格字符 ' ' 。 
// 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "42"
//输出：42
//解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
//第 1 步："42"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："42"（读入 "42"）
//           ^
//解析得到整数 42 。
//由于 "42" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 42 。 
//
// 示例 2： 
//
// 
//输入：s = "   -42"
//输出：-42
//解释：
//第 1 步："   -42"（读入前导空格，但忽视掉）
//            ^
//第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
//             ^
//第 3 步："   -42"（读入 "42"）
//               ^
//解析得到整数 -42 。
//由于 "-42" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 -42 。
// 
//
// 示例 3： 
//
// 
//输入：s = "4193 with words"
//输出：4193
//解释：
//第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
//             ^
//解析得到整数 4193 。
//由于 "4193" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 4193 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 200 
// s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成 
// 
//
// Related Topics 字符串 👍 1713 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：字符串转换整数 (atoi)
public class P8StringToIntegerAtoi{
    public static void main(String[] args) {
        Solution solution = new P8StringToIntegerAtoi().new Solution();
        // TO TEST
        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("   -42"));
        System.out.println(solution.myAtoi_1("-49383561551254"));
        System.out.println(solution.myAtoi_1("  00000000123456"));
        System.out.println(solution.myAtoi_1("00000-42a1234"));
        System.out.println(solution.myAtoi_1("-0000042a1234"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 解法一(自己的方法)
        public int myAtoi(String s) {
        // 设置正负数标志
        int flag = 0;
        boolean start = false;
        int count = 0;
        int[] result = new int[200];
        for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == ' ') {
                    if(start == false) start = true;
                    else {
                        if(s.charAt(i-1) != ' ') break;
                    }
                } else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                    if(start == false) start = true;
                    if(i >= 1)
                        if(s.charAt(i-1) != ' ') break;
                    flag = (s.charAt(i) == '+') ? 1 : -1;
                } else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    if(start == false) start = true;
                    String stringc = String.valueOf(s.charAt(i));
                    result[count++] = Integer.parseInt(stringc);
                } else {
                    break;
                }
        }
        if(flag == 0){
            flag = 1;
        }
        int j = count-1;
        long res = 0L;    // 接收结果

        for(int i = 0; i < count; i++, j--) {
            res += (long)result[j]*Math.pow(10,i);
            if(res*flag < -(int)Math.pow(2,31))
                return -(int)Math.pow(2,31)-1;
            else if (res*flag > (int)Math.pow(2,31) - 1)
                return (int)Math.pow(2,31);
        }
        return (int)res*flag;
    }

        // 解法二:自动机
        public int myAtoi_1(String s) {
            Automation automation = new Automation();
            int length = s.length();    // 获取s的长度
            for (int i = 0; i < length; i++) {
                automation.get(s.charAt(i));
            }
            return (int) (automation.sign * automation.res);
        }

        /*
        定义一个自动机类
         */
        class Automation {
            public int sign = 1;    // 符号，如果未识别到+ 或 - ，则默认为正+
            public long res = 0L;   // 接收数字并计算结果
            private String state = "start"; // 初始状态，默认为开始
            // 双大括号初始化
            // 使用Map 需要导入 import java.util.HashMap; import java.util.Map;
            private Map<String, String[]> table = new HashMap<String, String[]>() {{
                put("start",new String[]{"start", "signed", "in_number", "end"});
                put("signed",new String[]{"end", "end", "in_number", "end"});
                put("in_number",new String[]{"end", "end", "in_number", "end"});
                put("end",new String[]{"end", "end", "end", "end"});

            }};

            /*
            读取新的字符后，获取当前状态state
             */
            public void get(char c) {
                state = table.get(state)[get_col(c)];   // state 相当于横坐标，get_col 获取纵坐标
                if ("in_number".equals(state)) {
                    res = res * 10 + c - '0';
                    res = (sign == 1) ? Math.min(res, (long) Integer.MAX_VALUE) : Math.min(res, -(long) Integer.MIN_VALUE);

                } else if ("signed".equals(state)) {
                    sign = c == '+' ? 1 : -1;
                }

            }

            /*
            根据读取的字符，筛选出HashMap的纵坐标，后定位state
             */
            public int get_col(char c) {
                if(c == ' ')
                    return 0;
                else if(c == '+' || c == '-')
                    return 1;
                else if(Character.isDigit(c))
                    return 2;
                else
                    return 3;
            }


        }


}
//leetcode submit region end(Prohibit modification and deletion)

}
