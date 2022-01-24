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
		System.out.println(Temp.class == cls);    // �Ȱ���. �����͸� �ٸ�
		System.out.println(obj.getClass() == cls);    // ���� �Ȱ���.
		
		/*
			100�� ����ڽ̵Ǿ� obj�� ���Եȴ�.
			object Ÿ�����δ� ��ڽ��� �ȵǱ� ������ obj�� ����Ű�� ����� Integer�� ����ȯ�� �����ϴ�.
			����ȯ�� �ϸ� Integer�� ������ ������ �ǰ� �̴� ��ڽ� �����ϴ�.
			
			Object obj = 100;
			int r = (Integer)obj;    -- ��ڽ̵Ǿ� .intValue() ȣ���Ͽ� �� ����.
		*/
		
		// invoke �Լ��� ����Ÿ���� Object. ���� ��ڽ��� �ȵȴ�.
		Method mtd = cls.getMethod("print");
		int r = mtd.invoke(obj);
		System.out.println(r);
	}
}

/*
	Class<?> cls = ... �� �����͸� �Ѱܹ޴� ����� 3������ �ִ�.
	
	1. Class.forName("banana.Temp");
	2. [Ŭ������].class : ��� Ŭ�������� .class��� Class���� static ������ �ִ�... ��� ������ ����.
	3. Object���� ����� getClass() �Լ��� ȣ���ؼ� �����͸� �Ѱܹ��� �� �ִ�.
	
	�׷��� Class cls �� ��ü��? : ����� class�� ���õ� �Լ��� ��Ƴ��� ���̴�.
	Method mtd = cls.getMethod("print");
	cls���� getMethod�� ȣ���Ѵ�.
*/