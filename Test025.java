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
	Q. �� ���� �迭�� ����ִ� ���ڿ��� �����ϸ� true, �ƴϸ� false�� ��µǰ� ��.
	A. �켱, �� ���ڿ��� ���̸� ���Ѵ�. ���� ���̰� �����ϸ� ���� ��ġ�� �ִ� ���ڳ��� ���Ѵ�.
	�ϳ��� �ٸ��� �� �޺κ��� ���� �ʿ䰡 ���⿡ �ٷ� break�� ��������.(����)
*/