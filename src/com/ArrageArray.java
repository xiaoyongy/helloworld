package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ArrageArray {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return nums[nums.length/2];
    }

    public int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else {
                int values = map.get(nums[i]);
                map.put(nums[i], ++values);
            }
        }
        int n = nums.length/2;
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        while(iterator.hasNext()){
            int key = iterator.next();
            int value = map.get(key);
            if (value>n) {
                return key;
            }
        }
        return 0;

    }

    public int majorityElement3(int[] nums) {
        int elem = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++)  {
            if(count == 0)  {
                elem = nums[i];
                count = 1;
            }
            else    {
                if(elem == nums[i])
                    count++;
                else
                    count--;
            }

        }
        return elem;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,2,3,3,3,5,8,6,3};
        int result = new ArrageArray().majorityElement2(nums);
        System.out.println(result);
    }
}
