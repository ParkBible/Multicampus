public class Test011 {
	public static void main(String[] args){
		int len = 5;
		
		for(int i=0; i<len; i++){
			for(int k=0; k<i; k++){
			System.out.print("*");
			}
			System.out.println("");
		}
		for(int i=0; i<len; i++){
			for(int k=len; k>i; k--){
			System.out.print("*");
			}
			System.out.println("");
		}
	}
}

/*
	for(int i=0; i<5; i++){
		for(int j=0; j<(i+1); j++){
			System.out.print("*");
		}
		System.out.println("");
	}
	
	for(int i=0; i<(5-1); i++){
		for(int j=0; j<(5-1-i); j++){
			System.out.print("*");
		}
		System.out.println("");
	}
*/

/*
	����� �ڵ� ��
	1. ũ�� ����, �ѹ��� �ϳ��� ����
	2. ������ �ڵ�� ���� �Ƴ��� �� �ƴϴ�
	
*/