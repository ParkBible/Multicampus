public class Test022 {
	public static void main(String[] args){
		int[] l = {3,7,9,10};
		
		int find = 9;
		boolean exist = false;
		
		for(int i=0; i<l.length; i++){
			if(l[i] == find){
				exist = true;
				break;
			}
		}
		
		System.out.print(exist);
	
		
	}
	
}

/*
	Q. 배열 안에 8이 있으면 true, 없으면 false를 출력하는 코드
	
	// 수정 전 코드
	for(int i=0; i<l.length; i++){
			if(l[i] == find){
				System.out.print("true");
				a = 1;
				break;
			}
		}
	if(a == 0){
			System.out.print("false");
		}
	
*/