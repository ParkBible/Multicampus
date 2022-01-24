import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Iterator;

public class Test131{
	public static void main(String[] args) throws Exception{
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		List<String> lst = new LinkedList<String>();
		Iterator<String> it = l.iterator();
		
		while(true){
			String l = bin.readLine();
			
			if(l.startsWith("AD ")){
				lst.add(l.substring(3, l.length()));
			}
			
			if(l.equals("PA")){
				for(int i=0; i<l.length; i++){
					if(lst(i).indexOf("an")!=-1){
						System.out.println(lst(i));
						break;
					}
				}
			}
			
		}
		
		bin.close();
	}
}

/*
	AD apple이라고 치면 리스트에 apple 추가
	PA 라고 치면 모두 출력
*/