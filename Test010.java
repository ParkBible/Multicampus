public class Test010 {
	public static void main(String[] args){
		for(int i=0; i<5; i++){
			System.out.println(i);
		}
		
		//System.out.println(i);	// ����
		
		for(int i=0; i<2; i++){
			for(int k=0; k<3; k++){
				System.out.println(k);
			}
		}
		
	}
}

/*
	cannot find symbol : �̸��� �ش��ϴ� ����� �� ã�´�. �� i�� ���ǰ� �Ǿ����� �ʴ�.
	���� i�� �߰�ȣ ���������ۿ� ������ �ʴ� ����.
	for���� �ȿ� for ������ ���� ����... ���� �����ϱ� �⺻�� ö���� ����.
*/