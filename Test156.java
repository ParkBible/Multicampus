
public class Test156{
	public static void main(String[] args){
		for(int i=0; i<5000000; i++){
			String t = "HelloWorld";
			t = null;
		}
	}
}

/*
	가베지콜렉션을 생각하면 위의 코드는 엄청나게 많은 메모리 소모를 만들것이다.
	100만개의 HelloWorld 인스턴스가 잡혀갈것일텐데...
	
	javac Test156.java
	java -verbosegc Test156
	
	-verbosegc : 메모리가 모자라서 개장수가 잡아간 인스턴스를 소멸시킬 때
	이 결과 횟수가 많을수록 메모리 소모가 많은 프로그램이 된다.
	String t = "HelloWorld"; 는 메모리 소모가 거의 없지만,
	String t = "HelloWorld" + i; 는 메모리 소모가 많다.
	
	왜일까?
	String은 "..." 생성한 인스턴스의 경우에 한해서 한번 생성한 인스턴스를 재활용한다.(매우 중요)
	포인터 t를 생성해서 String Pool에 있는 똑같은 "HelloWorld"를 가리켰다가 없어졌다가 한다.
	
	하지만 "HelloWorld" + i는 하나씩 개장수가 잡아갔다가 메모리소모가 많을 때 잡아먹어버림.
	잡아먹으면 -verbosegc에서 한줄 찍음.
	예시 : [GC (Allocation Failure)  49152K->788K(186880K), 0.0012932 secs]
*/