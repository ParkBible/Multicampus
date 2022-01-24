
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test130{
	public static void main(String[] args) throws Exception{
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			String l = bin.readLine();
			
			if(l.equals("quit")){    // equals : 문자열 비교 메소드. 입력한 문자열이 quit이면 끝남.
				break;
			}
			System.out.println(l);
		}
		
		bin.close();
	}
}

/*
	readLine : 콘솔창에서 입력하고 엔터 누르면 해당 라인의 문자열을 리턴한다.
*/