//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
//
// Related Topics 字符串 👍 2124 👎 0

package leetcode.editor.cn;
//Java：N 字形变换
public class P6ZigzagConversion{
    public static void main(String[] args) {
        Solution solution = new P6ZigzagConversion().new Solution();
        // TO TEST
        String res = solution.convert("ABC", 2);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String convert(String s, int numRows) {
            StringBuffer result = new StringBuffer(""); // 定义result接收最终结果
            char[][] ss = new char[numRows][1000];  // 定义二维数组记录z形字符串
            int len = s.length();   // 获取原始字符串长度
            int i = 0;
            int count = 0;
            int flag =0;
            int j = 0;
            //System.out.println(s.charAt(0));
            while (i < numRows && count < len) {
                if(numRows == 1){
                    return s;
                }
                if(flag == 0) {
                    ss[i++][j] = s.charAt(count);
                    // test
                    //System.out.println("("+(i-1)+","+(j)+") : "+ss[i-1][j]+"----"+ count + "----"+len);
                    count ++;
                    if(i == numRows) {
                        flag = 1;
                        count--;
                        i--;
                    }
                }else if(flag == 1) {
                    ss[i--][j++] = s.charAt(count);
                    // test
                    //System.out.println("("+(i+1)+","+(j-1)+") : "+ss[i+1][j-1]+"----"+ count + "----"+len);
                    count++;
                    if(i < 0) {
                        flag =0;
                        count--;
                        j--;
                        i++;
                    }
                }
            }
            flag = j;

            for (i = 0; i <  numRows; i++) {
                for (j = 0; j <= flag; j++) {
                    if(ss[i][j] != '\0') {
                        result.append(ss[i][j]);
                    }

                }
            }

            return result.toString();

        }
        /*
         public String convert(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }

         */
}
//leetcode submit region end(Prohibit modification and deletion)

}
