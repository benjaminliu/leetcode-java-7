package com.ben.array.search;

import java.util.*;

public class _0752_m_Open_the_Lock {
    class Solution {
        public int openLock(String[] deadends, String target) {
            Set<String> deads = new HashSet<>(Arrays.asList(deadends));
            if (deads.contains("0000")) {
                return -1;
            }
            Queue<String> q = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            q.offer("0000");
            visited.add("0000");
            int level = 0;
            while (!q.isEmpty()) {
                int size = q.size();

                while (size > 0) {
                    String s = q.poll();

                    if (s.equals(target)) {
                        return level;
                    }

                    for (int i = 0; i < 4; i++) {
                        char c = s.charAt(i);
                        String start = s.substring(0, i);
                        String end = s.substring(i + 1);
                        String s1 = start + (c == '9' ? 0 : c - '0' + 1) + end;
                        String s2 = start + (c == '0' ? 9 : c - '0' - 1) + end;
                        if (!visited.contains(s1) && !deads.contains(s1)) {
                            q.offer(s1);
                            visited.add(s1);
                        }
                        if (!visited.contains(s2) && !deads.contains(s2)) {
                            q.offer(s2);
                            visited.add(s2);
                        }
                    }
                    size--;
                }

                level++;
            }
            return -1;
        }
    }
}
