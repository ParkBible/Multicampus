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
	Q. �迭 �ȿ� 8�� ������ true, ������ false�� ����ϴ� �ڵ�
	
	// ���� �� �ڵ�
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