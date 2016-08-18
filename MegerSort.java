package com.test;

import java.util.Arrays;

public class MegerSort {

	/***
	 * 将索引从 left 到 right 范围内的数组元素进行归并排序
	 * @param data 待排序的数组
	 * @param left 待排序数组的左边第一个元素
	 * @param right 待排序数组的最后一个元素
	 */
	public static void megerSort(int[] data,int left,int right){
		//需要排序
		if(left<right){
			//计算中间索引
			int center = (left+right)/2;
			//对左边数组进行递归
			megerSort(data,left,center);
			//对右边数组进行递归
			megerSort(data,center+1,right);
			//合并
			meger(data,left,center,right);
		}
	}
	
	/***
	 * 将两个数组进行合并，归并前两个数组分别已经有序，归并后依然有序
	 * @param data 数组对象
	 * @param left 左边数组的第一个元素的索引
	 * @param center 左边数组的最后一个元素的索引，center+1 是右边数组的第一个元素的索引
	 * @param right 右边数组的最后一个元素的索引
	 */
	public static void meger(int[] data,int left,int center,int right){
		//定义一个与待排序序列长度相同的临时数组
		int[] tempArray = new int[data.length];
		//右边数组的第一个元素索引
		int mid = center+1;
		// third记录临时数组的索引
		int third = left;
		int temp = left;
		
		while(left <= center && mid <= right){
			//从左右两边数组中取出小的放入临时数组中
			if(data[left]<data[mid]){
				tempArray[third++] = data[left++];
			}
			else {
				tempArray[third++] = data[mid++];
			}
		}
		//将剩余部分依次放入临时数组
		while(left <= center){
			tempArray[third++] = data[left++];
		}
		while(mid <= right){
			tempArray[third++] = data[mid++];
		}
		//将临时数组中的内容复制回原数组
		// (原 left 到 right 范围的内容复制回原数组)
		while(temp <= right){
			data[temp] = tempArray[temp++];
		}
	}
	
	public static void main(String[] args) {
		int[] data = {1,9,5,3,6,2,8,7,4};
		megerSort(data,0,data.length-1);
		System.out.println(Arrays.toString(data));
	}

}
