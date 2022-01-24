import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class CodeV0{
	String code = null;
	String name = null;
	
	CodeV0(String c, String n){   // 생성자
		code = c;
		name = n;
	}
	
	public String toString(){    // toString을 오버라이딩함 
		return "[" +code+ "]:" + name;
	}
}

public class Test133{
	public static void main(String[] args) throws Exception{
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		List<CodeV0> lst = new ArrayList<CodeV0>();
		
		while(true){
			String l = bin.readLine();    //String l = "KR 대한민국";
			/*
			String c = l.substring(0,2);     // KR
			String n = l.substring(3);    // 대한민국
			System.out.println(c);
			System.out.println(n);
			*/
			
			if(l.startsWith("AD ")){
				lst.add(new CodeV0(l.substring(3,5),l.substring(6)));
			}
			
			
			else if(l.equals("PA")){
				Iterator<CodeV0> it = lst.iterator();
				while(it.hasNext()){
					CodeV0 t = it.next();
					System.out.println(t.toString());
				}
			}
			
			else if(l.startsWith("DL ")){
				String delstr = l.substring(3,5);
				Iterator<CodeV0> it = lst.iterator();
				//System.out.println(delstr + ":del");
				while(it.hasNext()){
					CodeV0 t = it.next();
					//System.out.println(t.code + ":t.code");
					if(t.code.equals(delstr)){    // t.code == delstr로 세우면 안됨...
						it.remove();
					}
					else{
						System.out.println("else");
					}
				}
			}
			
			if(l.equals("quit")){    // equals : 문자열 비교 메소드. 입력한 문자열이 quit이면 끝남.
				break;
			}
		}
		
		bin.close();
	}
}


/*
AD US 미국
AD KR 대한민국
AD CH 스위스

DL CH -- 삭제
PA -- 입력순서대로 출력


lst.add(new CodeV0("KR","대한민국"));
lst.add(new CodeV0("US","미합중국"));
lst.add(new CodeV0("CH","스위스연방"));
*/