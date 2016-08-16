package sort;

import java.util.Arrays;

public class InsertSort {
	
	/***
	 * ֱ�Ӳ�������
	 * @param data �����������
	 */
	public static void insertSort(int[] data){
		
		for(int i = 1; i<data.length; i++){
			//��� i����ǰ���Ԫ�ر� i��������Ԫ�ش�����Ҫ��ǰ����
			if(data[i-1] > data[i]){
				//�������������ʱ����֤data[i]����Ԫ�ز���ʧ
				int temp = data[i];
				//�����ƶ��ٸ�Ԫ��
				int j = i-1;
				//ѭ���жϣ�ֻҪǰ���Ԫ�ر�data[i]������Ҫ����
				for(; j>=0 && data[j]>temp; j--){
					data[j+1] = data[j];
				}
				//���data[i]���뵽���ʵ�λ��
				data[j+1] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] data = {9,-16,21,23,-30,-49,21,30};
		System.out.println("Shell����֮ǰ��");
		System.out.println(Arrays.toString(data));
		insertSort(data);
		System.out.println("Shell����֮��");
		System.out.println(Arrays.toString(data));

	}

}
