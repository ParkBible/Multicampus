package banana;

import java.lang.reflect.Method;

class CodeV0{
	String code = null;
	public void setCode(String i){    // public ������ �˻��� �ȵȴ�.(getMethod�� �ȵ�)
		this.code = i;
	}
}

public class Test151{
	public static void main(String[] args) throws Exception{
		String l = "setCode:Banana";    // �Լ���� ���� �ٲ���� �ִٰ� �����ϰ� ¥����
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
			if("setCode".equals(mtd.getName())){    // setCode�� ���� String l���� ���°�. ���� setCode��� �Լ��� ���ٸ� �����ȶ߰� �׳� �ƹ��͵��ȶߵ��� ����
				Class<?>[] ps = mtd.getParameterTypes();
				
				if(ps.length == 1 && ps[0] == String.class){     // �Ű����� Ÿ���� string�̸�
					mtd.invoke(vo,"Banana");
				}
				else if(ps.length == 1 && ps[0] == int.class){    // �Ű����� Ÿ���� int�̸�
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
	������ �η¼� ������ - �������� �ִ���.(�δ� 1�� ���ϸ� �Ҿ�)
	���������� �� ���� ��ȸ�� ��Ȳ
	������ �������� ���� �ߵ� �� �ְ� ������ �� ȸ�������� �߿��ϴ�
	������ ���ߵ�°� �ϳ�, ����� �纸�� �� ���°� �ϳ��� ���� �Ѵ�.
	���� ���ϴ� ���� ���� �� �ִ� ȸ��
	
	// �̷��� �� ������ �ߴµ� ���� �Լ��� ã������ ������ ���ͼ� �ٸ� ����� ã�ƾ߰ڴ�.
	if(mtd == null){    // ������ Ÿ���� mtd�� �������� ã�´�. �׷� �Ű������� ������ ������ ���Ϸ��� ��� �ؾ�����?
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
		String l = "setCode:Banana";    // �Լ���� ���� �ٲ���� �ִٰ� �����ϰ� ¥����
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