
public class Test156{
	public static void main(String[] args){
		for(int i=0; i<5000000; i++){
			String t = "HelloWorld";
			t = null;
		}
	}
}

/*
	�������ݷ����� �����ϸ� ���� �ڵ�� ��û���� ���� �޸� �Ҹ� ������̴�.
	100������ HelloWorld �ν��Ͻ��� �����������ٵ�...
	
	javac Test156.java
	java -verbosegc Test156
	
	-verbosegc : �޸𸮰� ���ڶ� ������� ��ư� �ν��Ͻ��� �Ҹ��ų ��
	�� ��� Ƚ���� �������� �޸� �Ҹ� ���� ���α׷��� �ȴ�.
	String t = "HelloWorld"; �� �޸� �Ҹ� ���� ������,
	String t = "HelloWorld" + i; �� �޸� �Ҹ� ����.
	
	���ϱ�?
	String�� "..." ������ �ν��Ͻ��� ��쿡 ���ؼ� �ѹ� ������ �ν��Ͻ��� ��Ȱ���Ѵ�.(�ſ� �߿�)
	������ t�� �����ؼ� String Pool�� �ִ� �Ȱ��� "HelloWorld"�� �����״ٰ� �������ٰ� �Ѵ�.
	
	������ "HelloWorld" + i�� �ϳ��� ������� ��ư��ٰ� �޸𸮼Ҹ� ���� �� ��ƸԾ����.
	��Ƹ����� -verbosegc���� ���� ����.
	���� : [GC (Allocation Failure)  49152K->788K(186880K), 0.0012932 secs]
*/