public class Test014{
	public static void main(String[] args){
		int money = 100;
		int years = 100;
		double rate = 0.066;
		
		double total = money;
		for(int i=0; i<years; i++){
			total = total + (total * rate);
		}
		System.out.println(total);
	}
}

/*
	money = money + money * rate; // int�� ������ �Ǽ��� �־����Ƿ� ����
	money = (int)(money + money * rate) // ���������� ���� ��
*/