package TOP11_20;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 */
public class Top15 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        int[] res = new int[len];

        L[0] = 1;
        for (int i = 1; i < len - 1; i++) {
            L[i] = L[i - 1] * nums[i];
        }

        R[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            R[len - i - 1] = R[len - i] * nums[len - i];
        }

        for (int i = 0; i < len; i++) {
            res[i] = L[i] * R[i];
        }
        return res;
    }
}
