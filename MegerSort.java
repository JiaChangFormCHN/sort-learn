package com.test;

import java.util.Arrays;

public class MegerSort {

	/***
	 * �������� left �� right ��Χ�ڵ�����Ԫ�ؽ��й鲢����
	 * @param data �����������
	 * @param left �������������ߵ�һ��Ԫ��
	 * @param right ��������������һ��Ԫ��
	 */
	public static void megerSort(int[] data,int left,int right){
		//��Ҫ����
		if(left<right){
			//�����м�����
			int center = (left+right)/2;
			//�����������еݹ�
			megerSort(data,left,center);
			//���ұ�������еݹ�
			megerSort(data,center+1,right);
			//�ϲ�
			meger(data,left,center,right);
		}
	}
	
	/***
	 * ������������кϲ����鲢ǰ��������ֱ��Ѿ����򣬹鲢����Ȼ����
	 * @param data �������
	 * @param left �������ĵ�һ��Ԫ�ص�����
	 * @param center �����������һ��Ԫ�ص�������center+1 ���ұ�����ĵ�һ��Ԫ�ص�����
	 * @param right �ұ���������һ��Ԫ�ص�����
	 */
	public static void meger(int[] data,int left,int center,int right){
		//����һ������������г�����ͬ����ʱ����
		int[] tempArray = new int[data.length];
		//�ұ�����ĵ�һ��Ԫ������
		int mid = center+1;
		// third��¼��ʱ���������
		int third = left;
		int temp = left;
		
		while(left <= center && mid <= right){
			//����������������ȡ��С�ķ�����ʱ������
			if(data[left]<data[mid]){
				tempArray[third++] = data[left++];
			}
			else {
				tempArray[third++] = data[mid++];
			}
		}
		//��ʣ�ಿ�����η�����ʱ����
		while(left <= center){
			tempArray[third++] = data[left++];
		}
		while(mid <= right){
			tempArray[third++] = data[mid++];
		}
		//����ʱ�����е����ݸ��ƻ�ԭ����
		// (ԭ left �� right ��Χ�����ݸ��ƻ�ԭ����)
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
