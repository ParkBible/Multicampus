public class Test019{
	public static void main(String args[]){
		int[] l = {3, 7, 9, 10};
		int sum = 0;
		int max = 0;
		int min = 0;
		for(int i=0; i<l.length; i++){
			sum = sum + l[i];
		}
		System.out.println(sum);
		
		min = l[0];
		for(int i=0; i<l.length; i++){
			if(l[i]>max){
				max = l[i];
			}
			if(l[i]<min){
				min = l[i];
			}
		}
		System.out.println(max);
		System.out.println(min);
	}
}

/*
	Q1. 3,7,9,10�� ����ִ� int �迭�� ����� �� ���� ��� ������ ������ ���ϴ� �ڵ�
	Q2. �ִ밪�� �ּҰ��� ���� ���ϴ� �ڵ�
	
	if(max < l[0]){
		max = l[0]
	}
*/