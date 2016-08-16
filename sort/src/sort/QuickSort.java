package sort;

import java.util.Arrays;

public class QuickSort {
	
	/***
	 * 对data数组中从start到end索引范围内的子虚列进行排序
	 * 使之满足所有小于分界值的放在左边，所有大于分界值的放在右边
	 * @param data 待排序数组
	 * @param start 开始下标
	 * @param end 结束下标
	 */
	public static <E> void quickSort(int[] data,int start,int end){
		//需要排序
		if(start<end){
			//以第一个元素作为分界值
			int pivot = data[start];
			// i 从左边进行搜索，搜索大于分界值的元素的索引
			int i = start;
			// j 从右边进行搜索，搜索小于分界值的元素的索引
			int j = end+1;
			while(true){
				//找到第一个大于分界值的元素的索引，或者 i 已经到end处
				while(i < end && data[++i] <= pivot);
				//找到第一个小于分界值的元素的索引，或者 j 已经到start处
				while(j > start && data[--j] >= pivot);
				//需要交换
				if(i<j){
					//交换 i j 元素
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
				//不需要交换则结束循环
				else break;
			}
			//交换 j 和 start 处的元素， 此时 j 的在排序中位置已经固定
			int temp = data[start];
			data[start] = data[j];
			data[j] = temp;
			//交换完之后，接着递归 j 的左边子序列
			quickSort(data,start,j-1);
			//递归 j 的右边的子序列
			quickSort(data,j+1,end);
		}
	} 
	
	public static void main(String[] args) {
		
		int[] data = {9,-16,21,23,-30,-49,21,30};
		System.out.println("排序之前：");
		System.out.println(Arrays.toString(data));
		quickSort(data,0,data.length-1);
		System.out.println("排序之后：");
		System.out.println(Arrays.toString(data));
	}

}
