#include <stdio.h>

int main(){
	int* i;
	
	i = (int*)malloc(sizeof(int));
	*i = 100;
	printf("%d\n", *i);
	
	free(i);
	
	return 0;
}

/*
	int i; - int형 값을 하나 보관 가능한 변수를 선언
	int* i; - int형 기억공간을 가리킬 수 있는 변수를 선언
	
	gcc Test038.c -o test.exe
	
	int* i;
	i = (int*)malloc(sizeof(int));
	*i = 100;
	
	malloc(sizeof(int));
	- 메모리를 확보한다. 주어진 크기만큼. 즉, int의 사이즈만큼
	i = (int*)malloc(sizeof(int));
	
	*i = 100
	이 경우에는 *i(i 포인터) 가 가리키는 공간에 100을 넣는것.
	
	printf("%d\n", *i);
	i 포인터가 가리키는 공간, 그 공간 안에 보관중인 값을 찍으라는 의미.
	
	free(i);
	i 포인터가 가리키는 공간을 소거.
	즉, malloc으로 확보된 공간은 이 코드로 인해 소거되고, i라는 변수 자체는 로컬변수이므로 main이 끝날 때 소거됨.
*/