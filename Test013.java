public class Test013{
	public static void main(String[] args){
		int total = 1000000;
		int in = 0;
		for(int i=0; i<total; i++){
			double a = Math.random();
			double b = Math.random();
			double c2 = a*a + b*b;
			if(c2>1.0) {
			} else{
				in++;
			}
		}
		System.out.println( (in*1.0) / total * 4 );
		
	}
}

/*
	Math.random() : 0에서 1 사이의 임의의 소수를 발생시킨다. 소수니까 double 형임.
	for(int i=0; i<10; i++){
			double r = Math.random();
			System.out.println(r);
		}
	
	Math.random()을 통해 통계적으로 pi를 증명하자
	1/4 * pi : 1 = 부채꼴 안에 있는 점 개수 : 정사각형 안에 있는 점 개수
	즉 pi = 4 * 부채꼴 안에 있는 점 개수 / 정사각형 안에 있는 점 개수
	c2는 double이므로 1.0과 같다고 하면 잘 나오지않기 때문에, 1.0보다 크다고 조건문을 세운다.
	total(정사각형 안에 있는 점 개수)를 정하고, 만약 그 점이 부채꼴 안에도 있다면 in 개수를 하나 증가시킴.
	그렇게 total과 in의 점 비율을 계산하여 pi를 산출.
*/