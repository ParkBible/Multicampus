package banana;

import java.lang.reflect.Method;

class Temp{
	public void print(int i){
		System.out.println("Hello" + i);
	}
	public void print(){
		System.out.println("Apple");
	}
	public double print(int i, double j){
		System.out.println("Banana" + j);
		return i+j;
	}
}

public class Test148{
	public static void main(String[] args) throws Exception{
		Class<?> cls = Class.forName("banana.Temp");
		Object obj = cls.newInstance();    // �ν��Ͻ� ����, obj�� ������
		System.out.println(obj);
		
		/*
			cls.getMethod("print", int.class);
			cls�� ����� �޼ҵ� �� �̸��� print�̰� �Ű������� int�� ����� �Լ������͸� �ѱ��.
			mtd.invoke(obj, 100);
			�Լ��� ȣ���ϸ鼭 �Ű������� 100�� �ѱ��.
		*/
		
		Method mtd = cls.getMethod("print", int.class);
		mtd.invoke(obj, 100);
		
		// jdk 1.5���� getMethod �Լ��� �������� �Ķ���͸� ���� ���¸� �����Ѵ�.
		Method mtd2 = cls.getMethod("print", int.class, double.class);
		Object rv = mtd2.invoke(obj, 100, 3.14);
		System.out.println(rv);
	}
}

/*
	public Object invoke(Object obj, Object ... args)
	- obj�� ����Լ��� ȣ���� �ν��Ͻ��� ���� ������
	- args�� �Ű������� �ѱ� ��(�������� �Ķ����)
	- ���ϵǴ� ���� �Լ��� ���ϰ��� �ش�. (����Ÿ���� void�� �Լ��� null�� ����)
*/