package com.test;

import java.util.Arrays;

public class HeapSort {
	/***
	 * 堆排序
	 * @param data 待排序数组
	 */
	public static void heapSort(int[] data){
		//循环建堆
		for(int i = 0; i<data.length-1; i++){
			//建堆
			buildHeap(data,data.length-1-i);
			//交换堆顶和最后一个元素
			swap(data,0,data.length-1-i);
			
		}
	}
	/***
	 * 对 data 数组从 0 到 lastIndex 建大顶堆
	 * @param data 待排序数组 
	 * @param lastIndex 未排序数组的最后一个元素的索引
	 */
	public static void buildHeap(int[] data,int lastIndex){
		//从 lastIndex 处节点(最后一个节点) 的父节点开始
		for(int i = (lastIndex-1)/2; i>=0; i--){
			// k 保存当前正在判断的节点
			int k = i;
			//如果 当前k 节点的子节点存在
			while(2*k+1 <= lastIndex){
				// k节点的左孩子节点的索引
				int biggerIndex = 2*k+1;
				// 如果k节点的右孩子存在
				if(biggerIndex < lastIndex){
					//如果右孩子节点的值较大
					if(data[biggerIndex]<data[biggerIndex+1]) {
						// biggerIndex总是记录较大子节点的索引
						biggerIndex++;
					}	
				}
				//如果 k 节点的值小于其较大子节点的值
				if(data[k]<data[biggerIndex]){
					//交换
					swap(data,k,biggerIndex);
					//将biggerIndex 赋给k， 开始while 循环的下一次循环
					// 重新保证 k节点的值大于其左，右子节点的值
					k = biggerIndex;
				}
				else break;
			}
		}
	}
	
	public static void swap(int[] data, int i, int j){
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		
	}
	
	public static void main(String[] args) {
		int[] data = {1,9,5,3,6,2,8,7,4};
		heapSort(data);
		//System.out.println(Arrays.toString(data));
	}

}
