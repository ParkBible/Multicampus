public class Test017{
	public static void main(String[] args){
		int[] l = new int[]{3,7,9,10};
		int[] l2 = new int[5];
		l[0] = 3;
		l[1] = 7;
		l[2] = 9;
		l[3] = 10;
		System.out.println(l[0]); //3
		System.out.println(l2[4]); //0
	}
}

/* 
	l�� �������� �ƴ϶�, ������ ����
	������ �ڷ����� ������ �������� Ȯ���� �������� �迭�̶�� �Ѵ�.
	4���� �������� Ȯ���Ǿ� �ְ�, l[0]~l[3]���� ���еǸ� ���� ���� ������ �� �ִ�.
	���� �迭�� �ڵ����� �ʱⰪ�� �ο��Ѵ�.(0, 0.0, false)
*/