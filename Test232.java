import java.io.*;

public class Test232{
	public static void main(String[] args) throws IOException{
		PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaWork\\b.txt"));
		out.println("apple");
		out.println("banana");
		out.println("orange");
		out.println("kiwi");
		out.close();
		
		BufferedReader in = new BufferedReader(new FileReader("C:\\JavaWork\\b.txt"));
		String l = in.readLine();
		in.close();
		System.out.println(l);
	}
}

/*
	PrintWriter :: println -> ���ڿ��� ��°�� �������� ���� �ٲپ� �ش�.
	BufferedReader :: readLine() -> �� �ٲ� ǥ�ñ����� �� ���� �о String���� �����Ѵ�.
	
	PrintWriter�� FileWriter�� �����. write�� �޸� PrintWriter�� println�� ���� ���ڸ� ���ÿ� ������ �� �ִ�.
*/