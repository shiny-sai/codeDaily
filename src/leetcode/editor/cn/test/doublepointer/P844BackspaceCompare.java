package leetcode.editor.cn.test.doublepointer;

/**
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 */
public class P844BackspaceCompare {

    // Test
    public static void main(String[] args) {
        P844BackspaceCompare bc = new P844BackspaceCompare();
        String s1 = "a##c";
        String s2 = "#a#c";
        System.out.println("s1:" + s1);
        System.out.println("s2:" + s2);
        boolean res = bc.backspaceCompare(s1, s2);
        System.out.println(res);
    }

    /**
     * 比较处理后的字符串是否相等
     * @param s1 字符串1
     * @param s2 字符串2
     * @return 处理后是否相等 true / false
     */
    public boolean backspaceCompare(String s1, String s2) {
        return processStr(s1).equals(processStr(s2));
    }

    /**
     * 当字符串中包含#号时，删除#左边元素和#
     * @param str 原始字符串
     * @return 处理后字符串
     */
    public String processStr(String str) {
        int slowIndex = 0;
        char[] ch = str.toCharArray();
        for (int fastIndex = 0; fastIndex < str.length(); fastIndex++) {
            if (ch[fastIndex] != '#') {
                ch[slowIndex++] = ch[fastIndex];
            } else {
                if (slowIndex > 0) {
                    // 用例不通过 s1:a##c s2:#a#c。当连续##时，slowIndex为负数了
                    slowIndex--;
                }
            }
        }
        return new String(ch).substring(0,slowIndex);
    }
}
