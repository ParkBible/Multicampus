
public class Test157{
	public static void main(String[] args){
		String t = "HelloWorld";
		String r = "HelloWorld";
		System.out.println(r == t);    // ����. t�� r�� ���� �ν��Ͻ��� ����Ű�� �ִٴ� ��.
		
		String l = t.substring(2,5);
		System.out.println(l);
		
		// llo?? HelloWorld?
		System.out.println(r);    // HelloWorld
		
	}
}

/*
	�������� �񱳴� ���� �ν��Ͻ��� ����ų�� ==�� true ���´�.(������ �������� �ƴ�. �׶� equals)
	substring�� ����Ű�� ���ڿ��� ������ �����ϴ� ���¸� llo
	substring�� ���ο� ���ڿ��� ������ ���¸� HelloWorld�̴�.
	
	����Ǵ� �ν��Ͻ��� �Ժη� ������ �ٲٸ� ���� ���� ���� �ִµ� ���ڱ� ������ ���� �� �ֱ⿡
	�Ժη� �����ϸ� �ȵȴ�.
	
	�׷��� string�� ��� �޼ҵ���� ������ �ٲ��� �ʴ� ���·� �����Ѵ�.
*/