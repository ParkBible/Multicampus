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
	�����Ͱ� �����Ҹ� ����ų �� �ִٸ� ���ú��� ������ ���� Ȯ���� ������ �����Ͱ� ������ �����ұ�?
	 -->����.
	 
	p = &i;
	' i��� �̸��� ���� ������ �������� p�� �Ͽ��� ����Ű�� �϶�. '�� �ǹ�.
	
	gcc Test039.c -o test.exe
*/