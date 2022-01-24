package banana;

import java.lang.reflect.Method;

class Temp{
	public int print(){
		System.out.println("Apple");
		return 100;
	}
}

public class Test149{
	public static void main(String[] args) throws Exception{
		Class<?> cls = Class.forName("banana.Temp");
		Object obj = cls.newInstance();
		System.out.println(Temp.class == cls);    // 똑같다. 포인터만 다름
		System.out.println(obj.getClass() == cls);    // 역시 똑같다.
		
		/*
			100은 오토박싱되어 obj에 대입된다.
			object 타입으로는 언박싱이 안되기 때문에 obj가 가리키는 대상은 Integer로 형변환이 가능하다.
			형변환을 하면 Integer형 참조형 변수가 되고 이는 언박싱 가능하다.
			
			Object obj = 100;
			int r = (Integer)obj;    -- 언박싱되어 .intValue() 호출하여 값 대입.
		*/
		
		// invoke 함수의 리턴타입은 Object. 따라서 언박싱이 안된다.
		Method mtd = cls.getMethod("print");
		int r = mtd.invoke(obj);
		System.out.println(r);
	}
}

/*
	Class<?> cls = ... 의 포인터를 넘겨받는 방법은 3가지가 있다.
	
	1. Class.forName("banana.Temp");
	2. [클래스명].class : 모든 클래스에는 .class라는 Class형의 static 변수가 있다... 라는 추정이 있음.
	3. Object에서 선언된 getClass() 함수를 호출해서 포인터를 넘겨받을 수 있다.
	
	그래서 Class cls 의 정체는? : 선언된 class와 관련된 함수를 모아놓은 것이다.
	Method mtd = cls.getMethod("print");
	cls에서 getMethod를 호출한다.
*/