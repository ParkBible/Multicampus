public class Test024{
	public static void main(String[] args){
		String t = "HelloWorld";
		System.out.println(t);
		
		char i = '��';
		
		char[] j = "HelloWorld".toCharArray();
		
		for(int p=0; p<j.length; p++){
			System.out.println(j[p]);
		}
		
	}
}

/*
	"HelloWorld"
	1. char�� �ڷ���������, String�� �ڷ����� �ƴ� Ŭ�����̴�.
	2. char�� 1���� ���ڿ� �ش��ϴ� �ڵ尪(�ƽ�Ű�ڵ�)�� ������ �� �ִ� ���������� �����ϴ�.
	3. String�� ""�� ���� ���ڿ�(0�� �̻��� ������ ����)�� ������ �� �ִ� ���������� �����ϴ�.
	��� t�� �������� �ƴϰ� �������̴�.(�迭ó��...)
*/