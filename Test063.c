#include <stdio.h>

int add(int i, int j){
	return 100;
}

int add_v2(int i, int j){
	return 102;
}

int main(){
	int (*fp)(int, int); // 함수포인터. 리턴타입이 int, 매개변수가 (int, int)인 add라는 함수를 가리키는 변수이다.
	fp = add;
	fp = add_v2;  // 형식만 맞다면 가리키는 함수의 변경도 자유롭다!(출력부분 수정 불필요)
	printf("%d\n", fp(10, 20));
	return 0;
}

/*
	개발현장에서 보니까 도사급 인력은 이 두가지를 기가 막히게 쓰더라...
	1. void 포인터
	2. 함수(function) 포인터
	
	이거 모르면 js 잘 못씀...
*/