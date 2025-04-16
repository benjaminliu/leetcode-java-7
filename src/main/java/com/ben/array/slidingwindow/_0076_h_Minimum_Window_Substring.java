package com.ben.array.slidingwindow;

import com.ben.common.PrintUtil;

public class _0076_h_Minimum_Window_Substring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        PrintUtil.printLn(new Solution().minWindow(s, t));
    }

    static
    class Solution {
        public String minWindow(String s, String t) {
            if (t.length() > s.length()) {
                return "";
            }

            int[] map = new int[52];
            for (int i = 0; i < t.length(); i++) {
                map[c2i(t.charAt(i))]++;
            }

            int[] mapTmp = new int[52];
            for (int i = 0, end = t.length() - 1; i < end; i++) {
                mapTmp[c2i(s.charAt(i))]++;
            }

            String min = null;
            int left = 0;
            for (int i = t.length() - 1; i < s.length(); i++) {
                mapTmp[c2i(s.charAt(i))]++;

                if (contains(map, mapTmp)) {
                    //Find the string contains T, now try to find min string
                    while (i - left + 1 >= t.length()) {
                        mapTmp[c2i(s.charAt(left))]--;
                        left++;
                        if (!contains(map, mapTmp)) {
                            String tmp = s.substring(left - 1, i + 1);
                            if (min == null) {
                                min = tmp;
                            } else {
                                if (tmp.length() < min.length()) {
                                    min = tmp;
                                }
                            }
                            break;
                        }
                    }
                }
            }

            return min == null ? "" : min;
        }

        private boolean contains(int[] map, int[] mapTmp) {
            for (int i = 0; i < map.length; i++) {
                if (map[i] > 0) {
                    if (map[i] > mapTmp[i]) {
                        return false;
                    }
                }
            }
            return true;
        }

        private int c2i(char c) {
            if (c > 'Z') {
                return c - 'a' + 26;
            }
            return c - 'A';
        }
    }
}
