interface ITemp<X>{
	public X getData();
}

public class Test119{
	public static void main(String[] args){
		int t = 200;    // anonymous class가 사용하는 로컬변수. 근데 과연 이걸 로컬변수라고 할 수 있는가?
		
		/*
		ITemp<Integer> it = new ITemp<Integer>(){
			public Integer getData(){return t;}
		};
		*/
		
		Temp<Integer> it = new ITemp<Integer>(){
			public Integer getData(){
				t = t + 1;
				return t;
			}
		};
		
		int j = it.getData();
		System.out.println(j);
	}
}

/*
	로컬변수를 만일 anonymous class가 사용하고 있다면 해당 인스턴스가 가베지컬렉션 되지 않는 한에서
	로컬변수는 함수 호출이 끝나도 없어지면 안된다.
	
	또한 anonymous 클래스가 사용중인 로컬변수는 값을 변경해서도 안된다.
	
	너무 많이 생각하지 말고 그냥 필요할 때 쓸 수 있을 만큼만 알아놓자!
*/