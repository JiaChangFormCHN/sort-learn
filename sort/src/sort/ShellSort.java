package sort;

import java.util.Arrays;

public class ShellSort {
	
	/**
	 * Shell(希尔)排序
	 * @param data 待排序数组
	 */
	public static void shellSort(int[] data){
		//先求增量
		int h = 1;
		//按 3*h+1 得到最大的增量
		while(h <= data.length/3){
			h = 3*h+1;
		}
		while(h > 0){
			for(int i = h; i<data.length; i++){
				//i索引处的值已经比前面的所有值都大，表明已经有序，无序插入
				//(i-h 索引之前的数据已经有序，i-h索引处的元素的值就是最大值)
				if(data[i-h] > data[i]){
					//当数据整体后移时，保证data[i]处的元素不丢失
					int temp = data[i];
					//最多后移多少个元素
					int j = i-h;
					//循环判断，只要前面的元素比data[i]大，则需要后移,注意这里是j-=h而不是j--
					for(;j>=0 && data[j] > temp; j-=h){
						data[j+h] = data[j];
					}
					//最后将temp插入到合适的位置
					data[j+h] = temp;
				}
			}
			//依据增量公式，计算下一个增量
			h = (h-1)/3;
		}
	}
	
	public static void main(String[] args) {
		int[] data = {9,-16,21,23,-30,-49,21,30};
		System.out.println("排序之前：");
		System.out.println(Arrays.toString(data));
		shellSort(data);
		System.out.println("排序之后：");
		System.out.println(Arrays.toString(data));

	}

}
