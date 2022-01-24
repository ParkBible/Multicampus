import java.io.*;

public class Test199 {
	public static void main(String[] args){
		try{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("e.dat"));
			out.writeInt(2323232);
			out.writeDouble(3.141692);    // �̰� ���Ǿ����ִϱ� r�� ����̾ȵȴ�.
			out.writeUTF("����ѹ�");
			out.close();
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("e.dat"));
			int r = in.readInt();
			double d = in.readDouble();
			String t = in.readUTF();
			
			/*
				�ٷ� ������ �� �̻� ���� �� �����Ƿ� .read()�ϸ� ���� -1�� ������, readInt()�� ����ϸ� IOException �������.
			*/
			int j = in.readInt();    
			System.out.println(j);
			
			in.close();
			
			System.out.println(r);
			System.out.println(d);
			System.out.println(t);
		}
		catch(IOException e){
			e.printStackTrace();    // �߻��� ������ ���������� ������ �� �ֵ��� �Ѵ�.
		}
	}
}

/*
	public ObjectOutputStream(OutputStream out) throws IOException
	�Ű����� out�� FileOutputStream�� �ν��Ͻ��� ����ų �� �ֱ⿡ ���� �ڵ尡 �����ϴ�.
	
	writeInt / readInt : int�� ���� �ʰ� �ְ���� �� �ִ� ����Լ�.
	������� �ְ�ޱ� ������ ������ �ٲ�� ���� �ȵȴ�.
	
	java���� ��� ������ ����� ����� �Ǵ� Ŭ������ ObjectInputStream / ObjectOutputStream�� �ȴ�.
	�޽��� ���� ���鶧, �̰ɷ� ����°� �ٶ����ϴ�.
	- �̰� ���Ͽ����� ���� �ֳ�?
	- �̰��� Decorator Pattern�̶�� ������������ ����Ǿ ó������ �װ� ���ο� �ΰ� ���������.
*/