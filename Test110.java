
interface IGreet{
	public String greet();
}

class HelloGreet implements IGreet{
	public String greet() {return "Hello";}
}

class MerciGreet implements IGreet{
	public String greet() {return "Merci";}
}

class SharpDeco implements IGreet{
	private IGreet ig = null;    // 밖에서 접근할 일 없으니까 null로 한다.
	public SharpDeco(IGreet i){
		this.ig = i;    // IGreet형 변수(포인터임)를 매개변수로 받아와서 로컬 멤버변수 ig에 넣는다.
	}
	public String greet() {
		return "#" + ig.greet() + "#";    // ig는 현재 클래스 자체를 가리키고 있다. ig가 가리키는 클래스의 문자열을 받아와야 하므로 ig.greet()
										  // 그냥 ig만 넣으면 ig가 가리키는 위치만 뜨므로 클래스명@고유번호가 뜬다.
		}
}

class StarDeco implements IGreet{
	private IGreet ig = null;    // 밖에서 접근할 일 없으니까 null로 한다.
	public StarDeco(IGreet i){
		this.ig = i;
	}
	public String greet() {
		return "*" + ig.greet() + "*";
		}
}

public class Test110{
	public static void main(String[] args){
		
		IGreet ig0 = new MerciGreet();    // Merci
		IGreet ig = new SharpDeco(new MerciGreet());    // #Merci#
		IGreet ig2 = new SharpDeco(new HelloGreet());    // #Hello#
		IGreet ig3 = new SharpDeco(new SharpDeco(new HelloGreet()));     // ##Hello##
		IGreet ig4 = new StarDeco(new SharpDeco(new HelloGreet()));    // *#Hello#*
		
		System.out.println(ig0.greet());
		System.out.println(ig.greet());
		System.out.println(ig2.greet());
		System.out.println(ig3.greet());
		System.out.println(ig4.greet());
	}
}

// Decorator Pattern이라고 한다.