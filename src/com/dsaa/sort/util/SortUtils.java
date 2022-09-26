package com.dsaa.sort.util;

/**
 * @author 18780
 */
public class SortUtils {
    /**
     * 比较两个值的大小
     * @param max 较大值
     * @param min 较小值
     * @return if max > min return true
     */
    public static boolean compare(Comparable max, Comparable min) {
        return max.compareTo(min) > 0;
    }

    /**
     * 交换两个位置的元素
     * @param arr
     * @param front 前面的元素索引
     * @param back  后面的元素索引
     */
    public static void swap(Comparable[] arr, int front, int back) {
        Comparable temp;
        temp = arr[front];
        arr[front] = arr[back];
        arr[back] = temp;
    }
}
