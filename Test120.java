
interface ICallback{
	public void onEvent(int i);
}

class Button{
	public void onClick(ICallback cb){
		System.out.println("onClick ...");    // onclick해서 뭔 일이 벌어진다고 하면
		if(cb != null){    // 호출당한 쪽
			cb.onEvent(100);   // '호출한 쪽이 오버라이딩한 함수'를 호출 
		}
	}
}

public class Test120{
	public static void main(String[] args){
		Button btn = new Button();
		btn.onClick(new ICallback(){    // anonymous 클래스 동작 전체를 onclick 함수 안에 집어넣음
			public void onEvent(int i){    // ICallback 안에 있는 onEvent를 오버라이딩한것.
				System.out.println("onEvent XX " + i);   // 호출당한 쪽에서 호출한 쪽이 오버라이딩한 함수를 호출함.(callback 기법)
			}
		});
	}
}