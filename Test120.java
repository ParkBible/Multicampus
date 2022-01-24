
interface ICallback{
	public void onEvent(int i);
}

class Button{
	public void onClick(ICallback cb){
		System.out.println("onClick ...");    // onclick�ؼ� �� ���� �������ٰ� �ϸ�
		if(cb != null){    // ȣ����� ��
			cb.onEvent(100);   // 'ȣ���� ���� �������̵��� �Լ�'�� ȣ�� 
		}
	}
}

public class Test120{
	public static void main(String[] args){
		Button btn = new Button();
		btn.onClick(new ICallback(){    // anonymous Ŭ���� ���� ��ü�� onclick �Լ� �ȿ� �������
			public void onEvent(int i){    // ICallback �ȿ� �ִ� onEvent�� �������̵��Ѱ�.
				System.out.println("onEvent XX " + i);   // ȣ����� �ʿ��� ȣ���� ���� �������̵��� �Լ��� ȣ����.(callback ���)
			}
		});
	}
}