//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字典树 字符串 👍 2863 👎 0

package leetcode.editor.cn;
//Java：最长公共前缀
public class P14LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        // TO TEST
        String[] st = new String[]{"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix(st));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {

        StringBuffer sp = new StringBuffer("");
        int min_len = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            min_len = Integer.min(min_len, strs[i].length());
        }

        int j = 0;
        while(j < min_len) {
            int i;
            for(i = 0; i < strs.length; i++) {
                if (strs[i].charAt(j) != strs[0].charAt(j)) break;
            }
            if (i == strs.length)
                sp.append(strs[0].charAt(j));
            else break;
            j++;
        }
        if (sp.length() == 0) return "";
        else return sp.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
