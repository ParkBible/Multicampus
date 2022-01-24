#include <stdio.h>

int main(){
	int i;
	int* p;
	int* t;

	i = 100;
	p = &i;
	
	t = p;
	
	printf("%d\n", i);
	printf("%d\n", *p);
	printf("%d\n", *t);
	return 0;
}

/*
	포인터가 기억장소를 가리킬 수 있다면 로컬변수 선언을 통해 확보된 공간도 포인터가 접근이 가능할까?
	 -->ㄱㄴ.
	 
	p = &i;
	' i라는 이름을 가진 변수의 기억공간을 p로 하여금 가리키게 하라. '는 의미.
	
	gcc Test039.c -o test.exe
*/