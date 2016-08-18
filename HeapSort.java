package com.test;

import java.util.Arrays;

public class HeapSort {
	/***
	 * ������
	 * @param data ����������
	 */
	public static void heapSort(int[] data){
		//ѭ������
		for(int i = 0; i<data.length-1; i++){
			//����
			buildHeap(data,data.length-1-i);
			//�����Ѷ������һ��Ԫ��
			swap(data,0,data.length-1-i);
			
		}
	}
	/***
	 * �� data ����� 0 �� lastIndex ���󶥶�
	 * @param data ���������� 
	 * @param lastIndex δ������������һ��Ԫ�ص�����
	 */
	public static void buildHeap(int[] data,int lastIndex){
		//�� lastIndex ���ڵ�(���һ���ڵ�) �ĸ��ڵ㿪ʼ
		for(int i = (lastIndex-1)/2; i>=0; i--){
			// k ���浱ǰ�����жϵĽڵ�
			int k = i;
			//��� ��ǰk �ڵ���ӽڵ����
			while(2*k+1 <= lastIndex){
				// k�ڵ�����ӽڵ������
				int biggerIndex = 2*k+1;
				// ���k�ڵ���Һ��Ӵ���
				if(biggerIndex < lastIndex){
					//����Һ��ӽڵ��ֵ�ϴ�
					if(data[biggerIndex]<data[biggerIndex+1]) {
						// biggerIndex���Ǽ�¼�ϴ��ӽڵ������
						biggerIndex++;
					}	
				}
				//��� k �ڵ��ֵС����ϴ��ӽڵ��ֵ
				if(data[k]<data[biggerIndex]){
					//����
					swap(data,k,biggerIndex);
					//��biggerIndex ����k�� ��ʼwhile ѭ������һ��ѭ��
					// ���±�֤ k�ڵ��ֵ�����������ӽڵ��ֵ
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
