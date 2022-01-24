public class Test017{
	public static void main(String[] args){
		int[] l = new int[]{3,7,9,10};
		int[] l2 = new int[5];
		l[0] = 3;
		l[1] = 7;
		l[2] = 9;
		l[3] = 10;
		System.out.println(l[0]); //3
		System.out.println(l2[4]); //0
	}
}

/* 
	l은 변수명이 아니라, 포인터 변수
	동일한 자료형의 변수가 연속으로 확보된 기억공간을 배열이라고 한다.
	4개의 기억공간이 확보되어 있고, l[0]~l[3]으로 구분되며 각각 값을 대입할 수 있다.
	또한 배열은 자동으로 초기값을 부여한다.(0, 0.0, false)
*/