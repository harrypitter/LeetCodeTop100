package TOP1_10;

//盛最多水的容器

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */
public class top5 {

    /**
     * 双指针法
     */
    private static int largestSize(int[] num) {
        if (num.length == 0) {
            return 0;
        }

        int res = 0;
        int j = num.length - 1;
        int i = 0;
        while (i < j) {
            int largestSize = (j - i) * Math.min(num[i], num[j]);
            largestSize = Math.max(res, largestSize);
            res = largestSize;

            /*
            如果选择固定一根柱子，另外一根变化，水的面积会有什么变化吗？稍加思考可得：

    当前柱子是最两侧的柱子，水的宽度 ddd 为最大，其他的组合，水的宽度都比这个小。
    左边柱子较短，决定了水的高度为 3。如果移动左边的柱子，新的水面高度不确定，一定不会超过右边的柱子高度 7。
    如果移动右边的柱子，新的水面高度一定不会超过左边的柱子高度 3，也就是不会超过现在的水面高度。
            * */
            if (num[i] < num[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int num[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(largestSize(num));
    }
}
