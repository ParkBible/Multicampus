import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Iterator;

public class Test131{
	public static void main(String[] args) throws Exception{
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		List<String> lst = new LinkedList<String>();
		
		while(true){
			String l = bin.readLine();
			
			if(l.startsWith("AD ")){
				lst.add(l.substring(3, l.length()));
			}
			
			else if(l.equals("PA")){
				Iterator<String> it = lst.iterator();
				while(it.hasNext()){
					System.out.println(it.next());
				}
				break;
			}
			
			else if(l.startsWith("PR ")){
				String prstr = l.substring(3, l.length());
				Iterator<String> it = lst.iterator();
				while(it.hasNext()){
					String t = it.next();    // 이코드 입력해줘야됨(t에 대입)... 왜지?
					if(t.indexOf(prstr)!=-1){
						System.out.println(t);
					}
				}
			}
			
			else if(l.startsWith("DL ")){
				String delstr = l.substring(3, l.length());
				Iterator<String> it = lst.iterator();
				while(it.hasNext()){
					if(it.next().indexOf(delstr)!=-1){
						it.remove();
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