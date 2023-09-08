package TOP1_10;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案
 */
public class TopOneTwoSum {

    public static void main(String[] args) {

        int[] nums = {3, 2, 4};
        int target = 5;
        int[] result = twoSumHashTable(nums, target);
        int[] result2 = twoSum(nums, target);
        int[] result3 = twoSumHashTable2(nums, target);
        System.out.println(result);
        System.out.println(result2.toString());

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static int[] twoSumHashTable(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static int[] twoSumHashTable2(int[] nums, int target) {
        Map<Integer, Integer> intIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            intIndexMap.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {
            if (intIndexMap.containsKey(target - nums[j])) {
                return new int[]{j, intIndexMap.get(target - nums[j])};
            }
        }
        return new int[0];
    }


}
