package TOP11_20;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class TOP11 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 删除 deque 中对应的 nums[i-1]
            if (i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();
            // 保持 deque 递减
            while (!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
            // 记录窗口最大值
            if (i >= 0)
                res[i] = deque.peekFirst();
        }
        return res;
    }

    // 暴利解法
    private static int[] maxSliding(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        List<Integer> numsList = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());

        if (nums.length <= k) {
            int[] res = new int[1];
            res[0] = numsList.get(numsList.size() - 1);
            return res;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = getMaxInt(queue);
        System.out.println(res.toString());

        for (int i = 1; i <= nums.length - k; i++) {
            queue.add(nums[i + k - 1]);
            ((LinkedList<Integer>) queue).removeFirst();
            res[i] = getMaxInt(queue);
        }
        return res;

    }

    private static int getMaxInt(Queue<Integer> ints) {
        if (ints.size() == 0) {
            return 0;
        }
        List<Integer> array = new ArrayList<>(ints);
        array = array.stream().sorted().collect(Collectors.toList());
        return array.get(array.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = maxSliding(nums, 3);
        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
    }

}
