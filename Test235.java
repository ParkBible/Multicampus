import java.io.*;

public class Test235{
	public static void main(String[] args) throws IOException{
		//BufferedReader in = new BufferedReader(new FileReader("C:\\JavaWork\\2001.smi"));
		
		// InputStreamReader : 내가 읽고 싶은 문자 인코딩 가능
		BufferedReader in = new BufferedReader( new InputStreamReader(new FileInputStream("C:\\JavaWork\\2001.smi"),"utf-8"));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("C:\\JavaWork\\2001c.smi"),"utf-8"));
		
		String r = null;
		while((r=in.readLine())!=null){
			// String r = in.readLine;
			System.out.println(r);
			out.println(r);
		}
		out.close();
		in.close();
	}
}

/*
	깨지는 이유: java는 유니코드를 쓴다
	요새 쓰는 건 문자가 쉽게 추가될 수 있는 가변길이 문자체계인 utf-8.
	이걸로 인코딩된 걸 그냥 읽으면 깨진다.
	근데 2001c.smi도 type으로 읽으면 깨진다.(영어나 숫자, 특수기호 이런거 아니면 깨진다고 함)
*/