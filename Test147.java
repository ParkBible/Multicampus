
public class Test147{
	public static void main(String[] args){
		int money = 100;
		double sum = 0;
		double sum2 = 0;
		for(int i=100; i>0; i--){
			sum = money;
			for(int j=0; j<i; j++){
				sum = sum + sum * 0.066;
			}
			sum2 = sum2 + sum;
		}
		System.out.println(sum2);
		
	}
}

/*
	100만원을 100년간 매년 6.6%의 복리이자로 운영.
	100년 후에 총 얼마를 받는가?
*/