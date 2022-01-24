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
			String i = l.substring(1+idx);    // 뒷부분(100이나 apple)
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
					if( ps.length == 1 && ps[0] == String.class ) {    // 매개변수가 1개고 타입이 String이면
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
				1. 형태로 변환하는 코드를 StringBuffer 를 이용하여 만들 것
				   ( 다른이름이라 하더라도 돌아갈 수 있게 , 예를 들어 apple 은 setApple )
				   
				   String l = "data";
				   
				   StringBuffer sb = new StringBuffer();
				   sb.append("set");
				   sb.append(l);
				   sb.setCharAt(0,(char)(ch-32));
				   String t = sb.toString();
				   System.out.println(t);
				   
				
				2. 구해진 setXXX 함수를 Method 를 이용하여 vo 가 가리키는 인스턴스에 내용을 넣을것
				   단 String "100" 을 int 100 으로 바꿀때는 Integer.parseInt("100") 을 이용한다.
				   매개변수의 유형은 String 과 int 두가지로 한정한다.
			*/
			
			
		}
		System.out.println( vo );
	}
}