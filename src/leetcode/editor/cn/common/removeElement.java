package leetcode.editor.cn.common;

import java.util.Arrays;

/**
 * Author: caosai
 * Title: 利用双指针删除目标元素并返回数组长度
 */
public class removeElement {

    //Test
    public static void main(String[] args) {
        removeElement re = new removeElement();
        int len = re.removeElm(new int[]{1,2,3,3,4}, 3);
        System.out.println(len);
    }

    /**
     * 移除数组中目标元素val，并返回最终数组长度
     * @param nums 数组
     * @param val 目标值
     * @return 数组长度
     */
    public int removeElm(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
                // 这里上一步运行完，slowIndex比fastIndex先加一
            }
        }
        return slowIndex;
    }

}
