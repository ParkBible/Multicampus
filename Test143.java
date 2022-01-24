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
			getMethod�� �����ϴ� Method�� ������ �Լ��������ΰ��� ? ->���
			cls���� ������ print��� �̸��� �Լ��� ȣ���� �� �ִ� �����͸� �����ϴ� ��.
			
			�Լ�ȣ��(invoke ���)�� �ش� �ν��Ͻ��� ���� �����͸� �־��־�� �Ѵ�.
			
			void XList_delete_all(void* self){
			}
			C������ �̰Ŷ� ����ϴ�.
		*/
		
		Method mtd = cls.getMethod("print");    // print��� �̸��� cls �޼ҵ带 ȣ���� �� �ִ� ������ mtd ����
		mtd.invoke(obj);    // �Ʊ�� �������̽�(ICar)�� ���� ����Լ��� ȣ���ߴµ� �̰� �������̽� ���̵� ȣ���� �� �� �ִ�.
	}
}

/*
	javac -d C:\classes Test143.java
	java -classpath C:\classes banana.Test143
*/