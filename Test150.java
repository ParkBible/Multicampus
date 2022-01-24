package banana;

import java.lang.reflect.Method;

class Temp{
	public void print(int i, int j){
		System.out.println("Apple");
	}
}

public class Test150{
	public static void main(String[] args) throws Exception{
		Class<?> cls = Class.forName("banana.Temp");
		Object obj = cls.newInstance();
		
		//Method[] mtds = cls.getMethods();
		Method[] mtds = cls.getMethods();
		for(int i=0; i<mtds.length; i++){
			//System.out.println(mtds[i].toString());
			System.out.println(mtds[i].getName().toString());
		}
		
		// 향상된 for문, 배열과 List, Set의 경우에 사용할 수 있다. (jdk 1.5)
		// 파이썬의 for i in l 과 비슷하다...
		for(Method mtd : mtds){
			// getParameterTypes의 정체를 알고싶다. 어떤 코드를 짜면 알 수 있을까?
			
			if("print".equals(mtd.getName())){
				Class<?>[] temp = mtd.getParameterTypes();
				for(Class<?> t : temp){
					System.out.println(t);    // print의 파라미터들을 출력한다.
					System.out.println(t == int.class);    // 파라미터 타입이 int가 맞는지 확인
				}
				
			}
		}
	}
}

/*
	함수 이름만 찍고 싶은데 api를 어디서 뒤져서 짤까?
*/