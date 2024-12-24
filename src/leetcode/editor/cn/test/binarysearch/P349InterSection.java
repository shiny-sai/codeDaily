package leetcode.editor.cn.test.binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 */
public class P349InterSection {

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        P349InterSection is = new P349InterSection();
        int[] res = is.intersection(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (nums2[len2 - 1] < nums1[0] || nums1[len1 -1] < nums2[0]) {
            // 交集为空
            return new int[]{};
        }
        // 否则双指针遍历, 新建一个数组存储交集
        int[] nums = new int[len1 + len2];
        int index1 = 0, index2 = 0, index = 0;
        // 分别指向nums1 nums2 nums
        while (index1 < len1 && index2 < len2) {
            int num1 = nums1[index1];
            int num2 = nums2[index2];
            if (num1 == num2) {
                if (index == 0 || nums[index - 1] != num1) {
                    nums[index++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(nums,0, index);
    }
}
