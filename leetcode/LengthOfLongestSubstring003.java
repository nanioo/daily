/*
 * Project: Test
 * 
 * File Created at 2018年7月12日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package leet;

import java.util.HashSet;

/**
 * @Type lengthOfLongestSubstring003.java
 * @Desc t
 * @author Administrator
 * @date 2018年7月12日 下午8:40:30
 * @version 
 */
public class LengthOfLongestSubstring003 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        StringBuffer sub = new StringBuffer();
        int maxLen = 0;
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < s.length(); i++) {
            String val = String.valueOf(s.charAt(i));
            if (!set.contains(val)) {
                set.add(val);
            }
        }
        maxLen = set.size();
        for (int i = 0; i < s.length(); i++) {
            sub = new StringBuffer(String.valueOf(s.charAt(i)));
            for (int j = i + 1; j < s.length(); j++) {
                if (sub.length() == maxLen) {
                    return maxLen;
                }
                if (sub.indexOf(String.valueOf(s.charAt(j))) == -1) {//不包含
                    sub.append(s.charAt(j));
                    continue;
                }

                break;
            }
            //            System.out.println(sub);
            if (sub.length() > result)
                result = sub.length();
            sub = new StringBuffer();
        }
        return result;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring003 sub = new LengthOfLongestSubstring003();
        String test1 = "abcabcbb";
        System.out.println(sub.lengthOfLongestSubstring(test1));
        String test2 = "bbbbbbb";
        System.out.println(sub.lengthOfLongestSubstring(test2));
        String test3 = "pwwkew";
        System.out.println(sub.lengthOfLongestSubstring(test3));
        String test4 = "";
        System.out.println(sub.lengthOfLongestSubstring(test4));
        String test5 = "a";    // 第一次错： 循环后初始化buffer信息时，在第二个循环中未考虑到
        System.out.println(sub.lengthOfLongestSubstring(test5));
        String test6 = "nfpdmpi"; // 第二次错
        System.out.println(sub.lengthOfLongestSubstring(test6));
        String test7 = "nfpdmpiabcdefghijkllllddddd";
        System.out.println(sub.lengthOfLongestSubstring(test7));
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2018年7月12日 Administrator creat
 */
