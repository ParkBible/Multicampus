import java.util.Scanner;
import java.lang.reflect.Method;

class DataVO {
	private int data = 0;
	private String name = null;
	
	public void setData( int i ){
		data = i;
	}
	public void setName( String i ){
		name = i;
	}
	
	public String toString() {
		return "{data:"+data+",name:"+name+"}";
	}
}

public class Test160 {
	public static void main( String[] args ) throws Exception{
		//char c = 'n';
		//char c2 = (char)(c-32);
		//System.out.println( c2 );

		DataVO vo = new DataVO();
		
		Scanner sc = new Scanner( System.in );
		boolean alive = true;
		String l = null;
		while( alive ) {
			l = sc.nextLine();
			
			if( l.equals("quit") ) {
				alive = false;
				break;
			}
			
			int idx = l.indexOf(" ");
			String s = l.substring(0, idx);
			char c = (char)(s.charAt(0)-32);
			String i = l.substring(1+idx);    // �޺κ�(100�̳� apple)
			//System.out.println(c);
			s = "set" + String.valueOf(c) + l.substring(1, idx);    // setName
			System.out.println("s : " + s);
			System.out.println("i : " + i);

		
			Class<?> cls = vo.getClass();
			Method[] mtds = cls.getMethods();
			
			/*
			for( Method mtd : mtds ){
				System.out.println(mtd.getName());
				Class<?>[] ps = mtd.getParameterTypes();
				if(s.equals(mtd.getName())){
					System.out.println("a");
					mtd.invoke( vo, i2 );
				}
			}
			*/
			
			for( Method mtd : mtds ){
				if(s.equals(mtd.getName())){
					Class<?>[] ps = mtd.getParameterTypes();
					if( ps.length == 1 && ps[0] == String.class ) {    // �Ű������� 1���� Ÿ���� String�̸�
						mtd.invoke( vo, i );
					}
					else if( ps.length == 1 && ps[0] == int.class ){
						mtd.invoke( vo, Integer.parseInt(i) );
					}
			
				}
			}
			
			
			// data 100
			// name apple
			/*
				data -> setData
				name -> setName 
				1. ���·� ��ȯ�ϴ� �ڵ带 StringBuffer �� �̿��Ͽ� ���� ��
				   ( �ٸ��̸��̶� �ϴ��� ���ư� �� �ְ� , ���� ��� apple �� setApple )
				   
				   String l = "data";
				   
				   StringBuffer sb = new StringBuffer();
				   sb.append("set");
				   sb.append(l);
				   sb.setCharAt(0,(char)(ch-32));
				   String t = sb.toString();
				   System.out.println(t);
				   
				
				2. ������ setXXX �Լ��� Method �� �̿��Ͽ� vo �� ����Ű�� �ν��Ͻ��� ������ ������
				   �� String "100" �� int 100 ���� �ٲܶ��� Integer.parseInt("100") �� �̿��Ѵ�.
				   �Ű������� ������ String �� int �ΰ����� �����Ѵ�.
			*/
			
			
		}
		System.out.println( vo );
	}
}