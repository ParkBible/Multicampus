public class Test026{
	public static void main(String[] args){
		char[] words = "HelloWorld".toCharArray();
		char[] ptn = "lll".toCharArray();
		int idx = 0;
		/*
		//패턴 3글자면 8번, 4글자면 7번, 2글자면 9번
		int count = 0;
		for(int i=0; i<words.length-ptn.length+1; i++){ //0,1,2,3,4,5,6,7...
			for(int j=0; j<ptn.length; j++){ //0,1,2
				if(words[i+j] == ptn[j]){
					if(count == 0){
						idx = i+j;
					}
					count++;
					System.out.println(count + "cnt");
					if(count == ptn.length){
						System.out.println(idx);
						break;
					}
				} else{
					count = 0;
				}
			}
		}
		if(count != ptn.length){
			System.out.println(-1);
		}
		*/
		char[] a = "HelloWorld".toCharArray();
		char[] b = "asdf".toCharArray();
		
		len = a.length - b.length + 1
		
		for(int i=0; i<len; i++){
		boolean match = true;
		
			for(int j=0; j<b.length; j++){
				if(a[i+j] != b[j]){
					match = false;
					break;
				}
			}
			if(match == true){
				idx = i;
				break;
			}
	}
	System.out.println(idx);

	}
}

/*
	문자열 패턴의 위치를 출력하는 코드. 패턴이 없으면 -1이 출력됨.
	words가 HelloWorld일때,
	ll : 2출력
	llo : 2출력
	xyz : -1출력
	ldx : -1출력
	길이가 0인 문자열 : -1출력
	
	크게 보고, 한번에 하나씩 허가
	[H][e][l][l][o][W][o][r][l][d]
	[l][l][o]
	
	if(a[0] == b[0] && a[1] == b[1] && a[2] == b[2]{
		idx = 0;
	} else if(a[1] == b[0] && a[2] == b[1] && a[3] == b[2]){
		idx = 1;
	} else if(a[2] == b[0] && a[3] == b[1] && a[4] == b[2]){
		idx = 2;
		...
	} else if(a[7] == b[0] && a[8] == b[1] && a[9] == b[2]){
		idx = 7;  //이 뒤로는 비교가 의미가 없으므로 안한다.
	}
-------------------------------------------------------------------------
	를 다음 반복문으로 정리
	for(int i=0; i<8; i++){
		if(a[i]==b[0] && a[i+1] == b[1] && a[i+2] == b[2]){
			idx = i;
			break;
		}
	}
-------------------------------------------------------------------------
	셋 다 일치해야 break, 나머지는 false
	boolean match = true;
	if(a[i] != b[0]){
		match = false;
	}
	else if(a[i+1] != b[1]){
		match = false;
	}
	else if(a[i+2] != b[2]){
		match = false;
	}
	else if(a[i+3] != b[3]){
		match = false;
	}
	
	if(match = true){
		idx = i;
		break;
	}
-------------------------------------------------------------------------
를 다음 반복문으로 정리
	for(int i=0; i<8; i++){
		boolean match = true;
		
		for(int j=0; j<b.length; j++){
			if(a[i+j] != b[j]){
				match = false;
				break;
			}
		}
		if(match == true){
			idx = i;
			break;
		}
	}
	System.out.println(idx);

*/