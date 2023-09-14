package TOP1_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 */

public class Top9 {

    private static List<Integer> getSomeString(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        int slength = s.length();
        int plength = p.length();

        int[] pArray = new int[32];
        int[] sArray = new int[32];
        //子串都是小写字母 只有32个 通过一个int[32]数组记录子串中每个字符的出现次数记录
        for (int i = 0; i < p.length(); i++) {
            pArray[p.charAt(i) - 'a']++;
            sArray[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pArray, sArray)) {
            result.add(0);
        }

        for (int j = plength; j < slength; j++) {
            sArray[s.charAt(j) - 'a']++;        //移动窗口 新的字符加入数组 前面的移除数组，每次移动一格
            sArray[s.charAt(j - plength) - 'a']--;
            if (Arrays.equals(pArray, sArray)) {
                result.add(j-plength+1);    // 记录的是左边的位置
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getSomeString("cbaebabacd","abc"));
    }
}
