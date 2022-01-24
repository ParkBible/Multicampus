
public class Test182{
	public static void main(String[] args){
		int i = Integer.parseInt("100");
		System.out.println(i+1);
		
		double j = Double.parseDouble("3.1416");
		System.out.println(j+0.1);
		
		double r = Math.sqrt(2.0);
		System.out.println(r);
		
		double u = Math.sin(30 * 3.1416 / 180.0);    // 사인30도
		System.out.println(u);
		
		u = Math.sin(Math.toRadians(30.0));    // 사인30도
		System.out.println(u);
	}
}

/*
	static 함수이기에 인스턴스 없이 곧바로 사용가능
	Math.sqrt : 수학에서 루트 구하는거
	Math.sin : 라디안으로 변환해서 쓴다. (*PI / 180)
*/