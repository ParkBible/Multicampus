import java.io.*;

public class Test199 {
	public static void main(String[] args){
		try{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("e.dat"));
			out.writeInt(2323232);
			out.writeDouble(3.141692);    // 이거 정의안해주니까 r도 출력이안된다.
			out.writeUTF("김수한무");
			out.close();
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("e.dat"));
			int r = in.readInt();
			double d = in.readDouble();
			String t = in.readUTF();
			
			/*
				바로 밑줄은 더 이상 읽을 게 없으므로 .read()하면 원래 -1이 뜨지만, readInt()를 사용하면 IOException 에러뜬다.
			*/
			int j = in.readInt();    
			System.out.println(j);
			
			in.close();
			
			System.out.println(r);
			System.out.println(d);
			System.out.println(t);
		}
		catch(IOException e){
			e.printStackTrace();    // 발생한 에러의 스택정보를 추적할 수 있도록 한다.
		}
	}
}

/*
	public ObjectOutputStream(OutputStream out) throws IOException
	매개변수 out은 FileOutputStream의 인스턴스를 가리킬 수 있기에 위의 코드가 가능하다.
	
	writeInt / readInt : int를 깨지 않고 주고받을 수 있는 멤버함수.
	순서대로 주고받기 때문에 순서는 바뀌면 절대 안된다.
	
	java에서 모든 데이터 통신의 기반이 되는 클래스가 ObjectInputStream / ObjectOutputStream이 된다.
	메신저 등을 만들때, 이걸로 만드는게 바람직하다.
	- 이걸 소켓에서도 쓸수 있나?
	- 이것은 Decorator Pattern이라는 설계패턴으로 설계되어서 처음부터 그걸 염두에 두고 만들어졌다.
*/