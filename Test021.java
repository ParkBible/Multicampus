public class Test021{
	public static void main(String[] args){
		for(int i=0; i<5; i++){
			System.out.println("Apple " + i);
			if(i == 3){
				System.out.println("Kiwi");
			}
			System.out.println("Banana " + i);
		}
	}
}
/*
	문자열을 이어붙이려면 + 기호를 쓴다.
	break는 반복문 안에서만 쓸 수 있으며, for문 밖으로 강제로 빠져나오는 명령어이다.
	continue를 만나면 그 밑의 남은 코드를 실행하지 않고 바로 변수를 1 더하여(i++), 다음 루프를 시작한다
	
	gcc.exe 더블클릭 후 압축풀기
	C:\gcc\Bin 을 시스템 환경변수에 등록 : 원래는 cmd창을 다시 열어야되는데 Path에 등록된 폴더 아래의 실행파일은 경로를 다 입력하지 않아도 실행 가능.
	똑같은 이름의 파일이 여러개 있다면 위쪽 경로에 있는 파일이 실행됨.
	
*/