import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface NoPrint {
	public int value() default 0;    // value에 아무것도 안넣어주면 0(지금은 밑에 보면 30이 들어가있다)
	public int abcd() default 0;
}

class Calc{
	
	// value() 함수를 통해서 리턴받을 값을 여기서 지정가능하다.
	@NoPrint(value=30,abcd=100)
	public int add(int i, int j){return (i + j);}
	public int minus(int i, int j){return (i - j);}
}

public class Test155{
	public static void main(String[] args) throws Exception{
		String l = "add";
		Object obj = new Calc();
		
		Class<?> cls = obj.getClass();
		Method mtd = cls.getMethod(l, int.class, int.class);
		int r = (Integer)mtd.invoke(obj, 10, 20);
		
		/*
			Annotation은 모든 어노테이션의 조상클래스.
			리턴타입이 어노테이션으로 되어 있으니까 Noprint로 받으려면 캐스팅해야 한다.
		*/
		//Annotation at = mtd.getAnnotation(NoPrint.class);
		NoPrint at = (NoPrint)mtd.getAnnotation(NoPrint.class);
		System.out.println(at.abcd());    // 100
		if(at == null){
			System.out.println(r);
		}
		else if(at.value() == r){    // NoPrint에서 지정한 value의 값 30과 r이 같으면 출력.
			System.out.println(r);
		}
	}
}

/*
	@NoPrint(30) : 이런 식으로 아무 키 값 없이 값을 지정하려면 value() 함수를 이용해야 한다.
	@NoPrint(abcd=30) : 이런식으로 특정 키값을 지정하여 value 값을 지정하려면 abcd() 함수를 선언해야 한다.
*/