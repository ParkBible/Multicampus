
interface ITemp <X> {
	public X getData();
}

class Temp implements ITemp<String>{
	public String getData() {return "HelloWorld";}   // 오버라이딩
}

class Temp2 implements ITemp<Integer>{
	public Integer getData() {return 100;}
}


public class Test117{
	public static void main(String[] args){
		ITemp<String> it = new Temp();
		String l = it.getData();
		System.out.println(l);
		
		ITemp<Integer> it2 = new Temp2();
		Integer i = it2.getData();
		System.out.println(i);
	}
}

/*
	인터페이스에 제너릭을 활용한 예
*/