package TOP1_10;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class Top3 {

    public static void main(String[] args) {
        int[] num = {100,4,200,1,3,2};
        int longgest = getLongestNum(num);
        System.out.println(longgest);
    }

    /**
     * 由于我们要枚举的数 xxx 一定是在数组中不存在前驱数 x−1 的，不然按照上面的分析我们会从 x−1x-1x−1 开始尝试匹配，因此我们每次在哈希表中检查是否存在 x−1x-1x−1 即能判断是否需要跳过了。
     *
     * @param intData
     * @return
     */
    private static int getLongestNum(int[] intData) {
        Set<Integer> intSet = new HashSet();
        for(int i:intData){
            intSet.add(i);
        }

        int longgest = 0;

        for(int j:intSet)
        {
            if(!intSet.contains(j-1)){
                int curentData = j;
                int longgetIndex = 1;

                while (intSet.contains(curentData+1)){
                    longgetIndex++;
                    curentData++;
                }

                longgest = Math.max(longgest,longgetIndex);
            }
        }

        return longgest;
    }
}
