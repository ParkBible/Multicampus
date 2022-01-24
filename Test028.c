#include <stdio.h>

int main(){
	int i;
	i = 100;
	i = i + 1;
	printf("%d\n", i);
	printf("HelloWorld\n");

	return 0;
}

/*
	컴파일 하는 방법 : exe는 생성되는 실행파일 명
	gcc Test028.c -o test.exe
	실행 방법 :
	test.exe
	
	변수의 선언 대입 연산 다 있는데(자바와 동일), 변수 선언은 코드 위쪽으로 몰아서 해주어야 함.
	정통 문법은 선언하면서 초기값을 안준다. 일단 선언하고 나중에 대입해야됨
	
	int i;
	printf("헬로월드~");
	int j;
	
	이런거 에러남.
*/