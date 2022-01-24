
interface ICalc{
	public int execute(int i, int j);
}

class Add implements ICalc, NoPrint{
	public int execute(int i, int j){return i+j;}
}

class Minus implements ICalc{
	public int execute(int i, int j){return i-j;}
}

public class Test153{
	public static void main(String[] args){
		ICalc ic = new Add();
		int r = ic.execute(10, 20);
		if(ic instanceof NoPrint){
		}
		else{
			System.out.println(r);
		}
		
	}
}
interface NoPrint {}

/*
	과거에는 command pattern(한동작을 하나의 인스턴스로)을 굉장히 많이쓴게...
	Annotation 개념을 쓰려면 그 패턴으로 가야 했다.
	하나의 동작을 하나의 인스턴스화 하는 설계패턴.
	
	클래스는 만든 사람과 쓰는 사람이 다른 경우가 많다
	만든 사람이 클래스에다가 이걸 쓸 때는 이렇게 썼으면 좋겠다 라는 정보를 심어주고 싶을 때(강제성은 x)
	-> 비어있는 인터페이스를 이용한다.
	
	해당 인터페이스를 상속받은 커맨드를 실행할 때 instanceof를 이용해서
	해당 인터페이스로 상속받은지를 살펴보고 거기에 맞게 지정한 사람의 의도를 헤아린 코드를 만들어넣을 수 있게 된다.
	
	이런 개념을 체계화 해서 언어에 넣은 것이 Annotation 개념이다. 어노테이션은 interface로 만든다.
	최근의 framework 등에서는 annotation의 지정만으로 많은 코드를 대신하는 경향이 많다.
	짜는 사람은 골치아픈데 사용하는 입장에서는 코딩의 양을 많이 줄이게 된다.
	noPrint가 어떤 동작을 하는지는 내가 설정해놓고, noPrint라고 지정이 되어있으면 안찍을거니까 그 부분에 대한 코드는 없어도 된다.
*/