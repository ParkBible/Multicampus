
/*
	Thread를 생성하는 방법
	1. Runnable 인터페이스 상속받은 클래스의 인스턴스를 생성한다.(어나니머스 클래스를 이용)
	2. public void run()을 오버라이딩 한다.
	3. 만든 인스턴스를 Thread의 생성자에 넣어준다. ( Thread 생성 )
	4. start() 호출하면 > OS에 요청하여 Thread를 할당받고(안보임) > 그것이 run()을 돌림.
	외우기
*/


public class Test203{
	public static void main(String[] args){
		Runnable r = new Runnable(){
			public void run(){
				System.out.println("hello");
			}
		};
		Thread t = new Thread(r);
		t.start();
	}
}

/*
	Thread란? : a light-weight process
	Process란? : a running program
	Program이란? : executable file
	
	Thread는 Process 안에서만 존속할 수 있다.
	모든 Thread가 종료된 시점에서 Process는 종료된다.(main이 동작하는 것도 Thread이다)
*/

/*
public class Test203{
	public static void main(String[] args){
		Runnable r = new Runnable(){
			public void run(){
				System.out.println("HelloThread");
			}
		};
		Thread t = new Thread(r);
		t.start();
	}
}
*/