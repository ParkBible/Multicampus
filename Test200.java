
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
		this.ig = i;    // i�� HelloGreet�� ����Ű�� �ִ�.
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
		// ���ڷ��̼� ������ Ŭ�������� ������ ���� ������ �Ǵ��� �ڵ��� ������ ���� ����.
		// ��û�� ������̴�.
		IGreet ig = new StarDeco(new DoubleDeco(new HelloGreet()));    // MerciGreet���� �ٲٴ��� �ؿ����� �ٲ��ʿ� ���� �״�� �ᵵ �ȴ�.
		System.out.println(ig.greet());
	}
}

/*
	InputStream in = new FileInputStream(..);
	InputStream in = new ByteArrayInputStream(..);  // �����ȯ���� file ��� byte[]�� ����Ѵ�.
													// �׷��� file�� byte�� �ٲٴ��� �� �ڵ���� �ٲ� �ʿ䰡 ����.
	
	IGreet - InputStream
	FileInputStream - HelloGreet
	ByteArrayInputStream - MerciGreet
	
	�Ѵ� InputStream���� ��ӹ��� �͵�.
	file�� �����ϰ� �ۼ��� �ڵ带 byte[]�� ������� �� �ڵ�� ����� �ν��Ͻ��� �ٲٸ� �Ǵ���.
	
	
	IGreet ig = new DoubleDeco(new HelloGreet());
	
	MerciGreet�� �����־�� �� ���,
	DoubleDeco�� ������ ������ �����ϰ� �ִ�. �� ���� ���յ� ���·� ����� ����� �ִ�.
	���ڷ����͸� ���ļ� ������ �� ������?
	
	DoubleDeco - BufferedInputStream(���۸��� �̿��Ͽ� ������ �д� ����� �����Ѵ�.)
	BufferedInputStream�� �����ϴ� ����� ���ļ� �д� ����� FileInputStream���� �д� �ڵ尡 �� �Ŵ�.
	
	ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(..)))
	
	FileInputStream���� �дµ� BufferedInputStream�� �̿��Ͽ� �ӵ��� �÷��ְ�
	�ѿ� ObjectInputStream�� ������, ���⼭ �����ϴ� readInt / readDouble ���� �� �� �ִ� �ڵ尡 �ȴ�.
	
	���ڷ��̼��� �پ��� ������ ����� ��� �ڵ忡 ū ������ ���� �ʴ´�.
*/