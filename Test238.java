package banana;

import static banana.Logic.*;

// ���� import ����� Ŭ�����ε� import static�� static�ϰ� ����� �Լ��� ������� �Ѵ�.

class Logic{
	public static int apple(int i){
		if(i!=0)
			return i * apple(i-1);
		else
			return 1;
	}
}

public class Test238{
	public static void main(String[] args){
		int r = apple(5);
		System.out.println(r);
	}
}

/*
	javac -d c:\classes Test236.java
	java -classpath c:\classes banana.Test238
	
	
	int r = apple(5);
	return 5*apple(4);
	return 4*apple(3);
	return 3*apple(2);
	return 2*apple(1);
	return 1*1

	5*4*3*2*1*1 �� ������ ������?.. �´�!
	���ϰ��� ����ؼ� �Ž��� �ö󰡴� ����.
*/