public class Test016{
	public static void main(String[] args){
		boolean i = true;
		int j = 100;
		
		if(i){
			System.out.println("Apple");
		} 
		else if(j>0){
			System.out.println("kiwi");
		}
		else{
			System.out.println("Banana");
		}
	}
}

/*
	boolean 값은 다른 자료형의 값으로 형변환이 불가능함(자동, 강제 모두)
	if(..)에는 boolean 값만 와야 함.
*/