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
	Q1. 3,7,9,10이 들어있는 int 배열을 만들고 그 안의 모든 값들의 총합을 구하는 코드
	Q2. 최대값과 최소값을 각각 구하는 코드
	
	if(max < l[0]){
		max = l[0]
	}
*/