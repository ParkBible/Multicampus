

public class Test204{
	public static void main(String[] args){
		StringBuffer sb = new StringBuffer();    // 하나의 sb를 공유하고 있다.
		Runnable r = new Runnable(){
			public void run(){
				for(int i=0; i<100; i++){
				try{
					Thread.sleep(350);    // 예외처리 해줘야 한다.
					}
					catch(InterruptedException e){
					}
					System.out.println("run " + i);
					sb.append("*");
					}
				System.out.println("run end " + sb.toString());
			}
		};
		Thread t = new Thread(r);
		t.start();    // start 호출 > 가상의 cpu 생성 > 그것이 run을 호출한다.
		//r.run();     // 이건 밑에꺼랑 동시에 돌아가지 않는다. 쓰레드가 없으니까 당연하다.
		
		for(int i=0; i<100; i++){
			try{
				Thread.sleep(500);    // 예외처리 해줘야 한다.
			}
			catch(InterruptedException e){
			}
			System.out.println("main " + i);
			sb.append("#");
		}
		System.out.println("main end");
	}
}

/*
	Thread.sleep(500);    // 0.5초마다 돌아간다.
	하나의 프로세스 안에서 독자적으로 동작하는 가벼운 프로세스를 생성하는 것이 Thread의 개념이다!
	(r.run()을 실행할 때와 차이점을 느끼는 것에서 시작하자)
	
	Thread를 생성하고 돌리는 프로그램에서는 main이 끝났다고 해서 끝난 게 아니라,
	모든 Thread가 끝이 나야 프로그램이 종료된다.
	
	하나의 프로세스 안에서 생성된 Thread들 사이에서는 메모리 공유가 가능하다.
	프로세스(동작하는 프로그램) 상의 메모리 공유는 불가능하지만
	파일이나 소켓통신을 이용하여 정보의 전달은 가능하다.
	ctrl+c ctrl+v는 뭔가요?? 그건 OS에서 OLE라는 개념을 지원해서 가능하다.
	
	Thread는 독학하기 어렵다 ㅠㅠ
*/