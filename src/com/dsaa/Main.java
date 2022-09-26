package com.dsaa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,89,5,6,53,1};
        // List<int[]> list = fastWith(nums, 8);
        // for (int[] ints : list) {
        //     System.out.println(Arrays.toString(ints));
        // }

        // System.out.println(dynamic(10));
        // System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 15));
        System.out.println(Arrays.toString(nums));
    }
    //动态规划
    public static int dynamic(int n){
        if (n<0){
            return 0;
        }
        if (n<=1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int res = 0,pre = 1,prePre = 1;
        for (int i = 2; i < n; i++) {
            res = pre + prePre;
            prePre = pre;
            pre = res;
        }
        return res;
    }

    //查询数组中是否有两个数的和等于目标值
    public static List<int[]> fastWith(int[] nums,int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                int[] ints = {map.get(nums[i]), i};
                list.add(ints);
            }else{
                map.put(target-nums[i],i);
            }
        }
        return list;
    }
    //二分查找
    public static int search(int[] nums, int target) {
        int pre = 0,last = nums.length;
        while(pre<last){
            //查询的位置 根据pre last移动指针cur
            int cur = (pre+last) >> 1;
            if(nums[cur]==target){
                return cur;
            }else if(nums[cur] < target){
                pre++;
            }else {
                last--;
            }
        }
        return -1;
    }
}
