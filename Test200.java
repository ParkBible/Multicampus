
interface IGreet{
	public String greet();
}

class HelloGreet implements IGreet{
	public String greet() {return "hello";}
}

class MerciGreet implements IGreet{
	public String greet() {return "Merci";}
}

class DoubleDeco implements IGreet{
	private IGreet ig = null;
	public DoubleDeco(IGreet i){
		this.ig = i;    // i는 HelloGreet을 가리키고 있다.
	}
	
	public String greet(){return ig.greet() + ":" + ig.greet();}
}

class StarDeco implements IGreet{
	private IGreet ig = null;
	public StarDeco(IGreet i){
		this.ig = i;
	}
	public String greet(){return "*" + ig.greet() + "*";}
}

public class Test200 {
	public static void main(String[] args){
		// 데코레이션 역할의 클래스들은 여러번 겹쳐 적용이 되더라도 코드의 변경은 거의 없다.
		// 엄청난 설계법이다.
		IGreet ig = new StarDeco(new DoubleDeco(new HelloGreet()));    // MerciGreet으로 바꾸더라도 밑에꺼는 바꿀필요 없이 그대로 써도 된다.
		System.out.println(ig.greet());
	}
}

/*
	InputStream in = new FileInputStream(..);
	InputStream in = new ByteArrayInputStream(..);  // 모바일환경은 file 대신 byte[]가 대신한다.
													// 그래서 file을 byte로 바꾸더라도 밑 코드들은 바꿀 필요가 없다.
	
	IGreet - InputStream
	FileInputStream - HelloGreet
	ByteArrayInputStream - MerciGreet
	
	둘다 InputStream에서 상속받은 것들.
	file을 생각하고 작성한 코드를 byte[]를 대상으로 한 코드로 변경시 인스턴스만 바꾸면 되더라.
	
	
	IGreet ig = new DoubleDeco(new HelloGreet());
	
	MerciGreet은 보여주어야 할 대상,
	DoubleDeco는 보여줄 형식을 결정하고 있다. 두 개가 결합된 형태로 결과를 만들고 있다.
	데코레이터를 겹쳐서 적용할 수 있을까?
	
	DoubleDeco - BufferedInputStream(버퍼링을 이용하여 빠르게 읽는 기능을 제공한다.)
	BufferedInputStream이 제공하는 장식을 거쳐서 읽는 대상은 FileInputStream에서 읽는 코드가 될 거다.
	
	ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(..)))
	
	FileInputStream에서 읽는데 BufferedInputStream을 이용하여 속도를 늘려주고
	겉에 ObjectInputStream을 씌워서, 여기서 제공하는 readInt / readDouble 등을 쓸 수 있는 코드가 된다.
	
	데코레이션이 다양한 조합을 만들어 내어도 코드에 큰 변경이 가지 않는다.
*/