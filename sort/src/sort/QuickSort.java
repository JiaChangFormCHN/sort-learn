package sort;

import java.util.Arrays;

public class QuickSort {
	
	/***
	 * ��data�����д�start��end������Χ�ڵ������н�������
	 * ʹ֮��������С�ڷֽ�ֵ�ķ�����ߣ����д��ڷֽ�ֵ�ķ����ұ�
	 * @param data ����������
	 * @param start ��ʼ�±�
	 * @param end �����±�
	 */
	public static <E> void quickSort(int[] data,int start,int end){
		//��Ҫ����
		if(start<end){
			//�Ե�һ��Ԫ����Ϊ�ֽ�ֵ
			int pivot = data[start];
			// i ����߽����������������ڷֽ�ֵ��Ԫ�ص�����
			int i = start;
			// j ���ұ߽�������������С�ڷֽ�ֵ��Ԫ�ص�����
			int j = end+1;
			while(true){
				//�ҵ���һ�����ڷֽ�ֵ��Ԫ�ص����������� i �Ѿ���end��
				while(i < end && data[++i] <= pivot);
				//�ҵ���һ��С�ڷֽ�ֵ��Ԫ�ص����������� j �Ѿ���start��
				while(j > start && data[--j] >= pivot);
				//��Ҫ����
				if(i<j){
					//���� i j Ԫ��
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
				//����Ҫ���������ѭ��
				else break;
			}
			//���� j �� start ����Ԫ�أ� ��ʱ j ����������λ���Ѿ��̶�
			int temp = data[start];
			data[start] = data[j];
			data[j] = temp;
			//������֮�󣬽��ŵݹ� j �����������
			quickSort(data,start,j-1);
			//�ݹ� j ���ұߵ�������
			quickSort(data,j+1,end);
		}
	} 
	
	public static void main(String[] args) {
		
		int[] data = {9,-16,21,23,-30,-49,21,30};
		System.out.println("����֮ǰ��");
		System.out.println(Arrays.toString(data));
		quickSort(data,0,data.length-1);
		System.out.println("����֮��");
		System.out.println(Arrays.toString(data));
	}

}
