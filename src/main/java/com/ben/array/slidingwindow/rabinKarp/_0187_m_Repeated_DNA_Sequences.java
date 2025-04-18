package com.ben.array.slidingwindow.rabinKarp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0187_m_Repeated_DNA_Sequences {
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> res = new ArrayList<>();
            if (s.length() < 10) {
                return res;
            }

            Set<String> set = new HashSet<>();
            Set<String> resSet = new HashSet<>();

            for (int i = 0; i < s.length() - 9; i++) {
                String tmp = s.substring(i, i + 10);
                //Has repeat, add to res
                if (!set.add(tmp)) {
                    //res also need to remove duplication
                    resSet.add(tmp);
                }
            }

            res.addAll(resSet);

            return res;
        }
    }
}
