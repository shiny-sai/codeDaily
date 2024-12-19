package leetcode.editor.cn.test.binarysearch;

/**
 * 给你一个字符数组 letters，该数组按非递减顺序排序，以及一个字符 target。letters 里至少有两个不同的字符。
 * 返回 letters 中大于 target 的最小的字符。如果不存在这样的字符，则返回 letters 的第一个字符。
 */
public class P744NextGreatestLetter {

    public static void main(String[] args) {
        P744NextGreatestLetter ngl = new P744NextGreatestLetter();
        char[] letters = new char[]{'x', 'x', 'y', 'y'};
        char target = 'z';
        char res = ngl.nextGreatestLetter(letters, target);
        System.out.println(res);
    }

    /**
     * 在letters数组中寻找比target大的最小字母
     * @param letters 数组
     * @param target 目标字母
     * @return 比target大的最小字母
     */
    public char nextGreatestLetter(char[] letters, char target) {

        int left = 0, right = letters.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                // left左边全都是小于等于target的值
                left = mid + 1;
            } else {
                // right及right右边都是大于target的值
                right = mid;
            }
        }
        if (right >= letters.length) {
            return letters[0];
        }
        return letters[right];
    }
}
