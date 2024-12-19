package leetcode.editor.cn.test.binarysearch;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 */
public class P134MyPow {

    public static void main(String[] args) {
        P134MyPow mp = new P134MyPow();
        double x = 2.00000;
        int n = 10;
        double res = mp.myPow(x, n);
        System.out.println(res);
    }

    /**
     * 计算x的n次方（递归）
     * @param x 底数
     * @param n 幂
     * @return 结果
     */
    public double myPow(double x, int n) {

        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            if (n % 2 == 0) {
                return myPow(x * x, n / 2);
            } else {
                return x * myPow(x, n - 1);
            }
        } else {
           return 1 / (x * myPow(x, -(n + 1)));
        }
    }
}
