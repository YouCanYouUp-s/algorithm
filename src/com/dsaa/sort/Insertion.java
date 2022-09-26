package com.dsaa.sort;

import com.dsaa.sort.util.SortUtils;

import java.util.Arrays;

/**
 * 插入排序
 * @author 18780
 */
public class Insertion {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 8, 3, 4, 7, 5, 12, 0, 9, 3, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(Integer[] arr){
        //移动未排序的起点指针位置   i的右边未排序[i,arr.length-1]  i的左边已排序[0,i-1]
        for (int i = 1; i < arr.length; i++) {
            //已排序的指针 倒序遍历
            for (int j = i; j > 0; j--) {
                //arr[j-1]已排序的最后一个元素 > arr[j]未排序的第一个元素 比较当前未排序的值 是否 比已排序的值更小
                if (arr[j-1].compareTo(arr[j]) > 0) {
                    SortUtils.swap(arr,j-1,j);
                }else{
                    break;
                }
            }
        }
    }

}
