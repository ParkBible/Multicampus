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
	Q. 100(만원)을 100년간 연 이자율 6.6%로 복리로 굴렸다. 100년 뒤에 총 얼마를 찾을 수 있을까?
	참고 : 복리란, 원금에 이자가 붙은 금액에 이자가 또 붙는거
*/
