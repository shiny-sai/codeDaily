package leetcode.editor.cn.test.binarysearch;

import java.util.Arrays;

/**
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 你所设计的解决方案必须只使用常量级的额外空间。
 */
public class P167TwoSum {

    public static void main(String[] args) {
        P167TwoSum ts = new P167TwoSum();
        int[] numbers = new int[]{2,7,11,15};
        int[] res = ts.twoSum(numbers, 9);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 寻找满足两数之和为目标值的两数的下标(与LCR006TwoSum不同在于下标一个为1开始一个为0开始)
     * @param numbers 有序数组
     * @param target 目标值
     * @return 两个数的下标
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left+1, right+1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{1,1};
    }
}
