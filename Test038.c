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
	int i; - int�� ���� �ϳ� ���� ������ ������ ����
	int* i; - int�� �������� ����ų �� �ִ� ������ ����
	
	gcc Test038.c -o test.exe
	
	int* i;
	i = (int*)malloc(sizeof(int));
	*i = 100;
	
	malloc(sizeof(int));
	- �޸𸮸� Ȯ���Ѵ�. �־��� ũ�⸸ŭ. ��, int�� �����ŭ
	i = (int*)malloc(sizeof(int));
	
	*i = 100
	�� ��쿡�� *i(i ������) �� ����Ű�� ������ 100�� �ִ°�.
	
	printf("%d\n", *i);
	i �����Ͱ� ����Ű�� ����, �� ���� �ȿ� �������� ���� ������� �ǹ�.
	
	free(i);
	i �����Ͱ� ����Ű�� ������ �Ұ�.
	��, malloc���� Ȯ���� ������ �� �ڵ�� ���� �Ұŵǰ�, i��� ���� ��ü�� ���ú����̹Ƿ� main�� ���� �� �Ұŵ�.
*/