package banana;

import static banana.Temp.print;

class Temp{
	public static void print(){
		System.out.println("print");
	}
}

/*
	static import�� ����� class�� �ƴ϶� class �ȿ� ����� static �Լ��̰�
	��ġ c���� �Լ�ȣ�� �ϵ��� static�� �Լ��� �Լ������� ȣ���� �� �ִ�.(jdk 1.5����)
*/

public class Test184{
	public static void main(String[] args){
		print();
	}
}

/*
	������ �ֻܼ��� ��ɾ ���Ϸ� �������� �����ϴ� ��
	�����쿡���� ��ġ����( *.bat ), ���н������� �� ���α׷���( *.sh )
	
	@ECHO OFF
	REM cmdâ���ٰ� c��� �ĵ� �� ��� ����� ����ȴ�.
	REM c.bat (�̰Ŵ� �ּ���) ���⼱ �����ø� ����. ECHO OFF��� ġ�� ���� ������� �ȳ��´�. �׸��� �տ� �����ġ�� ECHO OFF�� �ȳ���
	REM ECHO ON ���ָ� �� �ؿ� �ٵ��� ����.
	REM %1 : ��ġ���� ����� �ܺο��� ���޵Ǵ� ù��° ���ڰ�. ������� c Test184 ��� �ϸ� %1�� Test184. 

	REM �̰� ��������.
	SET CPATH=c:/classes

	@ECHO ON
	javac -d %CPATH% %1.java
	java -classpath c:/classes banana.%1
	
*/