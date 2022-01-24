public class Test014{
	public static void main(String[] args){
		int money = 100;
		int years = 100;
		double rate = 0.066;
		
		double total = money;
		for(int i=0; i<years; i++){
			total = total + (total * rate);
		}
		System.out.println(total);
	}
}

/*
	money = money + money * rate; // int형 변수에 실수를 넣었으므로 에러
	money = (int)(money + money * rate) // 가능하지만 돈이 샘
*/