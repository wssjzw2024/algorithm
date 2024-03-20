package com.liu.algorithm.classicinterview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liu
 */
public class FindAnagrams005 {
    public List<Integer> findAnagrams(String s,String p){
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }

        int differ = 0;
        for (int j = 0; j < 26; ++j) {
            if (count[j] != 0) {
                ++differ;
            }
        }

        if (differ == 0) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            if (count[s.charAt(i) - 'a'] == 1) {
                --differ;
            } else if (count[s.charAt(i) - 'a'] == 0) {
                ++differ;
            }
            --count[s.charAt(i) - 'a'];

            if (count[s.charAt(i + pLen) - 'a'] == -1) {
                --differ;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {
                ++differ;
            }
            ++count[s.charAt(i + pLen) - 'a'];

            if (differ == 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
