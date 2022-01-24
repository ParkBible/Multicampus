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
		
		// ���� for��, �迭�� List, Set�� ��쿡 ����� �� �ִ�. (jdk 1.5)
		// ���̽��� for i in l �� ����ϴ�...
		for(Method mtd : mtds){
			// getParameterTypes�� ��ü�� �˰�ʹ�. � �ڵ带 ¥�� �� �� ������?
			
			if("print".equals(mtd.getName())){
				Class<?>[] temp = mtd.getParameterTypes();
				for(Class<?> t : temp){
					System.out.println(t);    // print�� �Ķ���͵��� ����Ѵ�.
					System.out.println(t == int.class);    // �Ķ���� Ÿ���� int�� �´��� Ȯ��
				}
				
			}
		}
	}
}

/*
	�Լ� �̸��� ��� ������ api�� ��� ������ ©��?
*/