public class Test024{
	public static void main(String[] args){		
		boolean same = true;
		int len = 0;
		
		char[] a = "apple".toCharArray();
		char[] b = "apple".toCharArray();
		
		if(a.length!=b.length){
			same = false;
		}else{
			for(int i=0; i<a.length; i++){
				if(b[i] != a[i]){
					same = false;
					break;
			}
			}
		}
		
		System.out.println(same);
	}
}

/*
	Q. 두 개의 배열에 들어있는 문자열이 동일하면 true, 아니면 false가 출력되게 함.
	A. 우선, 두 문자열의 길이를 비교한다. 만약 길이가 동일하면 같은 위치에 있는 문자끼리 비교한다.
	하나라도 다르면 그 뒷부분은 비교할 필요가 없기에 바로 break로 빠져나옴.(권장)
*/