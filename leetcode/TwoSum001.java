/*
 * Project: Dtest
 * 
 * File Created at 2018年7月5日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.cmcc.hy.bdbvs.utils;

import java.util.Arrays;

/**
 * @Type TwoSum001.java
 * @Desc 
 * @author Administrator
 * @date 2018年7月5日 下午8:27:43
 * @version 
 */
public class TwoSum001 {
    public int[] test(int[] nums, int target) {
        if (nums == null)
            return null;
        int length = nums.length;
        int[] source = new int[length];
        source = Arrays.copyOf(nums, length);
        int[] record = new int[2];
        int[] result = new int[2];
        Arrays.sort(nums);

        int sum = 0;
        boolean flag = true; // note the sum < target
        for (int i = 0; i < length; i++) {
            if (!flag)
                break;
            sum = nums[i];
            if (sum < target || target < 0) {
                for (int j = i + 1; j < length; j++) {
                    sum = nums[i] + nums[j];
                    if (sum < target)
                        continue;
                    else if (sum == target) {
                        record[0] = nums[i];
                        record[1] = nums[j];
                        flag = false;
                        break;
                    } else
                        break;
                }
            }
        }
        for (int m = 0; m < length; m++) {
            if (source[m] == record[0] && result[0] == 0)
                result[0] = m;
            else if (source[m] == record[1])
                result[1] = m;
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum001 ts = new TwoSum001();
        int[][] nums = { { -3, 2, -4, 1, -4, 10, 0 }, { 12, 4, 6, 9 }, { 4, 5, 6, 3, -4 },
                { -1, -11, -4 } };
        int[] target = { -8, 10, 0, -5 };
        for (int index = 0; index < nums.length; index++) {
            int[] result = ts.test(nums[index], target[index]);
            System.out.println(result[0] + "," + result[1]);
        }
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2018年7月5日 Administrator creat
 */
