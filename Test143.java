package banana;

import java.lang.reflect.Method;

class Temp{
	public void print(){
		System.out.println("print");
	}
}

public class Test143{
	public static void main(String[] args) throws Exception{
		Temp t = new Temp();
		t.print();   // print
		
		Class<?> cls = Class.forName("banana.Temp");
		Object obj = cls.newInstance();
		System.out.println(obj);    // banana.Temp@2a139a55
		
		/*
			getMethod가 리턴하는 Method형 변수가 함수포인터인가요 ? ->비슷
			cls에서 지정된 print라는 이름의 함수를 호출할 수 있는 포인터를 제공하는 중.
			
			함수호출(invoke 사용)시 해당 인스턴스에 대한 포인터를 넣어주어야 한다.
			
			void XList_delete_all(void* self){
			}
			C에서의 이거랑 비슷하다.
		*/
		
		Method mtd = cls.getMethod("print");    // print라는 이름의 cls 메소드를 호출할 수 있는 포인터 mtd 제공
		mtd.invoke(obj);    // 아까는 인터페이스(ICar)를 통해 멤버함수를 호출했는데 이건 인터페이스 없이도 호출을 할 수 있다.
	}
}

/*
	javac -d C:\classes Test143.java
	java -classpath C:\classes banana.Test143
*/