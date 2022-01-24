package banana;

import java.util.Scanner;

interface ICar{
	public void turnRight();
	public void turnLeft();
}

class Spark implements ICar {
	public void turnRight(){System.out.println("tR");}
	public void turnLeft(){System.out.println("tL");}

}

class Colorado implements ICar {
	public void turnRight(){System.out.println("turnR");}
	public void turnLeft(){System.out.println("turnL");}

}

public class Test142{
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		boolean alive = true;
		while(alive){
			String l = sc.nextLine();    // 사용자가 입력한 내용을 l에 저장.
			// System.out.println(l);
			
			if(l.equals("quit")){
				alive = false;    // quit를 입력하면 종료.
			}
			else{
				Class<?> cls = Class.forName(l);
				ICar car = (ICar)cls.newInstance();    // cls 이름인 인스턴스 생성
				
				car.turnRight();
				car.turnLeft();
			}
			
			//alive = false;    // 한번 입력할때마다 프로그램 종료.
		}
	}
}
/*
	Scanner : 콘솔에서 사용자의 입력을 받아들일 용도로 만들어진 클래스(jdk 1.5부터)
	그 이전버전에서는 BufferedReader 쓰면 된다. 똑같다
	
	int add();
	
	int main(){    // 브라우저. 플러그인을 사용하는 쪽
		int r;
		r = add();
		return 0;
	}
	
	int add(){    // 플러그인
		return 100;
	}
	
	브라우저와 플러그인 -> 전통적인 개념에서는 플러그인이 먼저 만들어지고 나중에 브라우저가 개발되어야 하지만
					현실적으로 그게 불가능하다. 그래서 다양한 신기술이 만들어짐.
	
	activeX -> 전화번호부(함수 목록)를 리턴받아서 그 함수의 위치를 호출하게 한다. 
				ms에서 add를 호출할 수 있는 헤더 정보를 제공할 수 있는 특별한 함수를 만들었다.(Iunknown)
	
	전통적 -> exe에 플러그인 포함
	Dynamic Linked Library(DLL) = exe에서 플러그인의 코드를 로딩시켜서 동적으로 써먹음.(.dll)
	
	근데 자바는 이럴 필요 없이, 제공되는 함수 newInstance를 이용해서 바로 생성할 수 있음.
	Temp t = new Temp()와 달리 현재 존재하지 않는 클래스들도 연동될 수 있는 형태의 코드이다.
	단 여기서는 ICar라는 인터페이스를 상속받은 경우에 한한다.
	Test142보다 나중에 개발된 Grandure도 연동되었다.
	
	JDK 1.5부터 이런 개념이 적극 반영되었음.
	
	Class<?> cls = Class.forName("banana.Grandure")
	Object obj = cls.newInstance();    // 이건 원래 object형으로 만들어지지만, ICar로 캐스팅한다.
	ICar obj = new Spark()
*/