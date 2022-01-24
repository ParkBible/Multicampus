import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@interface NoPrint {}

class Calc{
	@NoPrint
	public int add(int i, int j){return (i + j);}
	public int minus(int i, int j){return (i - j);}
}

public class Test154{
	public static void main(String[] args) throws Exception{
		String l = "add";
		Object obj = new Calc();    // newInstance로 해도 되긴한다.
		Class<?> cls = obj.getClass();
		Method mtd = cls.getMethod(l, int.class, int.class);
		int r = (Integer)mtd.invoke(obj, 10, 20);
		
		Annotation at = mtd.getAnnotation(NoPrint.class);
		if(at != null){
			
		}
		else{
			System.out.println(r);
		}
		
	}
}

/*
	@NoPrint 가 지정된 함수는 함수를 수행하되 결과를 출력하지 말아라 ... 를 구현해보기
*/