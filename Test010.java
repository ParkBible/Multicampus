public class Test010 {
	public static void main(String[] args){
		for(int i=0; i<5; i++){
			System.out.println(i);
		}
		
		//System.out.println(i);	// 에러
		
		for(int i=0; i<2; i++){
			for(int k=0; k<3; k++){
				System.out.println(k);
			}
		}
		
	}
}

/*
	cannot find symbol : 이름에 해당하는 대상을 못 찾는다. 즉 i는 정의가 되어있지 않다.
	따라서 i는 중괄호 영역에서밖에 사용되지 않는 변수.
	for문장 안에 for 문장이 들어가는 경우는... 많이 나오니까 기본을 철저히 하자.
*/