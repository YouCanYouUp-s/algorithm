package com.dsaa.sort;

import com.dsaa.sort.util.SortUtils;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class Bubble {
    public static void main(String[] args) {
        Integer[] ints = {5, 6, 4, 9, 2, 8, 10};
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void sort(Comparable[] arr) {
        //外层控制有多少个元素参与排序  当最后只剩下一个时 不需要再排序 既i>0
        for (int i = arr.length - 1; i > 0; i--) {
            // j 移动窗口指针 每次比较 j和j+1 索引上的值 范围在[0,i)
            for (int j = 0; j < i; j++) {
                if (SortUtils.compare(arr[j], arr[j + 1])) {
                    SortUtils.swap(arr, j, j + 1);
                }
            }
        }
    }
}
