package TOP11_20;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 */
public class Top14 {
    public static int[] rotate(int[] nums, int k) {
        int length = nums.length;

        if (length == 0 || k == 0) {
            return nums;
        }
        int t = 0;
        if (k < length) {
            t = k;
        }
        if (k >= length) {
            t = k % length;
        }
        if (t == 0) {
            return nums;
        }
        int[] b = new int[t];
        int[] c = new int[length - t];
        for (int i = 0; i < t; i++) {
            b[t - i - 1] = nums[length - 1 - i];
        }
        for (int i = 0; i < length - t; i++) {
            c[i] = nums[i];
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(Arrays.stream(b).boxed().collect(Collectors.toList()));
        result.addAll(Arrays.stream(c).boxed().collect(Collectors.toList()));
        int[] ress = result.stream().mapToInt(Integer::valueOf).toArray();
        for (int i = 0; i < length; i++) {
            nums[i] = ress[i];
        }

        return ress;
    }

    //用新的数组
    private static void rotate2(int[] nums, int k) {
        int length = nums.length;
        k = k % nums.length;
        int[] newArray = new int[length];
        if (length == 0 || k == 0) {
            return;
        }
        for (int i = 0; i < length; i++) {
            newArray[(i + k) % length] = nums[i];
        }
        System.arraycopy(newArray, 0, nums, 0, length);
    }

    //翻转 这个想法有点牛
    public static void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] res = rotate(nums, 3);
        System.out.println(res);
    }
}
