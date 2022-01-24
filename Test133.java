import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class CodeV0{
	String code = null;
	String name = null;
	
	CodeV0(String c, String n){   // ������
		code = c;
		name = n;
	}
	
	public String toString(){    // toString�� �������̵��� 
		return "[" +code+ "]:" + name;
	}
}

public class Test133{
	public static void main(String[] args) throws Exception{
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		List<CodeV0> lst = new ArrayList<CodeV0>();
		
		while(true){
			String l = bin.readLine();    //String l = "KR ���ѹα�";
			/*
			String c = l.substring(0,2);     // KR
			String n = l.substring(3);    // ���ѹα�
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
					if(t.code.equals(delstr)){    // t.code == delstr�� ����� �ȵ�...
						it.remove();
					}
					else{
						System.out.println("else");
					}
				}
			}
			
			if(l.equals("quit")){    // equals : ���ڿ� �� �޼ҵ�. �Է��� ���ڿ��� quit�̸� ����.
				break;
			}
		}
		
		bin.close();
	}
}


/*
AD US �̱�
AD KR ���ѹα�
AD CH ������

DL CH -- ����
PA -- �Է¼������ ���


lst.add(new CodeV0("KR","���ѹα�"));
lst.add(new CodeV0("US","�����߱�"));
lst.add(new CodeV0("CH","����������"));
*/