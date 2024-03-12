package com.liu.algorithm.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu
 */
public class ContainNearbyDulicate001 {

    public boolean containNearbyDuplicate(int[] nums,int k){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k){
                return true;
            }else {
                map.put(nums[i],i);
            }
        }
        return false;
    }

}
