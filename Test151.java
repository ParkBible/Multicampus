package banana;

import java.lang.reflect.Method;

class CodeV0{
	String code = null;
	public void setCode(String i){    // public 없으면 검색이 안된다.(getMethod가 안됨)
		this.code = i;
	}
}

public class Test151{
	public static void main(String[] args) throws Exception{
		String l = "setCode:Banana";    // 함수명과 값은 바뀔수도 있다고 생각하고 짜세요
		int i = l.indexOf(":");
		//System.out.println(l.substring(0,i));
		//System.out.println(l.substring(i+1));
		Class<?> cls = Class.forName("banana.CodeV0");
		Object vo = cls.newInstance();
		System.out.println(vo);
		
		//CodeV0 vo = new CodeV0();
		
		//System.out.println(vo.code);
		Method mtd = cls.getMethod(l.substring(0,i));
		for(Method mtd : mtds){
			if("setCode".equals(mtd.getName())){    // setCode는 위에 String l에서 나온거. 만약 setCode라는 함수가 없다면 에러안뜨고 그냥 아무것도안뜨도록 유도
				Class<?>[] ps = mtd.getParameterTypes();
				
				if(ps.length == 1 && ps[0] == String.class){     // 매개변수 타입이 string이면
					mtd.invoke(vo,"Banana");
				}
				else if(ps.length == 1 && ps[0] == int.class){    // 매개변수 타입이 int이면
					mtd.invoke(vo,10101);
				}
			}
		}
		
		
		mtd.invoke(vo, l.substring(i+1));
		CodeV0 t = (CodeV0)vo;
		System.out.println(t.code);
	}
}

/*
	매출대비 인력수 따지기 - 영업력이 있는지.(인당 1억 이하면 불안)
	설립연도와 그 때의 사회적 상황
	하지만 무엇보다 내가 견딜 수 있고 지낼만 한 회사인지가 중요하다
	도저히 못견디는거 하나, 절대로 양보할 수 없는거 하나를 골라야 한다.
	내가 원하는 것을 얻을 수 있는 회사
	
	// 이렇게 해 보려고 했는데 없는 함수를 찾으려니 에러가 나와서 다른 방법을 찾아야겠다.
	if(mtd == null){    // 지정한 타입의 mtd가 나오는지 찾는다. 그럼 매개변수가 없을때 에러를 피하려면 어떻게 해야하지?
			Method mtd = cls.getMethod("setCode", int.class);
		}
		
		
package banana;

import java.lang.reflect.Method;

class CodeV0{
	String code = null;
	public void setCode(String i){
		this.code = i;
	}
}

public class Test151{
	public static void main(String[] args) throws Exception{
		String l = "setCode:Banana";    // 함수명과 값은 바뀔수도 있다고 생각하고 짜세요
		int i = l.indexOf(":");
		//System.out.println(l.substring(0,i));
		//System.out.println(l.substring(i+1));
		Class<?> cls = Class.forName("banana.CodeV0");
		Object vo = cls.newInstance();
		System.out.println(vo);
		
		//CodeV0 vo = new CodeV0();
		
		//System.out.println(vo.code);
		//Method mtd = cls.getMethod(l.substring(0,i), String.class);
		Method mtd = cls.getMethod("setCode", String.class);
		
		mtd.invoke(vo, l.substring(i+1));
		CodeV0 t = (CodeV0)vo;
		System.out.println(t.code);
	}
}
		
*/