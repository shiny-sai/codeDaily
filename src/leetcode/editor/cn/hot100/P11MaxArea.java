package leetcode.editor.cn.hot100;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 */
public class P11MaxArea {

    public static void main(String[] args) {
        P11MaxArea ma = new P11MaxArea();
        int[] nums = new int[]{1,1};
        int res = ma.maxArea(nums);
        System.out.println(res);
    }

    /**
     * 从数组height中选择两个下标，使 min(height[i], height[j]) * |j - i|, 返回最大的矩形面积
     * @param height height有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i])
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = 0;
            if (height[left] <= height[right]) {
                area = height[left] * (right - left);
                left++;
            } else {
                area = height[right] * (right - left);
                right--;
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
