
class Temp{
	int data = 0;
	Temp(int i){
		data = i;
	}
	
	public boolean equals(Object b){    // t2가 호출할 수 있는거 보니까 오버라이딩이다.
		if(b == null || (b instanceof Temp) == false){
			return false;    // b가 널값이거나 Temp로 캐스팅을 할 수 없다면 무조건 빠꾸하는 이런 코드를 넣는게 바람직하다.
		}
		System.out.println(this.toString());  // this를 찍어보니, 무슨 이유에선지 Temp@어쩌구가 나온다. this는 Temp를 가리키고 있단 뜻.
		Temp t = (Temp)b;		// Temp로 캐스팅시킨다.
		if(this.data == t.data){    // b.data를 하면 오류뜸. Object에는 data가 없으므로
			return true;
		}else{
			return false;
		}    // equals()는 오버라이딩되었으므로 equals()는 무조건 이 함수가 나온다.
	}
}

public class Test098{
	public static void main(String[] args){
		Temp t = new Temp(100);
		Temp l = new Temp(100);    // 같은 내용을 가지고 있더라도 인스턴스는 별개이다.
		System.out.println(t == l);    // false
		System.out.println(t.data == l.data);    // 내용을 비교한다. 근데 좀 덜 객체지향적이다.
		
		Object t2 = new Temp(200);
		Object l2 = new Temp(200);
		System.out.println(t2 == l2);
		// 에러 : System.out.println(t2.data == l2.data);
		//System.out.println(t2.data);    // t2는 Object형인데 data는 Temp에만 있는 변수이기 때문에 쓸수없다.
		
		// 내용비교하려면?
		boolean b = t2.equals(l2);    // equals는 Object에 선언되어 있는 함수여야 한다.
		System.out.println(b);
		
	}
}

/*
	멤버변수 인스턴스 생성자 멤버변수초기값
	포인터의 비교는 같은 대상을 가리킬때 true가 나온다
*/