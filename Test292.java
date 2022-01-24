class TempVO {
	public int data = 100;
	public int getData(){ return data; }
}

class Temp2VO extends TempVO {
	public int data = 200;
	public int getData(){ return data; }
}

public class Test292 {
	public static void main( String[] args ) {
		TempVO t = new Temp2VO();
		System.out.println( t.data );
		System.out.println( t.getData() );
		
		Temp2VO t2 = (Temp2VO)t;
		System.out.println( t2.data );
	}
}


/*
	������ ����? �Լ��� �ڼ�?
	�ű⿡ ĳ������ �ϰ��ϱ� ���� ���Ѵ�.
	
	��������� ����� public�ϰ� �����ϵ��� ���� �ʴ´�.
	�׷��� ��������� private / protected�ϰ� �����Ѵ�.
	�׷� ��� ���� �а� ����?
	getter�Լ��� �Ἥ �а� setter �Լ��� �Ἥ ����.
	
	public String getData()[return data;}    // getter
	public void setData(String i){return this.data = i;}    // setter
	
	getter�� get+���������(ù���� �빮��) + ������ ���� �ڷ��� ����Ÿ�� + �Ű����� ����
	setter�� set+���������(ù���� �빮��) + void ����Ÿ�� + �Ű������� ������ ���� �ڷ���
	������� + getter + setter�� ���� property ��� �θ��⵵ �Ѵ�.
	
	DTO : Data Transfer Object
	VO : Value Object
	�Ѵ� �����͸� ��� �뵵�� ����Ѵ�. �� ������ ������µ� ���ǿ����� VO�� ���ٰ� �Ѵ�.
	VO������ int ���� Integer�� ����Ѵ�.
	DB���� int�� �ʵ忡 NULL ���� �� �� �ִµ� int r = null; �̰� �Ұ���������
	Integer r = null; �̰� �����ϴ�. ���� DB�� �����Ǵ� VO���� int double �Ⱦ���
	Integer, Double�� ����ϴ� ���� �⺻���� �Ѵ�.
*/