package banana;

// 보통 import 대상은 클래스인데 import static은 static하게 선언된 함수를 대상으로 한다.
import static banana.Logic.print;

class Logic{
	/*
	public static void print(){
		//System.out.println("HelloWorld");
		//print();    // 함수 안에서 자기 자신을 호출하면 결국 무한반복하게 된다.(이걸 "재귀 호출"이라고 한다)
					// 간단한 코드로 마치 바이러스가 증식되는 것처럼 큰 일을 해 냄.
	}
	*/
	/*
		print(5);
		System.out.println("HelloWorld " + 5);
		print(4);
		System.out.println("HelloWorld " + 4);
		...
	*/
	public static void print(int i){
		System.out.println("HelloWorld " + i);
			
		try{
			Thread.sleep(800);
		}
		catch(Exception e){}
		
		if(i>0){
			print(i-1);    // i가 0보다 클때만 재귀 호출.
		}
		
	}
	
}

public class Test236{
	public static void main(String[] args){
		System.out.println("HelloWorld");
		
		//Logic.print();
		Logic.print(5);     // 그냥 print(5)로만 해도 된다.
	}
}

/*
	javac -d c:\classes Test236.java
	java -classpath c:\classes banana.Test236
*/