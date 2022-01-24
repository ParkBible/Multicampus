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
		Object obj = new Calc();    // newInstance�� �ص� �Ǳ��Ѵ�.
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
	@NoPrint �� ������ �Լ��� �Լ��� �����ϵ� ����� ������� ���ƶ� ... �� �����غ���
*/