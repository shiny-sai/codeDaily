package leetcode.editor.cn.test.binarysearch;

import java.util.Arrays;

/**
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 */
public class P350InterSection {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,3};
        int[] nums2 = new int[]{2,2,2,4};
        P350InterSection is = new P350InterSection();
        int[] res = is.intersect(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
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
                nums[index++] = num1;
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
