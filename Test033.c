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
	�� �ڵ�� ��°�� �ܿ��. �������
	add(10,20)�� int add(int i, int j){return 100;} �� �ΰ��� ������ �ְ�,
	add���� return�Ǵ� �� 100�� a�� ������ �ִ�.
*/