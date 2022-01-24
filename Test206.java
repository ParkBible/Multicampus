
class Toilet{
	public void bigWork(String by){
		System.out.println("BW STEP 1 : " + by);    // 큰일은 5단계로 이루어진다.
		System.out.println("BW STEP 2 : " + by);
		System.out.println("BW STEP 3 : " + by);
		System.out.println("BW STEP 4 : " + by);
		System.out.println("BW STEP 5 : " + by);
	}
}

class Kim extends Thread{
	private Toilet toi = null;
	public Kim(Toilet t) {this.toi = t;}    // 생성자
	public void run(){
		for(int i=0; i<10; i++){
			toi.bigWork("kim");
		}
	}
}

class Park extends Thread{
	private Toilet toi = null;
	public Park(Toilet t) {this.toi = t;}
	public void run(){
		for(int i=0; i<10; i++){
			toi.bigWork("park");
		}
	}
}

public class Test206{
	public static void main(String[] args){
		Toilet toilet = new Toilet();
		
		Thread k = new Kim(toilet);
		Thread p = new Park(toilet);
		
		k.start();    // 쓰레드는 이거 해줘야 돌아간다.
		p.start();
	}
}

/*
	독자적, 동시에 실행되는 코드는 쓰레드로,
	그 쓰레드들이 이용하는 클래스는 보통 클래스로 짠다.
	
	지금 같은칸에 들어가서 동시에 일을 보겠다고 난리가 일어난 상황이다. (한번에 1 2 3 4 5를 해야 되는데 중간에 끼어듦)
	BW STEP 1 : kim
	BW STEP 1 : park
	BW STEP 2 : park
	BW STEP 2 : kim
	여러 쓰레드가 동시에 하나의 인스턴스를 사용하는 경우에 반드시 처리해야 하는 일이 된다.
	
	모두가 각각 자신의 전용 화장실을 가지고 있으면 이런 일이 안 생김 - 현실적으로 불가능
	이런 경우에는 먼저 사용하는 쓰레드가 문을 잠그고 들어가면 그 다음 쓰레드는 기다려야 한다.
	이 개념이 동기화 개념이 되고 이는 java 언어의 키워드로 지원되고 있다.
*/