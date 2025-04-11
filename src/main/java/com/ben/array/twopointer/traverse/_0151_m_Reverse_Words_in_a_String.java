package com.ben.array.twopointer.traverse;

import com.ben.common.PrintUtil;

public class _0151_m_Reverse_Words_in_a_String {

    public static void main(String[] args) {
        String s = "the sky is blue";
        PrintUtil.printLn(new Solution().reverseWords(s));
    }

    static
    class Solution {

        private char space = ' ';

        public String reverseWords(String s) {
            int idx = s.length() - 1;

            //Find first non-space position, backward
            for (; idx >= 0; idx--) {
                if (s.charAt(idx) != space) {
                    break;
                }
            }


            StringBuilder sb = new StringBuilder();
            for (; idx >= 0; idx--) {
                if (s.charAt(idx) != space) {
                    sb.append(s.charAt(idx));
                } else {
                    //Do not add space if previous char is a space
                    if (s.charAt(idx + 1) != space) {
                        sb.append(s.charAt(idx));
                    }
                }
            }

            //Remove the last space
            if (sb.charAt(sb.length() - 1) == space) {
                sb.setLength(sb.length() - 1);
            }

            char[] chars = sb.toString().toCharArray();

            int start = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == space) {
                    reverse(chars, start, i - 1);
                    start = i + 1;
                }
            }

            reverse(chars, start, chars.length - 1);

            return new String(chars);
        }

        private void reverse(char[] chars, int start, int end) {
            while (start < end) {
                char tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;
                start++;
                end--;
            }
        }
    }
}
