
public class Test182{
	public static void main(String[] args){
		int i = Integer.parseInt("100");
		System.out.println(i+1);
		
		double j = Double.parseDouble("3.1416");
		System.out.println(j+0.1);
		
		double r = Math.sqrt(2.0);
		System.out.println(r);
		
		double u = Math.sin(30 * 3.1416 / 180.0);    // ����30��
		System.out.println(u);
		
		u = Math.sin(Math.toRadians(30.0));    // ����30��
		System.out.println(u);
	}
}

/*
	static �Լ��̱⿡ �ν��Ͻ� ���� ��ٷ� ��밡��
	Math.sqrt : ���п��� ��Ʈ ���ϴ°�
	Math.sin : �������� ��ȯ�ؼ� ����. (*PI / 180)
*/