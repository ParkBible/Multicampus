
import apple.��Ű��;

public class Test101{
	public static void main(String[] args){
		��Ű�� t = new ��Ű��();
		//System.out.println(t.rivate); ���پȵ�
		//System.out.println(t.rotected); protected�� ���پȵ�
		System.out.println(t.ublic);
		//System.out.println(t.riendly);  friendly�� ���پȵȴ�
	}
}



/*
	�ٸ� ��Ű���� �ִ� Ŭ������ ����Ҷ��� import ��Ű���� ����Ѵ�.
	������ �� Ŭ������ �ٸ��� ������ �� ��ġ�� ������/����� -classpath�� �����ؾ� �Ѵ�.
	javac -classpath c:/classes Test101.java
	
	java -classpath .;c:/classes  Test101
	
	Test101.class�� JavaWork���� ã�ƾ� �ϴ� . �� ��ο� �߰��Ѵ�.
*/