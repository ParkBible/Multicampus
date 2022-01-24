class Util{
	public static boolean endsWith(char[] i, char[] j){
		/*
		if(i[2] == j[0]){
			if(i[3] == j[1]){
				if(i[4] == j[2]){
					return true;
				}
			}
		}
		*/
		
		boolean b = true;
		int start = i.length - j.length;
		
		for(int k=0;k<j.length;k++){
			if(i[k+start] == j[k]){
				continue;
			}
			else{
				b = false;
				break;
			}
		}
		return b;
	}
}

public class Test161 {
	public static void main( String[] args ) {
		// static한 함수 호출방법
		boolean b = Util.endsWith("Apple".toCharArray(), "lle".toCharArray());
		System.out.println(b);
	}
}