#include <stdio.h>

int add(int i, int j){
	return 100;
}

int main(){
	int a;
	a = add(10, 20);
	printf("%d\n", a);
	return 0;
}

/*
	이 코드는 통째로 외운다. 설명까지
	add(10,20)과 int add(int i, int j){return 100;} 이 두개는 연관이 있고,
	add에서 return되는 값 100과 a는 연관이 있다.
*/