package TOP1_10;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class Top10 {
    //采用最左前缀法 一个hash表中存入前面数据之和，遍历数据只要hash表中存在当前数据和t - k 那么就有哈希表中对应个数的连续数组和为K

    private  static int getCount(int[] nums,int k){
        Map<Integer,Integer> preSumMap = new HashMap<>();

        int presum = 0 ;
        int count = 0;
        preSumMap.put(0,1);
        for(int num:nums){
            presum = presum + num;
            if(preSumMap.containsKey(presum-k)){
                count = count +preSumMap.get(presum-k);
            }

            preSumMap.put(presum,preSumMap.getOrDefault(presum,0)+1);
        }
        return count ;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,1,2,3,5,4};
        System.out.println(getCount(nums,6));
    }
}
