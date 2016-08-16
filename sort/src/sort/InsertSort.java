package sort;

import java.util.Arrays;

public class InsertSort {
	
	/***
	 * 直接插入排序
	 * @param data 待排序的数组
	 */
	public static void insertSort(int[] data){
		
		for(int i = 1; i<data.length; i++){
			//如果 i索引前面的元素比 i索引处的元素大，则需要往前插入
			if(data[i-1] > data[i]){
				//当数据整体后移时，保证data[i]处的元素不丢失
				int temp = data[i];
				//最多后移多少个元素
				int j = i-1;
				//循环判断，只要前面的元素比data[i]大，则需要后移
				for(; j>=0 && data[j]>temp; j--){
					data[j+1] = data[j];
				}
				//最后将data[i]插入到合适的位置
				data[j+1] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] data = {9,-16,21,23,-30,-49,21,30};
		System.out.println("Shell排序之前：");
		System.out.println(Arrays.toString(data));
		insertSort(data);
		System.out.println("Shell排序之后：");
		System.out.println(Arrays.toString(data));

	}

}
