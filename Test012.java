public class Test012{
	public static void main(String[] args){
		int money = 100;
		int years = 100;
		double rate = 0.066; //6.6%
		
		double b = money;
		
		for(int i=0; i<years; i++){
			b = b + (b * rate);
		}
		
		System.out.print(b);
	}
}
/*
	Q. 100(����)�� 100�Ⱓ �� ������ 6.6%�� ������ ���ȴ�. 100�� �ڿ� �� �󸶸� ã�� �� ������?
	���� : ������, ���ݿ� ���ڰ� ���� �ݾ׿� ���ڰ� �� �ٴ°�
*/
