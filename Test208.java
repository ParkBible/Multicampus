
/*
	여기가 은행지점이고 은행에 관련된 모든 업무가 여기서 함수형태로 제공되고 있다고 가정한다.
	그러면 100개의 쓰레드가 이 인스턴스를 공유하고 있다고 가정한다.
	bigWork - 계좌입금
	sleep - 통장정리 라고 생각해보자.
	동시에 일어나도 되는가? 아니면 절대로 동시에 일어나서는 안 되는가?
	동시에 일어나도 되는 사안이라면?
	그런 사안을 지금처럼 설계했다면... 동시에 일어나면 안되는 것처럼 설계를 해 놨다
	한 사람이 계좌입금 하고 있으면 다른사람은 아무것도 못한다.
	이것을 hanging 현상이라고 하고 이 기간 cpu의 소모는 잡히지 않는다.
	해결법 : 쪽잠자는 곳과 화장실을 분리하고 화장실에서 쪽잠을 못자게 만든다.
	
	Toilet에 sleep을 넣지 말고 BedRoom을 따로 만들어서 그걸 공유하게 하면 된다.
	쓰레드가 놀면 그게 다 돈이다. 해서 최대한 안 노는 설계를 한다.
	그것을 위해서는 어떤 일들이 어떤 객체에 배치되어야 하고 동시에 실행 가능한지를 면밀히 따져야 한다.
	근데 테스트할땐 이상 있는지 모른다. 현장에 가져가면 난리가 난다.
*/
class Toilet{
	public void bigWork(String by){
		System.out.println("BW STEP 1 : " + by);    // 큰일은 5단계로 이루어진다.
		System.out.println("BW STEP 2 : " + by);
		System.out.println("BW STEP 3 : " + by);
		System.out.println("BW STEP 4 : " + by);
		System.out.println("BW STEP 5 : " + by);
	}
	
	public void sleep(String by){
		System.out.println("zzz... begin : " + by);
		try{
			Thread.sleep(1000);
		}
		catch(Throwable e){}
		System.out.println("zzz... end : " + by);    // 자고있으면 다른 사람이 사용 못한다.
	}
}

class Kim extends Thread{
	private Toilet toi = null;
	public Kim(Toilet t) {this.toi = t;}    // 생성자
	public void run(){
		for(int i=0; i<10; i++){
			synchronized(toi){
				if(i % 3 == 2){
					toi.sleep("kim");
				} else{
					toi.bigWork("kim");
				}
				
			}

		}
	}
}

class Park extends Thread{
	private Toilet toi = null;
	public Park(Toilet t) {this.toi = t;}
	public void run(){
		for(int i=0; i<10; i++){
			synchronized(toi){
				if(i % 3 == 2){
					toi.sleep("park");
				} else{
					toi.bigWork("park");
				}
			}
		}

	}
}

public class Test208{
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
	
	지금 같은칸에 들어가서 동시에 일을 보겠다고 난리가 일어난 상황이다.
	BW STEP 1 : kim
	BW STEP 1 : park
	BW STEP 2 : park
	BW STEP 2 : kim
	여러 쓰레드가 동시에 하나의 인스턴스를 사용하는 경우에 반드시 처리해야 하는 일이 된다.
	
	모두가 각각 자신의 전용 화장실을 가지고 있으면 이런 일이 안 생김 - 현실적으로 불가능
	이런 경우에는 먼저 사용하는 쓰레드가 문을 잠그고 들어가면 그 다음 쓰레드는 기다려야 한다.
	이 개념이 동기화 개념이 되고 이는 java 언어의 키워드로 지원되고 있다.
	
		try{
			Thread.sleep(100);
		}
		catch(InterruptedException e){}
		
	synchronized(toi){
		...
	}
	{...}의 영역에 들어가기 위해선 toi가 가리키는 인스턴스가 가진 key를 획득해야 한다.
	모든 인스턴스는 하나의 키를 가지고 있다.
	
	kim과 park이 거의 동시에 toilet에 들어왔어도 kim이 살짝 먼저 열쇠를 갖고 들어가면 park은 열쇠가 반납될 때까지
	기다려야 한다.
	
	열쇠를 가져야만 '{' 을 통과할 수 있고, '}' << 이 시점에서 열쇠는 인스턴스에게 반납된다.
	
	synchronized는 java 키워드이다. 이를 통해서 동시에 인스턴스를 이용하는 쓰레드에 의해서
	벌어질 수 있는 상황(하나의 객체를 여러 쓰레드가 동시에 이용하면 안되는 일)을 막을 수 있다.
*/