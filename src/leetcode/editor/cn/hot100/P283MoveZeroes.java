package leetcode.editor.cn.hot100;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class P283MoveZeroes {

    public static void main(String[] args) {

        P283MoveZeroes mz = new P283MoveZeroes();
        int[] nums = new int[]{0,1,0,3,12};
        mz.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));  // 1,3,12,0,0
    }

    /**
     * 将所有0移动到数组末尾，非零保持原本相对顺序移动到前面
     * @param nums 数组
     */
    public void moveZeroes(int[] nums) {
        int slowIndex = 0, fastIndex = 0, n = nums.length;
        while (fastIndex < n) {
            if (nums[fastIndex] != 0) {
                swap(nums, slowIndex, fastIndex);
                slowIndex++;
            }
            fastIndex++;
        }
    }


    /**
     * 交换数组中的下标为i和下标为j的元素
     * @param nums 数组
     * @param i 下标1
     * @param j 下标2
     */
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
