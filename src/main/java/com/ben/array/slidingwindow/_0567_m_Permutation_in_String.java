package com.ben.array.slidingwindow;

import com.ben.common.PrintUtil;

public class _0567_m_Permutation_in_String {

    public static void main(String[] args) {
        String s2 = "eidbaooo";
        String s1 = "ab";

        PrintUtil.printLn(new Solution().checkInclusion(s1, s2));
    }

    static
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return false;
            }

            int[] map = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                map[c2i(s1.charAt(i))]++;
            }

            int[] mapTmp = new int[26];
            for (int i = 0, end = s1.length() - 1; i < end; i++) {
                mapTmp[c2i(s2.charAt(i))]++;
            }

            for (int i = s1.length() - 1; i < s2.length(); i++) {
                mapTmp[c2i(s2.charAt(i))]++;

                if (equals(map, mapTmp)) {
                    return true;
                }

                mapTmp[c2i(s2.charAt(i - s1.length() + 1))]--;
            }

            return false;
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
