package sort;

import java.util.Arrays;

public class ShellSort {
	
	/**
	 * Shell(ϣ��)����
	 * @param data ����������
	 */
	public static void shellSort(int[] data){
		//��������
		int h = 1;
		//�� 3*h+1 �õ���������
		while(h <= data.length/3){
			h = 3*h+1;
		}
		while(h > 0){
			for(int i = h; i<data.length; i++){
				//i��������ֵ�Ѿ���ǰ�������ֵ���󣬱����Ѿ������������
				//(i-h ����֮ǰ�������Ѿ�����i-h��������Ԫ�ص�ֵ�������ֵ)
				if(data[i-h] > data[i]){
					//�������������ʱ����֤data[i]����Ԫ�ز���ʧ
					int temp = data[i];
					//�����ƶ��ٸ�Ԫ��
					int j = i-h;
					//ѭ���жϣ�ֻҪǰ���Ԫ�ر�data[i]������Ҫ����,ע��������j-=h������j--
					for(;j>=0 && data[j] > temp; j-=h){
						data[j+h] = data[j];
					}
					//���temp���뵽���ʵ�λ��
					data[j+h] = temp;
				}
			}
			//����������ʽ��������һ������
			h = (h-1)/3;
		}
	}
	
	public static void main(String[] args) {
		int[] data = {9,-16,21,23,-30,-49,21,30};
		System.out.println("����֮ǰ��");
		System.out.println(Arrays.toString(data));
		shellSort(data);
		System.out.println("����֮��");
		System.out.println(Arrays.toString(data));

	}

}
