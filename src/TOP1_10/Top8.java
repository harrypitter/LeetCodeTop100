package TOP1_10;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Top8 {

    //采用滑动窗口，用一个hash表记录字符串出现最新位置，当出现重复值时候，左指针移动到原新加入字符串位置的右边一个的位置
    private static int getLargeSizeString(String data) {
        Map<Character, Integer> charMap = new HashMap<>();
        int i = -1;
        int maxSize = 0;
        for (int j = 0; j < data.length(); j++) {
            if (charMap.containsKey(data.charAt(j))) {
                i = charMap.get(data.charAt(j));
            }
            charMap.put(data.charAt(j), j);
            maxSize = Math.max(j - i, maxSize);
        }
        return maxSize;
    }

    public static void main(String[] args) {
        String data = "dasjdkajdsaasg";
        System.out.println(getLargeSizeString(data));
    }
}
