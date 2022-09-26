package com.dsaa.sort;

import com.dsaa.sort.util.SortUtils;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] ints = {1,2,3};
        //int[]转为 Integer[] int是基本类型 无法实现Comparable 所以不能用排序方法compareTo比较 Integer类型实现了Comparable接口
        Integer[] integers = Arrays.stream(ints).boxed().toArray(Integer[]::new);

        sort(integers,0,ints.length-1);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 快速排序
     * @param arr
     * @param start 序列的起点
     * @param end   序列的终止点
     */
    public static void sort(Integer[] arr,int start,int end){
        if (start<0 || end > arr.length-1){
            throw new RuntimeException("参数范围有误");
        }
        //分界值pivot 索引位置是start+(end-start)/2
        int pivot = arr[start+(end-start)/2];
        //左 右指针
        int left = start,right=end;
        //当 left > right时 停止循环
        while (left <= right){
            //从右往左找 找到比pivot小的值 若没有找到 right == (start+(end-start)/2)
            while (arr[right] > pivot){
                right--;
            }
            //从左往右找 找到比pivot大的值 就停下 若没有找到就会停在pivot的位置 left == (start+(end-start)/2)
            while (arr[left] < pivot){
                left++;
            }
            //当left==right时 swap的操作是无意义的 但是left和right的指针移动是有意义的
            if (left <= right){
                SortUtils.swap(arr,left,right);
                //swap之后 继续移动 左 右指针 否则外层while会死循环 (当 left == pivot的索引位置 == right 时)
                left++;
                right--;
            }
        }
        //此时俩指针错开 left > right  [...right,pivot,left...]
        //TODO [start,right]是左子序列的部分 [left,end]是右子序列的部分
        //TODO ！！！递归 必须是一个收拢的过程 否则将出现死循环 导致栈溢出
        //左子序列递归 （跳出左递归条件：左子序列只剩下一个元素 既满足 start >= right）
        //这里为什么用right和start做比较？
        // 因为right指针是向左移动的（向start靠拢） 当右子序列只剩下一个元素时 start == right == end
        if(start < right){
            sort(arr,start,right);
        }

        //右子序列递归 （跳出右递归条件：右子序列只剩下一个元素 既满足 left >= end）
        //这里为什么用left和end做比较？
        //因为left指针是向右移动的（向end靠拢） 当左子序列只剩下一个元素时 start == left == end
        if(left < end){
            sort(arr,left,end);
        }
    }
}
