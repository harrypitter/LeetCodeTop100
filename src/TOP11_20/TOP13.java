package TOP11_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class TOP13 {

    public static int[][] merge(int[][] intervals) {
        // 先按照左边界大小排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        // 排序之后 只有前一个的右边界小于后一个的左边界才合并，合并之后的新的数组的左边界是原来的左边界，右边界是原来数组和被合并数组右边界中大的一个值
        for (int[] interval : intervals) {
            if (result.size()==0||interval[0] > result.get(result.size()-1)[1]) {
                result.add(interval);
            } else {
                result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][2]);

    }

    public static void main(String[] args) {
        int[][] a = {{1,3},{8,10},{2,6},{15,18}};
        int[][] result = merge(a);
        System.out.println(merge(a).toString());

    }
}
