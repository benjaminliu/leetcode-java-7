package com.ben.array.slidingwindow;

import com.ben.common.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class _0438_Find_All_Anagrams_in_a_String {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        PrintUtil.printList(new Solution().findAnagrams(s, p));
    }

    static
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (s.length() < p.length()) {
                return res;
            }

            int[] map = new int[26];
            for (int i = 0; i < p.length(); i++) {
                map[c2i(p.charAt(i))]++;
            }

            int[] mapTmp = new int[26];
            for (int i = 0, end = p.length() - 1; i < end; i++) {
                mapTmp[c2i(s.charAt(i))]++;
            }

            for (int i = p.length() - 1; i < s.length(); i++) {
                mapTmp[c2i(s.charAt(i))]++;

                int start = i - p.length() + 1;
                if (equals(map, mapTmp)) {
                    res.add(start);
                }
                mapTmp[c2i(s.charAt(start))]--;
            }

            return res;
        }

        private boolean equals(int[] map, int[] mapTmp) {
            for (int i = 0; i < map.length; i++) {
                if (map[i] != mapTmp[i]) {
                    return false;
                }
            }
            return true;
        }

        private int c2i(char c) {
            return c - 'a';
        }
    }
}
