package TOP1_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 题目描述
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class Top2 {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupString = groupAnagrams(strs);

    }

    // 这里可以利用 stream 的 groupingBy 算子实现直接返回结果：
    public static List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    // 返回 str 排序后的结果。
                    // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
                    char[] array = str.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                })).values());
    }


}
