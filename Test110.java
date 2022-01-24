
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
	private IGreet ig = null;    // �ۿ��� ������ �� �����ϱ� null�� �Ѵ�.
	public SharpDeco(IGreet i){
		this.ig = i;    // IGreet�� ����(��������)�� �Ű������� �޾ƿͼ� ���� ������� ig�� �ִ´�.
	}
	public String greet() {
		return "#" + ig.greet() + "#";    // ig�� ���� Ŭ���� ��ü�� ����Ű�� �ִ�. ig�� ����Ű�� Ŭ������ ���ڿ��� �޾ƿ;� �ϹǷ� ig.greet()
										  // �׳� ig�� ������ ig�� ����Ű�� ��ġ�� �߹Ƿ� Ŭ������@������ȣ�� ���.
		}
}

class StarDeco implements IGreet{
	private IGreet ig = null;    // �ۿ��� ������ �� �����ϱ� null�� �Ѵ�.
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

// Decorator Pattern�̶�� �Ѵ�.