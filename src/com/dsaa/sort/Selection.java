package com.dsaa.sort;

import com.dsaa.sort.util.SortUtils;

import java.util.Arrays;

/**
 * 选择排序
 */
public class Selection {
    public static void main(String[] args) {
        Integer[] integers = {8, 7, 3, 45, 9, 0, 7, 6};
        sort(integers);
        System.out.println(Arrays.toString(integers));
    }

    public static void sort(Comparable[] arr) {
        //从头开始遍历
        for (int i = 0; i < arr.length; i++) {
            //假设最小索引是第从i位开始 如果后面找到更小的数 则用mini记录下新的最小索引
            int mini = i;
            for (int j = i + 1; j < arr.length; j++) {
                //如果最小索引处的值大于当前遍历位置j的值 交换元素 并且把j赋值给最小索引 mini
                if (SortUtils.compare(arr[mini],arr[j])) {
                    //移动最小索引的指向
                    mini = j;
                }
            }
            //for遍历扫描完整个未排序的序列之后再swap 可能找到了更小的（i<min） 也可能没找到（i==mini）
            SortUtils.swap(arr, i, mini);
        }
    }
}
