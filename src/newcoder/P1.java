package newcoder;

import java.util.Scanner;

/**
 * Author: 曹赛
 * Date: 2025/2/20
 * Description: 在一条笔直的公路上安装了N个路灯，从位置0开始安装，路灯之间间距固定为100米。
 * 每个路灯都有自己的照明半径，请计算第一个路灯和最后一个路灯之间，无法照明的区间的长度和。
 */
public class P1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt(); // 读取路灯个数
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt(); // 读取每个路灯的照明半径
            }

            // 变量初始化
            int right = 0; // 当前的最远照明范围
            int totalDarkLength = 0;

            for (int i = 0; i < n; i++) {
                int lampPosition = i * 100;
                int lampLeft = lampPosition - nums[i];  // 当前路灯最左能照到的点
                int lampRight = lampPosition + nums[i]; // 当前路灯最右能照到的点

                // 计算黑暗区域
                if (lampLeft > right) {
                    totalDarkLength += lampLeft - right;
                }

                // 更新最远照明范围
                right = Math.max(right, lampRight);
            }

            System.out.println(totalDarkLength);
        }
    }
}
